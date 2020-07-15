package com.xl.gmall.service;

import com.xl.gmall.bean.PmsProductImage;
import com.xl.gmall.bean.PmsProductInfo;
import com.xl.gmall.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/5 16:38
 * @Description: com.xl.gmall.service
 * @version: 1.0
 */
public interface PmsProductService {
    //查询spu
    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);
   //查找销售属性值
    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);
    //销售属性照片
    List<PmsProductImage> spuImageList(String spuId);
     //查询列表属性
    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId,String skuId);
}
