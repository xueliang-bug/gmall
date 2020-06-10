package com.xl.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xl.gmall.bean.PmsSkuAttrValue;
import com.xl.gmall.bean.PmsSkuImage;
import com.xl.gmall.bean.PmsSkuInfo;
import com.xl.gmall.bean.PmsSkuSaleAttrValue;
import com.xl.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.xl.gmall.manage.mapper.PmsSkuImageMapper;
import com.xl.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.xl.gmall.manage.mapper.SkuMapper;
import com.xl.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
}
