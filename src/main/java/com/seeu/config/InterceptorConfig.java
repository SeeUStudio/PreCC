package com.seeu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by neo on 17/01/2017.
 */
@Configuration
//@EnableWebMvc ??????????? mgj
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 配置 URL 匹配规则，后缀的点为参数，而不解析
        configurer.setUseSuffixPatternMatch(false).
                setUseTrailingSlashMatch(true);
    }

    @Bean
    public NormalQueryInterceptor normalQueryInterceptor() {
        return new NormalQueryInterceptor();
    }

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(normalQueryInterceptor())
                //添加需要验证登录用户操作权限的请求
                .addPathPatterns("/file/upload")
                //排除不需要验证登录用户操作权限的请求
                .excludePathPatterns();
    }
}
