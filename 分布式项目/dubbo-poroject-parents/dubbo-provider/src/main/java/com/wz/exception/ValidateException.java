package com.wz.exception;



import com.wz.enumClass.ResponseCodeEnum;

/**
 * Create by qingyin@wacai.com
 */
public class ValidateException extends RuntimeException {

    /**
     * versionId
     */
    private static final long serialVersionUID = 7172827201346602909L;


    /**
     * 返回码
     */
    private String errorCode;
    /**
     * 信息
     */
    private String errorMessage;


    public ValidateException(String errorMsg) {

        this.errorCode= ResponseCodeEnum.SYS_PARAM_NOT_RIGHT.getCode();
        this.errorMessage=ResponseCodeEnum.SYS_PARAM_NOT_RIGHT.getMsg()+"--->"+errorMsg;
    }





    public String getErrorCode() {
        return errorCode;
    }


    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


    public String getErrorMessage() {
        return errorMessage;
    }



    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
