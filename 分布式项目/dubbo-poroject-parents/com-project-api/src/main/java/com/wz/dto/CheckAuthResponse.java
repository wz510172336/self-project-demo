package com.wz.dto;

import com.wz.abstr.BaseResponse;

import java.io.Serializable;

/**
 * @package: com.wz.dto
 * @Author:
 * @Date: 2018/7/16 0016 下午 8:44
 */
public class CheckAuthResponse extends BaseResponse implements Serializable {

    private static final long serialVersionUID = -4262732338239376378L;
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "CheckAuthResponse{" +
                "uid='" + uid + '\'' +
                '}';
    }
}
