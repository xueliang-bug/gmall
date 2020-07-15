package com.xl.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.xl.gmall.bean.PmsProductSaleAttr;
import com.xl.gmall.bean.PmsSkuInfo;
import com.xl.gmall.bean.PmsSkuSaleAttrValue;
import com.xl.gmall.service.PmsProductService;
import com.xl.gmall.service.SkuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2020/6/10 17:31
 * @Description: com.xl.gmall.item.controller
 * @version: 1.0
 */
@Controller
public class ItemContorller {

    @Reference
    SkuService skuService;
    @Reference
    PmsProductService pmsProductService;
    /**
     * item.html的页面返回方法
     * @param skuId
     * @return
     */
    @RequestMapping("{skuId}.html")
    public String item(@PathVariable String skuId,ModelMap modelMap) {
       PmsSkuInfo pmsSkuInfo = skuService.getByskuId(skuId);
       //sku对象
        modelMap.put("skuInfo",pmsSkuInfo);
        //销售属性列表
       List<PmsProductSaleAttr> productSaleAttrs= pmsProductService.spuSaleAttrListCheckBySku(pmsSkuInfo.getProductId(),pmsSkuInfo.getId());
        modelMap.put("spuSaleAttrListCheckBySku",productSaleAttrs);
        //查询当前的sku和spu的sku集合的hash表
        Map<String, String> stringStringHashMap = new HashMap<>();
        List<PmsSkuInfo> pmsSkuInfoList= skuService.getSkuSaleAttrValueListBySpu(pmsSkuInfo.getProductId());
        for (PmsSkuInfo skuInfo : pmsSkuInfoList) {
             String k ="";
            String v = skuInfo.getId();
            List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : pmsSkuSaleAttrValueList) {
               k += pmsSkuSaleAttrValue.getSaleAttrValueId()+"|";
            }
            stringStringHashMap.put(k,v);
        }
         //将sku的销售属性的hash表放到页面
        String stringStringHashMapjsonstr = JSON.toJSONString(stringStringHashMap);
        modelMap.put("jsonstr",stringStringHashMapjsonstr);
        return "item";
    }



    /**
     * 页面测试方法
     * @param modelMap
     * @return
     */
    @RequestMapping("index")
    public String index(ModelMap modelMap) {
        List<String> list=new ArrayList();
        for (int i=0;i<5;i++){
            list.add("循环数据"+i);
        }
        modelMap.put("list",list);
        modelMap.put("hello","123456");
        modelMap.put("check","0");
        return "index";
    }
}
