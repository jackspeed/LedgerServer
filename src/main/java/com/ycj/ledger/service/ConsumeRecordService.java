package com.ycj.ledger.service;

import com.github.pagehelper.Page;
import com.ycj.ledger.domain.ConsumeRecord;
import com.ycj.ledger.result.BaseResult;
import com.ycj.ledger.result.PageResult;
import org.apache.ibatis.annotations.Param;


/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 18:06
 */
public interface ConsumeRecordService {
    /**
     * 修改
     *
     * @param consumeRecord
     * @return
     */
    BaseResult update(ConsumeRecord consumeRecord);

    /**
     * 新增
     *
     * @param consumeRecord
     * @return
     */
    BaseResult add(ConsumeRecord consumeRecord);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    BaseResult deleteById(Long id);

    /**
     * 条件查询
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return
     */
    PageResult findByCondition(Integer pageNo, Integer pageSize, Long userId);

    /**
     * findById
     * @param id
     * @return
     */
    BaseResult findById(Long id);
}
