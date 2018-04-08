package com.instabook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
//@PropertySource("file:///${user.home}/.webproject/application-dev.properties")
public class DevelopmentConfig {

}
