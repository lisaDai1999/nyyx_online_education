package com.jiaobuqifangzu.nyyx.Utils;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ChenXing
 * @date 2020/10/14 22:19
 */
@Component
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 添加静态资源，外部可以直接访问地址
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

}