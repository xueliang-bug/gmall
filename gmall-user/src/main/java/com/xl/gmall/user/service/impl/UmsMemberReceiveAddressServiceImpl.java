package com.xl.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xl.gmall.bean.UmsMemberReceiveAddress;
import com.xl.gmall.service.UmsMemberReceiveAddressService;
import com.xl.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/25 15:26
 * @Description: com.xl.gmall.user.service.impl
 * @version: 1.0
 */
@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {
     @Autowired
    UmsMemberReceiveAddressMapper umsMemberMapper;
    /**
     * 查询所有
     * @return
     */
    @Override
    public List<UmsMemberReceiveAddress> findAllUmsMemberReceiveAddress() {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberMapper.selectAll();
        return umsMemberReceiveAddresses;
    }

    /**
     * 添加
     * @param ums
     */
    @Override
    public void insertUmsMemberReceiveAddress(UmsMemberReceiveAddress ums) {
        umsMemberMapper.insert(ums);
    }



    /**
     * 删除
     * @param id
     */
    @Override
    public UmsMemberReceiveAddress deleteById(int id) {
        return umsMemberMapper.deleteById(id);
    }

    /**
     * 修改
     * @param ums
     */
    @Override
    public void updateUmsMemberReceiveAddress(UmsMemberReceiveAddress ums) {
      umsMemberMapper.updateUmsMemberReceiveAddress(ums);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public UmsMemberReceiveAddress findByIdUmsMemberReceiveAddress(int id) {
        return umsMemberMapper.findByIdUmsMemberReceiveAddress(id);
    }
}
