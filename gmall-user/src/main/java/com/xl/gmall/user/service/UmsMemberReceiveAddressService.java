package com.xl.gmall.user.service;

import com.xl.gmall.user.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/25 15:23
 * @Description: com.xl.gmall.user.service
 * @version: 1.0
 */
public interface UmsMemberReceiveAddressService {
    //查询所有
    List<UmsMemberReceiveAddress> findAllUmsMemberReceiveAddress();
    //添加
    void insertUmsMemberReceiveAddress(UmsMemberReceiveAddress ums );
    //删除
    void deleteUmsMemberReceiveAddress(int id);
    //修改
    void updateUmsMemberReceiveAddress(UmsMemberReceiveAddress ums);
    //id查询
    UmsMemberReceiveAddress findByIdUmsMemberReceiveAddress(int id);
}
