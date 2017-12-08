package com.ycj.ledger.controller;

import com.sun.xml.internal.rngom.parse.host.Base;
import com.ycj.ledger.result.BaseResult;
import com.ycj.ledger.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 16:05
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Value("&{sss}")
    String tValue;

    @Autowired
    IndexService indexService;

    @GetMapping("/index")
    BaseResult test() {
        return indexService.test();
    }
}
