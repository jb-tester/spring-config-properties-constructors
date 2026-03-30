package com.mytests.spring.springconfigpropertiesconstructors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigurationProperties({CtorBindingPropsImplicitEnabled.class, CtorBindingPropsExplicitEnabled.class})
@ConfigurationPropertiesScan(basePackages = "com.mytests.spring.springconfigpropertiesconstructors.scanned")
public class SpringConfigPropertiesConstructorsApplication {

    @Bean
    @ConfigurationProperties(prefix = "setter.bean.props")
    public SetterBindingPropsBean setterBindingPropsBean() {
        return new SetterBindingPropsBean("aaa", "bbb");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigPropertiesConstructorsApplication.class, args);
    }

}
