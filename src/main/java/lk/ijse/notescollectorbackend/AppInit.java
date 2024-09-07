package lk.ijse.notescollectorbackend;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lk.ijse.notescollectorbackend.config.WebAppConfig;
import lk.ijse.notescollectorbackend.config.WebAppRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //01. create Application context using AbstractAnnotationConfigDispatcherServletInitializer

    //02. register of application context
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppRootConfig.class};
    }

    //02. register of application context
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    //03. Create Dispatcher servlet(use default mapping for this)
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}