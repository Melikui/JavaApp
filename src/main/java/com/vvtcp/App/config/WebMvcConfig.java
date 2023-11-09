package com.vvtcp.App.config;

import com.vvtcp.App.security.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean(name = "authInterceptor")
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }
    /*
     * 拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new AuthInterceptor()) // 添加拦截器
                .addPathPatterns("/**") // 添加拦截路径
                .excludePathPatterns("/login.html", "/static/**") // 添加排除拦截路径及执行顺序
                .excludePathPatterns("/swagger-resources/**", "/swagger-ui/**", "/v3/**", "/error");
    }

    /**
     * 添加静态资源文件，外部可以直接访问地址
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        //此处还可继续增加目录。。。。
    }
}


