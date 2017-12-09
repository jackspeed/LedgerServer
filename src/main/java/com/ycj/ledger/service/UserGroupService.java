package com.ycj.ledger.service;

import com.ycj.ledger.domain.UserGroup;
import com.ycj.ledger.result.BaseResult;
import com.ycj.ledger.result.PageResult;


/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 18:06
 */
public interface UserGroupService {
    /**
     * 修改
     *
     * @param group
     * @return
     */
    BaseResult update(UserGroup group);

    /**
     * 新增
     *
     * @param group
     * @return
     */
    BaseResult add(UserGroup group);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    BaseResult deleteById(Long id);

    /**
     * 条件查询
     *
     * @param searchKey
     * @return
     */
    PageResult findByCondition(Integer pageNo, Integer pageSize, String searchKey);
}
