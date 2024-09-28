package lk.ijse.notescollectorbackend.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
//root package eka - lk.ijse.introspringmvc
@ComponentScan(basePackages = "lk.ijse.notescollectorbackend")
@EnableWebMvc
@MultipartConfig
public class WebAppConfig {
}
