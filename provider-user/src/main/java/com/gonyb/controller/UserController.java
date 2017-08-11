package com.gonyb.controller;

import com.gonyb.http.DoResult;
import com.gonyb.service.UserService;
import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户控制层
 * Created by Gonyb on 2017/8/10.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    
    @Resource
    private EurekaClient eurekaClient;
    @Resource
    private DiscoveryClient discoveryClient;
    
    
    @GetMapping("/{id}")
    public DoResult getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
    
    @GetMapping("/eureka-instance")
    public String serviceUrl(){
        return eurekaClient.getNextServerFromEureka("provider-user", false).getHomePageUrl();
    }

    @GetMapping("/discovery-instance")
    public DoResult discoveryServiceUrl(){
        List<ServiceInstance> instances = discoveryClient.getInstances("provider-user");
        if(instances!=null&&instances.size()>0){
            return DoResult.SUCCESS(instances.get(0).getUri());
        }
        return DoResult.FAILED("获取url失败");
    }
    
}
