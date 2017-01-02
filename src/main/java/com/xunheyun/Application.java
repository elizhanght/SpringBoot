/**
 * 程序入口
 */
package com.xunheyun;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.xunheyun.utils.SystemInterceptor;

/**
 * @author HAITAO
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Application extends WebMvcConfigurerAdapter {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	return application.sources(Application.class);
    }
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
	
	 /**
     * 配置拦截器
     * @author lance
     * @param registry
     */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(new SystemInterceptor())
    	.excludePathPatterns("/login/page")
    	.excludePathPatterns("/login/home")
    	.excludePathPatterns("/login/registerpage")
    	.excludePathPatterns("/login/register")
    	.addPathPatterns("/login/**")
    	.addPathPatterns("/project/**")
    	.addPathPatterns("/file/**")
    	.addPathPatterns("/property/**")
    	.addPathPatterns("/server/**")
    	.addPathPatterns("/war/**");
	}
	
	@Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        factory.setMaxFileSize("50Mb");  
        factory.setMaxRequestSize("50Mb");  
        return factory.createMultipartConfig();  
    }  

}
