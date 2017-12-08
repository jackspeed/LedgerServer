package com.ycj.ledger.mapper;

import com.ycj.ledger.domain.User;
import org.apache.catalina.mbeans.UserMBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 16:05
 */
@Mapper
public interface UserMapper {
    /**
     * 登录
     *
     * @param mobile
     * @param password
     * @return
     */
    User login(@Param("mobile") String mobile,
               @Param("password") String password);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    Integer register(User user);

    /**
     * 昵称数量
     *
     * @param nickName
     * @return
     */
    Integer findByNickName(@Param("nickName") String nickName);

    /**
     * 手机号码数量
     *
     * @param mobile
     * @return
     */
    Integer findByMobile(@Param("mobile") String mobile);

    /**
     * s
     *
     * @param userId
     * @return
     */
    List<User> findUserList(@Param("userId") Long userId);
}
