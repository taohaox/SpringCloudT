package com.gonyb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层
 * Created by Gonyb on 2017/8/7.
 */
@RestController
public class TestController {
    @Value("${server.port}")
    String port;
    
}
