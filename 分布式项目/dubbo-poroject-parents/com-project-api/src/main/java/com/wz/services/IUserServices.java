package com.wz.services;



import com.wz.dto.CheckAuthRequest;
import com.wz.dto.CheckAuthResponse;
import com.wz.dto.WzRequest;
import com.wz.dto.WzUserResponse;

/**
 * @package: com.wz
 * @Author:
 * @Date: 2018/7/14 0014 下午 3:03
 */
public interface IUserServices {
    WzUserResponse login(WzRequest wzRequest);
    boolean  register(String  user);
    CheckAuthResponse checkAuth(CheckAuthRequest checkAuthRequest);

}
