package com.example.project_221024.controller;

import com.example.project_221024.network.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class getController {

    @GetMapping("/header") //localhost:8080/api/header
    public Header getHeader(){
        return Header.builder().resultCode("ok").description("test").build();
    }
}