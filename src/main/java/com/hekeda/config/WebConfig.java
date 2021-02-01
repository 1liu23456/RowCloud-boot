package com.hekeda.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局配置类---处理跨域，
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final String[] AUTH_WHITELIST = {
            //这个需要允许，不然总是弹那个框,*也必须加，不然跨域
            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**",
            "*"
    };
    /**
     * 1.预访问路径
     * 2.请求来源
     * 3.方法
     * 4.允许携带
     * 5.最大时间
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println(111);
        registry.addMapping("/**")
                .allowedOriginPatterns(AUTH_WHITELIST)
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*")
                .maxAge(3600)
                .exposedHeaders("Header1", "Header2")
                .allowCredentials(true);

    }

}
