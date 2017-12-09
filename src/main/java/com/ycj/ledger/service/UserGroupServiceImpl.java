package com.ycj.ledger.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ycj.ledger.domain.UserGroup;
import com.ycj.ledger.mapper.UserGroupMapper;
import com.ycj.ledger.result.BaseResult;
import com.ycj.ledger.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-09 11:51
 */
@Service
public class UserGroupServiceImpl implements UserGroupService {
    @Autowired
    UserGroupMapper userGroupMapper;

    @Override
    public BaseResult update(UserGroup userGroup) {
        if (userGroup.getId() == null) {
            return BaseResult.parameterError();
        }
        int result = userGroupMapper.update(userGroup);
        if (result > 0) {
            return BaseResult.success("修改成功");
        }
        return BaseResult.error("update_error", "修改失败");
    }

    @Override
    public BaseResult add(UserGroup userGroup) {
        int result = userGroupMapper.add(userGroup);
        if (result > 0) {
            return BaseResult.success("添加成功");
        }
        return BaseResult.error("add_error", "添加失败");
    }

    @Override
    public BaseResult deleteById(Long id) {
        if (id == null) {
            return BaseResult.parameterError();
        }
        int result = userGroupMapper.deleteById(id);
        if (result > 0) {
            return BaseResult.success("删除成功");
        }
        return BaseResult.error("delete_error", "删除失败");
    }

    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey) {
        PageHelper.startPage(pageNo, pageSize);
        Page<UserGroup> pages = userGroupMapper.findByCondition(searchKey);
        return new PageResult(pages);
    }
}
