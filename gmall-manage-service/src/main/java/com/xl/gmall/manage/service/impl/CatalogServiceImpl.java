package com.xl.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xl.gmall.bean.PmsBaseCatalog1;
import com.xl.gmall.bean.PmsBaseCatalog2;
import com.xl.gmall.bean.PmsBaseCatalog3;
import com.xl.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.xl.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.xl.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.xl.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/4 17:09
 * @Description: com.xl.gmall.manage.service.impl
 * @version: 1.0
 */
@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;
    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;
    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    //一级分类
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }

    //二级分类
    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> pmsBaseCatalog2s = pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);
        return pmsBaseCatalog2s;
    }

    //三级分类
    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> pmsBaseCatalog3s = pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
        return pmsBaseCatalog3s;
    }

}
