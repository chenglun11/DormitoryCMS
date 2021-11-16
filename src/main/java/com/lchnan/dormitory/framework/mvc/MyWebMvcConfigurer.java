package com.lchnan.dormitory.framework.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author admin@lchnan.cn
 * @date 2021/11/16 13:03
 */

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /*使用CorsFilter解决跨域问题*/
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        /*允许跨域请求的域名*/
        corsConfiguration.addAllowedOrigin("*");
        /*允许任何方法*/
        corsConfiguration.addAllowedMethod("*");
        /*允许任何服务*/
        corsConfiguration.addAllowedHeader("*");

        /*CorsFilter实现类*/
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        /*拦截所有请求，配置文件为：corsConfiguration*/
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);

        /*返回过滤器*/
        CorsFilter corsFilter = new CorsFilter(urlBasedCorsConfigurationSource);
        return corsFilter;
    }
}
