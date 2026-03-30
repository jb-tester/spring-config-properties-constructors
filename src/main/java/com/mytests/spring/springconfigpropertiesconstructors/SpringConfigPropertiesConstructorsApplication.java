package com.mytests.spring.springconfigpropertiesconstructors;

import org.springframework.boot.CommandLineRunner;
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

    // senseless CP configuration:
    // the record properties will not be binded from the application.properties file,
    // the values will be taken from the record constructor arguments
    @Bean
    @ConfigurationProperties(prefix = "record.bean.props")
    public RecordBeanConfigProps recordBeanConfigProps() {
        return new RecordBeanConfigProps("explicit ctor argument", "explicit ctor argument");
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringConfigPropertiesConstructorsApplication.class, args);
    }
      @Bean
          public CommandLineRunner commandLineRunner(RecordBeanConfigProps recordBeanConfigProps) {
              return args -> {
                  System.out.println("--------------------------------------");
                  System.out.println("RecordBeanConfigProps: field1: " + recordBeanConfigProps.field1());
                  System.out.println("RecordBeanConfigProps: field2: " + recordBeanConfigProps.field2());
                  System.out.println("--------------------------------------");
              };
          }
}
