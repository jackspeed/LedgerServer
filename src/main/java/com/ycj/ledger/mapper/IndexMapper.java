package com.ycj.ledger.mapper;


import com.ycj.ledger.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 16:05
 */
@Mapper
public interface IndexMapper {
    List<User> test();
}
