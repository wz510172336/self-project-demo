package com.wz.dto;

import com.wz.abstr.BaseResponse;

import java.io.Serializable;

/**
 * @package: com.wz.dto
 * @Author:
 * @Date: 2018/7/14 0014 下午 3:04
 */
public class WzUserResponse extends BaseResponse{
    private static final long serialVersionUID = -292149752176527597L;
    private int uid;
  private String moble;
  private String token;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getMoble() {
        return moble;
    }

    public void setMoble(String moble) {
        this.moble = moble;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
