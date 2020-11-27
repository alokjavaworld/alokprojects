package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(value = {DaoAppConfig.class,ServiceAppConfig.class})
public class AppConfig {

}
