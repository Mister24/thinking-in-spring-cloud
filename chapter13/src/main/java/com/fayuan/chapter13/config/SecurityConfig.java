/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.chapter13.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * SpringSecurity配置类
 *
 * @author mr.24
 * @version Id: SecurityConfig, v 1.0 2019-04-23 15:23 Exp $$
 */
@Configuration
@EnableWebSecurity // 开启WebSecurity功能
@EnableGlobalMethodSecurity(prePostEnabled = true) //
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/css/**", "/index").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/blogs/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error")
                .and()
                .exceptionHandling().accessDeniedPage("/401");
        httpSecurity.logout().logoutSuccessUrl("/");
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder builder) throws Exception {
//        builder.inMemoryAuthentication()
//                .withUser("fayuan")
//                .password("123")
//                .roles("USER");

        // springsecurity更新后需要对密码进行encode
        builder.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("fayuan")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("USER");

        builder.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("fayuan1")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("USER", "ADMIN");
    }

    @Override
    public UserDetailsService userDetailsService() {
        // 在内存中存放用户信息
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("fayuan").password("123").roles("USER").build());
        manager.createUser(User.withUsername("fayuan1").password("123").roles("USER", "ADMIN").build());

        return manager;
    }
}
