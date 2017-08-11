package com.gonyb.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 
 * Created by Gonyb on 2017/8/10.
 */
@RestController
public class MovieController {
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private EurekaClient eurekaClient;
    @Value("${service.name.user}")
    private String userServiceName;
   
    public String getHost(String serviceName){
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka(serviceName, false);
        return nextServerFromEureka.getHomePageUrl();
    }
    @GetMapping("/movie/user/{userId}")
    public DoResult getUserById(@PathVariable("userId") Long userId){
        String url = getHost(userServiceName) + "user/" + userId;
        logger.info("请求地址:"+url);
        return restTemplate.getForObject(url, DoResult.class);
    }
}
