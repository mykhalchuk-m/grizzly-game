package com.game.grizzly.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.game.grizzly.app", includeFilters = { @Filter(Configuration.class) })
public class MainConfig {

}
