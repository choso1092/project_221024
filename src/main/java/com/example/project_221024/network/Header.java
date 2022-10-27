package com.example.project_221024.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor //기본생성자
@Builder//헤더라는 객체를 생성할때 유연하게 해주는 코드
public class Header<T> {

    //api 통신시간
    @JsonProperty("transaction_time")
    private String transactionTime;


    //api 응답코드
    private  String resultCode;

    //api 부가설명
    private String description;

    //바디
    private T data;
}