package com.example.project_221024.component;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class LoginUserAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //return Optional.empty();
        return Optional.of("chisooADMIN");
    }
}
