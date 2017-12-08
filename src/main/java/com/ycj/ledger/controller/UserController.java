package com.ycj.ledger.controller;

import com.ycj.ledger.domain.User;
import com.ycj.ledger.result.BaseResult;
import com.ycj.ledger.service.IndexService;
import com.ycj.ledger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 16:05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    BaseResult login(String mobile, String password) {
        return userService.login(mobile, password);
    }

    @PostMapping("/register")
    BaseResult register(@RequestBody User user) {
        return userService.register(user);
    }
}
