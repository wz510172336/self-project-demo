package com.wz.client;

import com.wz.dto.WzRequest;
import com.wz.dto.WzUserResponse;
import com.wz.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: com.wz.client
 * @Author:
 * @Date: 2018/7/14 0014 下午 11:49
 */
@RestController
public class UserLoginControllor {
    @Autowired
    private IUserServices userCoreService;

    @PostMapping("/login")
    public ResponseEntity doLogin(String username, String password){
        WzRequest wzRequest=new WzRequest();
        wzRequest.setUserName(username);
        wzRequest.setUserName(password);
        WzUserResponse wzUserResponse=userCoreService.login(wzRequest);
        return ResponseEntity.ok(wzUserResponse);
    }
}
