package com.example.project_221024.service;

import com.example.project_221024.component.LoginUserAuditorAware;
import com.example.project_221024.config.JpaConfig;
import com.example.project_221024.ifs.CrudInterface;
import com.example.project_221024.model.entity.User;
import com.example.project_221024.network.Header;
import com.example.project_221024.network.reponse.UserApiResponse;
import com.example.project_221024.network.request.UserApiRequest;
import com.example.project_221024.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Import({ JpaConfig.class, LoginUserAuditorAware.class})
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    private Header<UserApiResponse> response(User user){
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        return Header.OK(userApiResponse);
    }

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();

        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(userApiRequest.getStatus())
                .phoneNumber(userApiRequest.getPhoneNumber())
                .build();

        User newUser = userRepository.save(user);
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        Optional<User> user = userRepository.findById(id);
        //select * from user where id = 1;


        return user.map(newUser -> response(newUser))
                .orElseGet(()->Header.ERROR("찾는데이터가 없어.."));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();

        Optional<User> user = userRepository.findById(userApiRequest.getId());

        return user.map(newUser -> {
            newUser.setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus());
            return newUser;
        }).map(newUser -> userRepository.save(newUser))
                .map(newUser -> response(newUser))
                .orElseGet(() -> Header.ERROR("데이터없음"));

    }

    @Override
    public Header delete(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.map(newUser -> {
            userRepository.delete(newUser);
            return Header.OK();
        })
                .orElseGet(()->Header.ERROR("찾는데이터가 없어.."));
    }
}
