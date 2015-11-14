package com.repository;

import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vicriss on 2015/09/17.
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    public User findByName(String name);
}
