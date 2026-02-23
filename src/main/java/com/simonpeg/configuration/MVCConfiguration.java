package com.simonpeg.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class MVCConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("forward:/home/index");
        registry.addViewController("/account").setViewName("forward:/account/loginForm");
        /*registry.addViewController("/home").setViewName("forward:/home/index");
        registry.addViewController("/book").setViewName("forward:/book/index");
        registry.addViewController("/customer").setViewName("forward:/customer/index");
        registry.addViewController("/loan").setViewName("forward:/loan/index");*/
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver session = new SessionLocaleResolver();
        Locale indonesia = new Locale("id", "ID");
        session.setDefaultLocale(indonesia);
        return session;
    }
}
