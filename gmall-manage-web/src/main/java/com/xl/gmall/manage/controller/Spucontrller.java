package com.xl.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xl.gmall.bean.PmsProductImage;
import com.xl.gmall.bean.PmsProductInfo;
import com.xl.gmall.bean.PmsProductSaleAttr;
import com.xl.gmall.manage.util.PmsUploadUtil;
import com.xl.gmall.service.PmsProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/5 16:20
 * @Description: com.xl.gmall.manage.controller
 * @version: 1.0
 */
@Controller
@CrossOrigin
public class Spucontrller {

    @Reference
    PmsProductService pmsProductService;

    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id) {
        List<PmsProductInfo> pmsProductInfos = pmsProductService.spuList(catalog3Id);
        return pmsProductInfos;
    }

    /**
     * spu的图片保存
     * @param multipartFile
     * @return
     */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        //将图片或视频上传到分布式的文件存储系统
        //将图片或视频的路径返回给页面
        String imageurl= PmsUploadUtil.uploadImage(multipartFile);
        System.out.println(imageurl);
        return imageurl;
    }

    /**
     * spu的保存
     * @param pmsProductInfo
     * @return
     */
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        pmsProductService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    /**
     * 销售属性值
     * @param spuId
     * @return
     */
    @RequestMapping("spuSaleAttrList")
    @ResponseBody
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        List<PmsProductSaleAttr> productSaleAttrList=  pmsProductService.spuSaleAttrList(spuId);
        return productSaleAttrList;
    }

    /**
     * 查找销售平台照片
     * @param spuId
     * @return
     */
    @RequestMapping("/spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList(String spuId) {
        List<PmsProductImage> pmsProductImages=  pmsProductService.spuImageList(spuId);
        return pmsProductImages;
    }
}
