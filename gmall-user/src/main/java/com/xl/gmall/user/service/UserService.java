package com.xl.gmall.user.service;

import com.xl.gmall.user.bean.UserMember;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/21 17:00
 * @Description: com.xl.gmall.user.service
 * @version: 1.0
 */
public interface UserService {
    //查询所有UserMember
    List<UserMember> findalluser();
}
