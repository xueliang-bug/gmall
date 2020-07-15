package com.xl.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.xl.gmall.bean.PmsSkuAttrValue;
import com.xl.gmall.bean.PmsSkuImage;
import com.xl.gmall.bean.PmsSkuInfo;
import com.xl.gmall.bean.PmsSkuSaleAttrValue;
import com.xl.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.xl.gmall.manage.mapper.PmsSkuImageMapper;
import com.xl.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.xl.gmall.manage.mapper.SkuMapper;
import com.xl.gmall.service.SkuService;
import com.xl.gmall.util.RedisUtil;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Administrator
 * @Date: 2020/6/10 15:05
 * @Description: com.xl.gmall.manage.service.impl
 * @version: 1.0
 */
@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    SkuMapper skuMapper;
    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;
    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;
    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;
    @Autowired
    RedisUtil redisUtil;
    /**
     * 保存sku
     * @param pmsSkuInfo
     */
    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        PmsSkuInfo pmsSkuInfo1 = new PmsSkuInfo();
        //插入pmsinfo
        int i = skuMapper.insertSelective(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();
        //插入平台属性
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }
        //插入销售关联属性
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuId);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }
        //插入图片信息
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(skuId);
            pmsSkuImageMapper.insertSelective(pmsSkuImage);
        }
    }

    public PmsSkuInfo getByskuIdFromDb(String skuId) {
        //sku的商品对象
        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        pmsSkuInfo.setId(skuId);
        PmsSkuInfo SkuInfo = skuMapper.selectOne(pmsSkuInfo);
        if (SkuInfo==null){
            return null;
        }
        //sku查询相片列表
        PmsSkuImage pmsSkuImage = new PmsSkuImage();
        pmsSkuImage.setSkuId(skuId);
        List<PmsSkuImage> select = pmsSkuImageMapper.select(pmsSkuImage);
        SkuInfo.setSkuImageList(select);
        return SkuInfo;
    }
    /**
     * 根据id查询PmsSkuInfo属性带缓存redis原生
     * @param skuId
     * @return
     */
   /* public PmsSkuInfo getByskuId_redis(String skuId) {
        PmsSkuInfo pmsSkuInfo = null;
        //连接缓存
        Jedis jedis = redisUtil.getJedis();
        //查询缓存
        String skukey="sku:"+skuId+":info";
        String skujson = jedis.get(skukey);
        if (skujson!=null){
            if (!"EMPTY".equals(pmsSkuInfo)){
                System.out.println(Thread.currentThread()+"命中缓存");
                pmsSkuInfo = JSON.parseObject(skujson,PmsSkuInfo.class);
            }

        }else {
            //定义锁
            *//*Long locked = jedis.setnx("sku:" + skuId + ":lock", "locked");
            jedis.expire("sku:" + skuId + ":lock",10);*//*
            String token= UUID.randomUUID().toString();
            //设置锁
            String lockkey="sku:"+skuId+":lock";
            String locked = jedis.set(lockkey, token, "NX", "EX", 10);
            if ("OK".equals(locked)){
                System.out.println(Thread.currentThread()+"得到锁");
                pmsSkuInfo = getByskuIdFromDb(skuId);
                System.out.println(Thread.currentThread()+"写入缓存");
                String jsonString=null;
                if (pmsSkuInfo!=null){
                    jsonString = JSON.toJSONString(pmsSkuInfo);
                }else {
                    jsonString="EMPTY";
                }

                jedis.setex(skukey,10,jsonString);
                System.out.println(Thread.currentThread()+"释放锁");
                if (jedis.exists(lockkey) && token.equals(jedis.get(lockkey))){//不完美用lua解决
                    jedis.del(lockkey);
                }
            }else {
                //没有拿到锁睡一下
                System.out.println(Thread.currentThread()+"未得到锁，开始自旋等待");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //调自己去查询
              return getByskuId(skuId);
            }
        }
        jedis.close();
        return pmsSkuInfo;
    }*/

    @Override
    public PmsSkuInfo getByskuId(String skuId) {
        PmsSkuInfo pmsSkuInfo = null;
        //连接缓存
        Jedis jedis = redisUtil.getJedis();
        //查询缓存
        String skukey = "sku:" + skuId + ":info";
        String skujson = jedis.get(skukey);
        if (skujson != null) {
            if (!"EMPTY".equals(pmsSkuInfo)) {
                System.out.println(Thread.currentThread() + "命中缓存");
                pmsSkuInfo = JSON.parseObject(skujson, PmsSkuInfo.class);
            }

        } else {
            Config config = new Config();
            config.useSingleServer().setAddress("redis://192.168.214.128:6379");
            RedissonClient client = Redisson.create(config);
            String lockkey = "sku:" + skuId + ":lock";
            RLock lock = client.getLock(lockkey);
            //lock.lock(10, TimeUnit.SECONDS);
            boolean tryLock=false;
            try {
              tryLock = lock.tryLock(10, 5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tryLock){
                System.out.println(Thread.currentThread() + "得到锁");
            //如果得到锁后能在缓存中查询，不用去再查询数据库
            String jsonString = jedis.get(skukey);
            if (jsonString != null) {
                if (!"EMPTY".equals(jsonString)) {
                    System.out.println(Thread.currentThread() + "命中缓存");
                    pmsSkuInfo = JSON.parseObject(jsonString, PmsSkuInfo.class);
                }
            } else {
                //如果第一个进来去查数据库
                pmsSkuInfo = getByskuIdFromDb(skuId);
                System.out.println(Thread.currentThread() + "写入缓存");
                if (pmsSkuInfo != null) {
                    jsonString = JSON.toJSONString(pmsSkuInfo);
                } else {
                    jsonString = "EMPTY";
                }

                jedis.setex(skukey, 10, jsonString);
                lock.unlock();
            }
            }
        }
        return pmsSkuInfo;
    }
    /**
     * sku的hash表的查询
     * @param productId
     * @return
     */
    @Override
    public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId) {
        List<PmsSkuInfo> pmsSkuInfos=  skuMapper.selectSkuSaleAttrValueListBySpu(productId);
        return pmsSkuInfos;
    }
     //查询所有的sku
    @Override
    public List<PmsSkuInfo> getAllSku(String catalog3Id) {
        List<PmsSkuInfo> pmsSkuInfoList = skuMapper.selectAll();
        for (PmsSkuInfo pmsSkuInfo : pmsSkuInfoList) {
            String skuId = pmsSkuInfo.getId();
            PmsSkuAttrValue pmsSkuAttrValue=new PmsSkuAttrValue();
            pmsSkuAttrValue.setSkuId(skuId);
            List<PmsSkuAttrValue> pmsSkuAttrValues = pmsSkuAttrValueMapper.select(pmsSkuAttrValue);
            pmsSkuInfo.setSkuAttrValueList(pmsSkuAttrValues);
        }
        return pmsSkuInfoList;
    }
}
