package com.ycj.ledger.controller;

import com.ycj.ledger.domain.UserGroup;
import com.ycj.ledger.result.BaseResult;
import com.ycj.ledger.result.PageResult;
import com.ycj.ledger.service.UserGroupService;
import com.ycj.ledger.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 18:02
 */
@RestController
@RequestMapping("/userGroup")
public class GroupController {

    @Autowired
    UserGroupService userGroupService;

    @PostMapping("/update")
    public BaseResult update(UserGroup userGroup) {
        return userGroupService.update(userGroup);
    }

    @PostMapping("/add")
    public BaseResult add(UserGroup userGroup) {
        return userGroupService.add(userGroup);
    }

    @PostMapping("/deleteById")
    public BaseResult deleteById(Long id) {
        return userGroupService.deleteById(id);
    }

    @GetMapping("/findByCondition")
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey) {
        return userGroupService.findByCondition(pageNo, pageSize, searchKey);
    }
}
