package com.ycj.ledger.service;

import com.alibaba.druid.util.StringUtils;
import com.ycj.ledger.constant.Constant;
import com.ycj.ledger.domain.User;
import com.ycj.ledger.mapper.UserMapper;
import com.ycj.ledger.result.BaseResult;
import com.ycj.ledger.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 16:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public BaseResult login(String mobile, String password) {
        if (mobile.length() < Constant.MOBILE_LENGTH) {
            return BaseResult.error("ERROR", "手机号码不正确");
        }
        if (password.length() < Constant.PASSWORD_MIN_LENGTH) {
            return BaseResult.error("ERROR", "密码不能小于六位");
        }
        String encryptPassword = null;
        try {
            encryptPassword = EncryptUtil.encryptMD5(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = userMapper.login(mobile, encryptPassword);
        if (null == user) {
            return BaseResult.error("ERROR", "手机号或密码不正确!");
        }
        return BaseResult.success(user);
    }

    @Override
    public BaseResult register(User user) {
        String mobile = user.getMobile();
        String password = user.getPassword();
        String nickName = user.getNickName();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            return BaseResult.systemError();
        }
        if (mobile.length() < Constant.MOBILE_LENGTH) {
            return BaseResult.error("ERROR", "手机号码不正确");
        }
        if (password.length() < Constant.PASSWORD_MIN_LENGTH) {
            return BaseResult.error("ERROR", "密码不能小于六位");
        }
        int mobileCount = userMapper.findByMobile(mobile);
        if (mobileCount > 0) {
            return BaseResult.error("ERROR", "手机已存在");
        }
        int nick = userMapper.findByNickName(nickName);
        if (nick > 0) {
            return BaseResult.error("ERROR", "昵称已存在");
        }
        String encryptPassword = null;
        try {
            encryptPassword = EncryptUtil.encryptMD5(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setPassword(encryptPassword);
        int result = userMapper.register(user);
        if (result <= 0) {
            return BaseResult.error("ERROR", "注册失败");
        }
        return BaseResult.success(user);
    }

    @Override
    public BaseResult findUserList(Long userId) {
        List<User> userList = userMapper.findUserList(userId);
        return BaseResult.success(userList);
    }
}
