package com.instabook.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);
/*
    @Autowired
    private Environment env;

    *//** The encryption SALT*//*
    private static final String SALT = "fgjy87d6f8sdr78945h&^TFGD";

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }*/

/*    @Autowired
    private UserSecurityService userSecurityService;*/

    /** Public URLs*/
    private static final String[] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**",
            "/fonts/**",
            "/js/**",
            "/images/**",
            "/"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

/*        List<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains("dev")) {
            http.csrf().disable();
            http.headers().frameOptions().disable();
        }*/

        http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/loggedIn")
                .failureUrl("/login?error").permitAll()
                .and()
                .logout().permitAll();

        LOG.info("configure done");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("{noop}password")
                .roles("USER");

        LOG.info("configure global done");
/*                .userDetailsService(userSecurityService)
                .passwordEncoder(passwordEncoder());*/
    }
}
