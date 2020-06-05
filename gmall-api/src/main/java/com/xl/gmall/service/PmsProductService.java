package com.xl.gmall.service;

import com.xl.gmall.bean.PmsProductInfo;

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
}
