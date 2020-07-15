package com.xl.gmall.service;

import com.xl.gmall.bean.PmsSkuInfo;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/10 15:04
 * @Description: com.xl.gmall.service
 * @version: 1.0
 */
public interface SkuService {
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);
    //根据id去查询PmsSkuInfo
    PmsSkuInfo getByskuId(String skuId);
     //查询sku的hash表
    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);
    //查询所有的sku
    List<PmsSkuInfo> getAllSku(String catalog3Id);
}
