package com.gonyb.service;

import com.gonyb.domain.User;
import com.gonyb.http.DoResult;
import com.gonyb.repo.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Gonyb on 2017/8/10.
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;


    public DoResult getUserById(Long id) {
        User one = userRepository.findOne(id);
        if (one != null) {
            return DoResult.SUCCESS(one);
        } else {
            return DoResult.FAILED("未找到此用户");
        } 
    }
}
