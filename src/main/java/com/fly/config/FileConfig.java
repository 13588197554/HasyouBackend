package com.fly.config;

import com.fly.filter.CrossFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;

@Configuration
public class FileConfig {

    @Bean
    public FilterRegistrationBean filter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(crossFilter());
        bean.addUrlPatterns("/*");
        bean.addInitParameter("paramName", "paramValue");
        bean.setName("crossFilter");
        return bean;
    }

    /*
    * file size config!
    * */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory mcf = new MultipartConfigFactory();
        // single file upload
        mcf.setMaxFileSize("102400KB"); // 100M
        // more files upload
        mcf.setMaxRequestSize("102400KB"); // 100M
        return mcf.createMultipartConfig();
    }

    @Bean(name = "crossFilter")
    public Filter crossFilter() {
        return new CrossFilter();
    }

}
