package com.xl.gmall.user.service.impl;

import com.xl.gmall.user.bean.UserMember;
import com.xl.gmall.user.mapper.UserMapper;
import com.xl.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     private UserMapper userMapper;

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
}
