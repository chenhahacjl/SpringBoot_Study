package com.cmile.app;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync //开启异步调用
@SpringBootApplication(scanBasePackages = {"com.cmile.controller", "com.cmile.interceptor", "com.cmile.service"})
public class Application {

    @Bean
    public HttpMessageConverters fastJsonMessageConverter() {
        //创建FastJson消息转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //创建FastJson配置对象
        FastJsonConfig config = new FastJsonConfig();
        //对JSON数据进行格式化
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);

        converter.setFastJsonConfig(config);
        HttpMessageConverter<?> rltConverter = converter;

        return new HttpMessageConverters(rltConverter);
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
