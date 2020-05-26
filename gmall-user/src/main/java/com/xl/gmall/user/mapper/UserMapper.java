package com.xl.gmall.user.mapper;

import com.xl.gmall.bean.UmsMember;
import org.springframework.context.annotation.Primary;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/21 17:03
 * @Description: com.xl.gmall.user.mapper
 * @version: 1.0
 */
@Primary
public interface UserMapper extends Mapper<UmsMember> {
    /**
     * UserMember查询所有
     * @return
     */
    List<UmsMember>  selectalluser();

    /**
     * 添加UserMember
     * @param userMember
     * @return
     */
    UmsMember addusermember(UmsMember userMember);

    /**
     * 删除
     * @param id
     * @return
     */
    UmsMember deleteUserMemberById(int id);

    /**
     * 修改
     * @param userMember
     * @return
     */
    UmsMember updateusermember(UmsMember userMember);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    UmsMember findUserMemberById(int id);

}
