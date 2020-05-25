package com.xl.gmall.user.service.impl;

import com.xl.gmall.user.bean.UmsMemberReceiveAddress;
import com.xl.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.xl.gmall.user.service.UmsMemberReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void deleteUmsMemberReceiveAddress(int id) {
        umsMemberMapper.delete(id);
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
