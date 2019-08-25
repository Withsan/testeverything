package com.wyl.mybatis.entity;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-10 15:54
 */
public class User {
    private Integer userid;
    private String username;
    private String age;
    private String gender;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public User(){}
    public User(String name){
        this.username=name;
    }
    public String getAge(String name) {
        this.username=name;
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
