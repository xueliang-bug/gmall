package com.xl.gmall.manage.mapper;

import com.xl.gmall.bean.PmsProductSaleAttr;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/9 16:56
 * @Description: com.xl.gmall.manage.mapper
 * @version: 1.0
 */
public interface PmsProductSaleAttrMapper extends Mapper<PmsProductSaleAttr> {
    //自定义属性列表查询的sql
    List<PmsProductSaleAttr> selectSpuSaleAttrListCheckBySku(@Param("productId") String productId,@Param("skuId") String skuId);
}
