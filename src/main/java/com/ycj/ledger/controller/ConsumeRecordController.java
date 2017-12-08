package com.ycj.ledger.controller;

import com.ycj.ledger.domain.ConsumeRecord;
import com.ycj.ledger.result.BaseResult;
import com.ycj.ledger.result.PageResult;
import com.ycj.ledger.service.ConsumeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 18:02
 */
@RestController
@RequestMapping("/consume/record")
public class ConsumeRecordController {

    @Autowired
    ConsumeRecordService consumeRecordService;

    @PostMapping("/update")
    public BaseResult update(@RequestBody ConsumeRecord record) {
        return consumeRecordService.update(record);
    }

    @PostMapping("/add")
    public BaseResult add(@RequestBody ConsumeRecord record) {
        return consumeRecordService.add(record);
    }

    @PostMapping("/deleteById")
    public BaseResult deleteById(Long id) {
        return consumeRecordService.deleteById(id);
    }

    @GetMapping("/findByCondition")
    public PageResult findByCondition(Integer pageNo, Integer pageSize, Long userId) {
        return consumeRecordService.findByCondition(pageNo, pageSize, userId);
    }
}
