package com.lab3.journal2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder builder) throws Exception {
        builder.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT USERNAME, PASSWORD, 1 as enabled FROM LAB3_SSM_USERS WHERE USERNAME=?")
                .authoritiesByUsernameQuery("SELECT USERNAME, ROLE FROM LAB3_SSM_USERS WHERE USERNAME=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/subjects/**",
                        "/subjects",
                        "/teachers",
                        "/teachers/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_TEACHER")
                .antMatchers("/journal/edit/**").hasAuthority("ROLE_TEACHER")
                .antMatchers("/users", "/users/**").hasAuthority("ROLE_ADMIN")
                //.antMatchers("/").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll().defaultSuccessUrl("/journal")
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable().cors();


    }
}
