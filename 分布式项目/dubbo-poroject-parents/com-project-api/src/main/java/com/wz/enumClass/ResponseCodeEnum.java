package com.wz.enumClass;

/**
 * @package: com.wz.enumClass
 * @Author:
 * @Date: 2018/7/14 0014 下午 9:50
 */
public enum  ResponseCodeEnum {
    SYSTEM_BUSY("000","系统繁忙，请稍后再试"),
    SYS_PARAM_NOT_RIGHT("001","系统参数正确"),
    RESPONE_SUCCESS("002","合法登入");



    private final String code;
    private final String msg;

    ResponseCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }



    public String getMsg() {
        return msg;
    }



    public ResponseCodeEnum getMsg(String code){
      for(ResponseCodeEnum responseCodeEnum:ResponseCodeEnum.values()){
          if(responseCodeEnum.getCode()==code){
              return  responseCodeEnum;
          }
      }
      return null;
    }

    @Override
    public String toString() {
        return "ResponseCodeEnum{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
