package com.wz.dto;


import java.io.Serializable;

/**
 * @package: com.wz.dto
 * @Author:
 * @Date: 2018/7/14 0014 下午 3:05
 */
public class WzRequest implements Serializable{
    private static final long serialVersionUID = 7109548636676224210L;
    private String userName;
    private String password;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "WzRequest{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
