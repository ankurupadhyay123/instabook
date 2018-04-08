package com.instabook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
//@PropertySource("file:///${user.home}/.webproject/application-prod.properties")
public class ProductionConfig {

}
