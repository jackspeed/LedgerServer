package com.ycj.ledger.service;

import com.ycj.ledger.domain.User;
import com.ycj.ledger.mapper.IndexMapper;
import com.ycj.ledger.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 16:06
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    IndexMapper indexMapper;


    @Override
    public BaseResult test() {
        List<User> userList = indexMapper.test();
        return BaseResult.success(userList);
    }
}
