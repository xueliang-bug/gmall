package com.xl.gmall.manage.mapper;

import com.xl.gmall.bean.PmsSkuInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/10 15:07
 * @Description: com.xl.gmall.manage.mapper
 * @version: 1.0
 */
public interface SkuMapper extends Mapper<PmsSkuInfo> {
    //sku的hash表的查询
    List<PmsSkuInfo> selectSkuSaleAttrValueListBySpu(String productId);
}
