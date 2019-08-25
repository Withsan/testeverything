package com.wyl.java8;

import com.wyl.mybatis.entity.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-12 20:00
 */
@Component
public class Java8Stream {
    /**
     * foreach会对源集合产生影响，不会具有返回值,lambda表达式必须是void
     */
    public void testForEach(){
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        List<User> strList = Arrays.asList(new User(),new User(),new User(),new User(),new User());
        strList.stream().forEach(i ->i.setAge("111"));
        strList.stream().forEach(System.out::println);
    }

    /**
     * map会对源集合产生影响，具有返回值,lambda表达式必须不是void
     */
    public void testMap(){
        List<User> strList = Arrays.asList(new User(),new User(),new User(),new User(),new User());
        List<String> age = strList.stream().map(i ->i.getAge("wyl")).collect(Collectors.toList());
        age.stream().forEach(System.out::println);
        strList.stream().forEach(System.out::println);
    }

    /**
     * 这个好像很是浅显易懂哈哈，返回符合条件的数据
     */
    public void testFilter() {
        List<User> strList = Arrays.asList(new User("ww"),new User("y"),new User("l"),new User("y"),new User("r"));
        List<User> users = strList.stream().filter(i ->i.getUsername().length()==2).collect(Collectors.toList());
        users.stream().forEach(System.out::println);
        strList.stream().forEach(System.out::println);
    }


}
