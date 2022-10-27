package kr.co.tmax.arenademobe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://192.168.154.111:7907:", "http://192.168.154.111:7900", "http://192.168.154.111:7909")
                .allowedMethods("GET", "POST")
                .maxAge(3000);
    }
}
