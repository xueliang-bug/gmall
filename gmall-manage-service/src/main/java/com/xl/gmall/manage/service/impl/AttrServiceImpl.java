package com.xl.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xl.gmall.bean.PmsBaseAttrInfo;
import com.xl.gmall.bean.PmsBaseAttrValue;
import com.xl.gmall.manage.mapper.AttrMapper;
import com.xl.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.xl.gmall.service.AttrService;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/5 10:59
 * @Description: com.xl.gmall.manage.service.impl
 * @version: 1.0
 */
@Service
public class AttrServiceImpl implements AttrService {
    @Autowired
    AttrMapper attrMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    /**
     * 查询商品属性
     *
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> attrInfos = attrMapper.select(pmsBaseAttrInfo);
        return attrInfos;
    }

    /**
     * 添加商品属性
     *
     * @return pmsBaseAttrInfo
     */
    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        String id = pmsBaseAttrInfo.getId();
        if (StringUtils.isBlank(id)) {
            //id为空保存
            //保存属性
            attrMapper.insertSelective(pmsBaseAttrInfo); //insertSelective 值为空的不插入数据库
            //保存属性值
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            }
        } else {
            //id不为空修改
            //属性修改
            Example e = new Example(PmsBaseAttrInfo.class);
            e.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
            attrMapper.updateByExampleSelective(pmsBaseAttrInfo,e);
            //属性值修改
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            //按照属性id删除所有属性值
            PmsBaseAttrValue pmsBaseAttrValue=new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);
            //循环插入数据
            for (PmsBaseAttrValue pmsBaseAttrValues : attrValueList) {
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValues);
            }
        }

        return "success";
    }

    /**
     * 商品属性值修改
     * @param attrId
     * @return
     */
    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> select = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
        return select;
    }
}
