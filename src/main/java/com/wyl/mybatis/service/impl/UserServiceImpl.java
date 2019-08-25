package com.wyl.mybatis.service.impl;

import com.wyl.mybatis.entity.User;
import com.wyl.mybatis.mapper.UserMapper;
import com.wyl.mybatis.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-11 19:28
 */
@Component
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    /**
     * @param user
     * @Description: 查询用户信息
     * @Author: Wangyl
     * @Date: 2019/8/11
     * @Param: User
     * @return: User
     */
    @Override
    public User getUserInfo(User user) {
        return userMapper.getUserInfo(user);
    }
}
