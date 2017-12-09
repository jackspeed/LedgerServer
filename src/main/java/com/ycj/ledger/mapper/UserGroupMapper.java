package com.ycj.ledger.mapper;


import com.github.pagehelper.Page;
import com.ycj.ledger.domain.ConsumeRecord;
import com.ycj.ledger.domain.UserGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 16:05
 */
@Mapper
public interface UserGroupMapper {
    /**
     * 修改
     *
     * @param group
     * @return
     */
    int update(UserGroup group);


    /**
     * 新增
     *
     * @param group
     * @return
     */
    int add(UserGroup group);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 条件查询
     *
     * @param searchKey
     * @return
     */
    Page<UserGroup> findByCondition(@Param("searchKey") String searchKey);

}
