package com.xl.gmall.user.mapper;

import com.xl.gmall.user.bean.UserMember;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/21 17:03
 * @Description: com.xl.gmall.user.mapper
 * @version: 1.0
 */
public interface UserMapper extends Mapper<UserMember> {
    /**
     * UserMember的Dao
     * @return
     */
    List<UserMember>  selectalluser();
}
