package com.xl.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xl.gmall.bean.PmsProductInfo;
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
}
