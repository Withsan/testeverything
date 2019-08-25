package com.wyl.mybatis.service;

import com.wyl.mybatis.entity.User;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-11 19:27
 */

public interface UserService {
    /**
    * @Description: 查询用户信息
    * @Author: Wangyl
    * @Date: 2019/8/11
    * @Param:  User
    * @return:  User
    */
    User getUserInfo(User user);
}
