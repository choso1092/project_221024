package com.example.project_221024.repository;

import com.example.project_221024.Project221024ApplicationTests;
import com.example.project_221024.component.LoginUserAuditorAware;
import com.example.project_221024.config.JpaConfig;
import com.example.project_221024.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Import({ JpaConfig.class, LoginUserAuditorAware.class})
public class UserRepositoryTest  extends Project221024ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setAccount("ABCD1234");
        user.setPassword("ABCD1234");
        user.setStatus("logout");
        user.setPhoneNumber("010-8375-0111");
        userRepository.save(user);
    }

    @Test
    public void update(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-8375-0111");
        user.setAccount("hanna1234");
        userRepository.save(user);
    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-8375-0111");
        if(user != null){
            System.out.println(user);
        }
    }
}

