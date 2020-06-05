package com.xl.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xl.gmall.bean.PmsBaseCatalog1;
import com.xl.gmall.bean.PmsBaseCatalog2;
import com.xl.gmall.bean.PmsBaseCatalog3;
import com.xl.gmall.service.CatalogService;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/4 16:21
 * @Description: com.xl.gmall.manage.controller
 * @version: 1.0
 */
@Controller
@CrossOrigin  //跨域访问注解
public class CatalogController {

    @Reference
    CatalogService catalogService;

    /**
     * 一级分类的查询
     * @return
     */
     @RequestMapping("getCatalog1")
     @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
         List<PmsBaseCatalog1> catalog1 = catalogService.getCatalog1();
        return catalog1;
    }

    /**
     * 二级分类的查询
     */
    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){
        List<PmsBaseCatalog2> catalog2 = catalogService.getCatalog2(catalog1Id);
        return catalog2;
    }
    /**
     * 三级分类的查询
     */
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){
        List<PmsBaseCatalog3> catalog3 = catalogService.getCatalog3(catalog2Id);
        return catalog3;
    }

}
