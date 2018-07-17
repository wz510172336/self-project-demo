package com.wz.dto;

import java.io.Serializable;

/**
 * @package: com.wz.dto
 * @Author:
 * @Date: 2018/7/16 0016 下午 8:44
 */
public class CheckAuthRequest implements Serializable {
    private static final long serialVersionUID = 5151545665282022339L;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
