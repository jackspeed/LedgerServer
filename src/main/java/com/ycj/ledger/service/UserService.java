package com.ycj.ledger.service;

import com.ycj.ledger.domain.User;
import com.ycj.ledger.result.BaseResult;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 16:06
 */
public interface UserService {
    /**
     * 登录
     *
     * @param mobile
     * @param password
     * @return
     */
    BaseResult login(String mobile, String password);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    BaseResult register(User user);

    /**
     * 用户列表
     *
     * @param userId
     * @return
     */
    BaseResult findUserList(Long userId);
}
