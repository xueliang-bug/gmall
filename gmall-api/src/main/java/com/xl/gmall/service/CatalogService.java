package com.xl.gmall.service;

import com.xl.gmall.bean.PmsBaseCatalog1;
import com.xl.gmall.bean.PmsBaseCatalog2;
import com.xl.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/4 17:05
 * @Description: com.xl.gmall.service
 * @version: 1.0
 */
public interface CatalogService {

    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
