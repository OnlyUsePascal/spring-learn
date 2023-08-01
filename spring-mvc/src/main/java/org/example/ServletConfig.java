package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// you can comment this whole thing and use xml
// @EnableWebMvc
// @ComponentScan("org.example")
// @Configuration
// public class ServletConfig implements WebMvcConfigurer {
//   @Bean
//   public InternalResourceViewResolver internalResourceViewResolver(){
//     InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//     internalResourceViewResolver.setPrefix("/resources/");
//     internalResourceViewResolver.setSuffix(".jsp");
//
//     return internalResourceViewResolver;
//   }
// }
