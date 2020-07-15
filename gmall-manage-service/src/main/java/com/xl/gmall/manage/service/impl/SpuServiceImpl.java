package com.xl.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.xl.gmall.bean.PmsProductImage;
import com.xl.gmall.bean.PmsProductInfo;
import com.xl.gmall.bean.PmsProductSaleAttr;
import com.xl.gmall.bean.PmsProductSaleAttrValue;
import com.xl.gmall.manage.mapper.PmsProductImageMapper;
import com.xl.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.xl.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.xl.gmall.manage.mapper.SpuProductMapper;
import com.xl.gmall.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/5 16:39
 * @Description: com.xl.gmall.manage.service.impl
 * @version: 1.0
 */
@Service
public class SpuServiceImpl  implements PmsProductService {
    @Autowired
    SpuProductMapper spuProductMapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;
    /**
     * 查询PmsProductInfo
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo =new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfos = spuProductMapper.select(pmsProductInfo);
        return pmsProductInfos;
    }

    /**
     * spu商品保存
     * @param pmsProductInfo
     */
    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        // 保存商品信息
        spuProductMapper.insertSelective(pmsProductInfo);

        // 生成商品主键
        String productId = pmsProductInfo.getId();

        // 保存商品图片信息
        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : spuImageList) {
            pmsProductImage.setProductId(productId);
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }

        // 保存销售属性信息
        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
            pmsProductSaleAttr.setProductId(productId);
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);

            // 保存销售属性值
            List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : spuSaleAttrValueList) {
                pmsProductSaleAttrValue.setProductId(productId);
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }
        }

    }

    /**
     * 销售属性值
     * @param spuId
     * @return
     */
    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();
        pmsProductSaleAttr.setProductId(spuId);
        List<PmsProductSaleAttr> productSaleAttrs = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);
        for (PmsProductSaleAttr productSaleAttr : productSaleAttrs) {
            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();
            pmsProductSaleAttrValue.setProductId(spuId);
            pmsProductSaleAttrValue.setSaleAttrId(productSaleAttr.getSaleAttrId());//销售属性id用的是字典表的id不是主键id
            List<PmsProductSaleAttrValue> attrValues = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);
            productSaleAttr.setSpuSaleAttrValueList(attrValues);
        }
        return productSaleAttrs;
    }

    /**
     * 销售属性图片
     * @param spuId
     * @return
     */
    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        PmsProductImage pmsProductImage = new PmsProductImage();
        pmsProductImage.setProductId(spuId);
        List<PmsProductImage> productImagess = pmsProductImageMapper.select(pmsProductImage);
        return productImagess;
    }

    /**
     * spu查询列表属性
     * @param productId
     * @return
     */
    @Override
    public List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId,String skuId) {
       /* PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();
        pmsProductSaleAttr.setProductId(productId);
        List<PmsProductSaleAttr>  productSaleAttrs = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);
        for (PmsProductSaleAttr productSaleAttr : productSaleAttrs) {
            String saleAttrId = productSaleAttr.getSaleAttrId();
            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();
            pmsProductSaleAttrValue.setSaleAttrId(saleAttrId);
            pmsProductSaleAttrValue.setProductId(productId);
            List<PmsProductSaleAttrValue> select = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);
            productSaleAttr.setSpuSaleAttrValueList(select);
        }*/
        List<PmsProductSaleAttr>  productSaleAttrs = pmsProductSaleAttrMapper.selectSpuSaleAttrListCheckBySku(productId,skuId);
        return productSaleAttrs;
    }


}
