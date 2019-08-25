package com.wyl.mybatis.mapper;

import com.wyl.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-10 15:55
 */
//@Mapper
public interface UserMapper {
//    @Select("select * from userinfo  where userid =#{userid}")
    User getUserInfo(User user);
}
