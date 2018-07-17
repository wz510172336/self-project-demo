package com.wz.abstr;

import java.io.Serializable;

/**
 * @package: com.wz.abstr
 * @Author:
 * @Date: 2018/7/14 0014 下午 5:25
 */
public abstract class BaseResponse implements Serializable{
    private static final long serialVersionUID = -3110710528882096452L;
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
