package com.sanjay.internship.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component

public class MvcConfiguration implements WebMvcConfigurer {
   public void addViewController(ViewControllerRegistry registry){
        registry.addViewController("/register").setViewName("register");
    }
}