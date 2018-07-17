package com.wz.services;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.wz.dal.entity.UserDO;
import com.wz.dal.entity.UserDOExample;
import com.wz.dal.mapper.UserDOMapper;
import com.wz.dto.CheckAuthRequest;
import com.wz.dto.CheckAuthResponse;
import com.wz.dto.WzRequest;
import com.wz.dto.WzUserResponse;
import com.wz.enumClass.ResponseCodeEnum;
import com.wz.exception.ExceptionUtil;
import com.wz.exception.ServiceException;
import com.wz.exception.ValidateException;
import com.wz.utils.JwtTokenInfo;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @package: com.wz.services
 * @Author:
 * @Date: 2018/7/14 0014 下午 9:27
 */
@Service("userCoreService")
public class UserCoreServiceImp implements IUserServices {
    private final static Logger Log = LoggerFactory.getLogger(UserCoreServiceImp.class);
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private TokenSerivce tokenSerivce;

    @Override
    public WzUserResponse login(WzRequest wzRequest) {
        Log.info("请求参数为：" + wzRequest);
        WzUserResponse wzUserResponse = new WzUserResponse();
        try {
            beforeValidate(wzRequest);
            UserDOExample userDOExample = new UserDOExample();
            UserDOExample.Criteria criteria = userDOExample.createCriteria();
            criteria.andUserNameEqualTo(wzRequest.getUserName());
            UserDO userDO = userDOMapper.selectByExample(userDOExample);
            if (userDO != null && userDO.getPassword().equals(wzRequest.getPassword())) {
                wzUserResponse.setMsg(ResponseCodeEnum.RESPONE_SUCCESS.getMsg());
                wzUserResponse.setCode(ResponseCodeEnum.RESPONE_SUCCESS.getCode());
                wzUserResponse.setUid(userDO.getId());
                //按照uid，服务端token生成
                wzUserResponse.setToken(tokenSerivce.generateToken(new JwtTokenInfo((userDO.getId()).toString())));
                return wzUserResponse;
            }
        } catch (Exception e) {
            ServiceException serviceException = (ServiceException) ExceptionUtil.handlerException4biz(e);
            wzUserResponse.setCode(serviceException.getErrorCode());
            wzUserResponse.setMsg(serviceException.getErrorMessage());
            return wzUserResponse;
        } finally {
            Log.info("Response:" + wzUserResponse);
        }
        return wzUserResponse;
    }

    @Override
    public boolean register(String user) {
        return false;
    }

    @Override
    public CheckAuthResponse checkAuth(CheckAuthRequest checkAuthRequest) {
        CheckAuthResponse checkAuthResponse=new CheckAuthResponse();
        try {
            tokenValidate(checkAuthRequest);
            checkAuthResponse.setCode(ResponseCodeEnum.RESPONE_SUCCESS.getCode());
            checkAuthResponse.setMsg(ResponseCodeEnum.RESPONE_SUCCESS.getMsg());
            JwtTokenInfo jwtTokenInfo=  tokenSerivce.getInfo(checkAuthRequest.getToken()) ;
            checkAuthResponse.setUid(jwtTokenInfo.getUid());
            return checkAuthResponse;
        } catch (ExpiredJwtException e1){
            //TODO
        }
        catch (SignatureException e2){
            //todo
        }
        catch (Exception e) {
            ServiceException serviceException = (ServiceException) ExceptionUtil.handlerException4biz(e);
          checkAuthResponse.setCode(serviceException.getErrorCode());
           checkAuthResponse.setMsg(serviceException.getErrorMessage());
           return  checkAuthResponse;
        }
        return  checkAuthResponse;
    }

    private void tokenValidate(CheckAuthRequest checkAuthRequest) {
        if (checkAuthRequest == null) {
            throw new ValidateException("请求为空");
        }
        if (StringUtils.isBlank(checkAuthRequest.getToken())){
            throw new ValidateException("token 为空");
        }
    }

    private void beforeValidate(WzRequest wzRequest) {
        if (wzRequest == null) {
            throw new ValidateException("请求为空");
        }
        if (StringUtils.isBlank(wzRequest.getUserName())) {
            throw new ValidateException("姓名为空");
        }
        if (StringUtils.isEmpty(wzRequest.getPassword())) {
            throw new ValidateException("密码为空");
        }
    }
}
