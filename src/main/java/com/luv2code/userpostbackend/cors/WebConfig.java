package com.luv2code.userpostbackend.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	System.out.println("=====> Cors Added");
        registry.addMapping("/**")
                .allowedMethods("*");
    }
}
