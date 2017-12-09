package com.ycj.ledger.mapper;


import com.github.pagehelper.Page;
import com.ycj.ledger.domain.ConsumeRecord;
import com.ycj.ledger.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 16:05
 */
@Mapper
public interface ConsumeRecordMapper {
    /**
     * 修改
     *
     * @param consumeRecord
     * @return
     */
    int update(ConsumeRecord consumeRecord);


    /**
     * 新增
     *
     * @param consumeRecord
     * @return
     */
    int add(ConsumeRecord consumeRecord);

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
     * @param userId
     * @return
     */
    Page<ConsumeRecord> findByCondition(@Param("userId") Long userId);

    /**
     * id 查询详情
     *
     * @param id
     * @return
     */
    ConsumeRecord findById(@Param("id") Long id);
}
