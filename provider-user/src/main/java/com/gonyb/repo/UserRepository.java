package com.gonyb.repo;

import com.gonyb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * user表
 * Created by Gonyb on 2017/8/10.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
