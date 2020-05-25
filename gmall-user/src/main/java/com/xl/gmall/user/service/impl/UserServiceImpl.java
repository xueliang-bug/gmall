package com.xl.gmall.user.service.impl;

import com.xl.gmall.user.bean.UmsMemberReceiveAddress;
import com.xl.gmall.user.bean.UserMember;
import com.xl.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.xl.gmall.user.mapper.UserMapper;
import com.xl.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/21 17:00
 * @Description: com.xl.gmall.user.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
     UserMapper userMapper;
   @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;
    /**
     * 查询所有UserMember
     * @return
     */
    @Override
    public List<UserMember> findalluser() {
       // List<UserMember> userMember =userMapper.selectalluser();
        List<UserMember> userMember=userMapper.selectAll();
        return userMember ;
    }
    /**
     * 添加
     * @param userMember
     * @return
     */
    @Override
    public UserMember addusermember(UserMember userMember) {
        return userMapper.addusermember(userMember);
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public void deleteUserMemberById(int id) {
         userMapper.deleteUserMemberById(id);
    }
    /**
     * 修改
     * @param userMember
     * @return
     */
    @Override
    public UserMember updateusermember(UserMember userMember) {
        return userMapper.updateusermember(userMember);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public UserMember findUserMemberById(int id) {
       return userMapper.deleteUserMemberById(id);
    }

    /**
     * UmsMemberReceiveAddress通用mapper的条件查询
     * @param memberId
     * @return
     */
    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
       // Example e =new Example(UmsMemberReceiveAddress.class);
        //e.createCriteria().andEqualTo("memberId",memberId);
        UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        //List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectByExample(umsMemberReceiveAddress);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddresses;
    }


}
