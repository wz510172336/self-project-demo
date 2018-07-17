package com.wz.utils;

/**
 * @package: com.wz.utils
 * @Author:
 * @Date: 2018/7/16 0016 下午 5:51
 */
public class JwtTokenInfo {
    private String Uid;

    public JwtTokenInfo(String uid) {
        Uid = uid;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}
