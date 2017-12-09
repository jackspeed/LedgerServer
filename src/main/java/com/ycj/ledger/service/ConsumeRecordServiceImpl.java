package com.ycj.ledger.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ycj.ledger.domain.ConsumeRecord;
import com.ycj.ledger.mapper.ConsumeRecordMapper;
import com.ycj.ledger.result.BaseResult;
import com.ycj.ledger.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 18:08
 */
@Service
public class ConsumeRecordServiceImpl implements ConsumeRecordService {
    @Autowired
    ConsumeRecordMapper consumeRecordMapper;

    @Override
    public BaseResult update(ConsumeRecord record) {
        if (record.getId() == null) {
            return BaseResult.parameterError();
        }
        int result = consumeRecordMapper.update(record);
        if (result > 0) {
            return BaseResult.success("修改成功");
        }
        return BaseResult.error("update_error", "修改失败");
    }

    @Override
    public BaseResult add(ConsumeRecord record) {
        if (record.getUserId() == null) {
            return BaseResult.parameterError();
        }
        int result = consumeRecordMapper.add(record);
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
        int result = consumeRecordMapper.deleteById(id);
        if (result > 0) {
            return BaseResult.success("删除成功");
        }
        return BaseResult.error("delete_error", "删除失败");
    }

    @Override
    public PageResult findByCondition(Integer pageNo, Integer pageSize, Long userId) {
        PageHelper.startPage(pageNo, pageSize);
        Page<ConsumeRecord> pages = consumeRecordMapper.findByCondition(userId);
        return new PageResult(pages);
    }

    @Override
    public BaseResult findById(Long id) {
        ConsumeRecord record = consumeRecordMapper.findById(id);
        if (record == null) {
            return BaseResult.notFound();
        }
        return BaseResult.success(record);
    }
}
