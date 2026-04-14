package com.mytests.spring.springconfigpropertiesconstructors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigurationProperties({CtorBindingPropsImplicitEnabled.class, CtorBindingPropsExplicitEnabled.class})
@ConfigurationPropertiesScan(basePackages = "com.mytests.spring.springconfigpropertiesconstructors.scanned")
@Import({SetterBindingImportedConfigProps.class
          , SetterBindingImportedConfigPropsCorrectErrors.class
})
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
          public CommandLineRunner commandLineRunner(RecordBeanConfigProps recordBeanConfigProps, SetterBindingPropsComponent setterBindingPropsComponent, SetterBindingImportedConfigProps setterBindingImportedConfigProps) {
              return args -> {
                  System.out.println("--------------------------------------");
                  System.out.println("RecordBeanConfigProps: field1: " + recordBeanConfigProps.field1());
                  System.out.println("RecordBeanConfigProps: field2: " + recordBeanConfigProps.field2());
                  System.out.println("SetterBindingPropsComponent: field1: " + setterBindingPropsComponent.getField1());
                  System.out.println("SetterBindingPropsComponent: field2: " + setterBindingPropsComponent.getField2());
                  System.out.println("SetterBindingPropsComponent: field3: " + setterBindingPropsComponent.getField3());
                  System.out.println("SetterBindingPropsComponent: field4: " + setterBindingPropsComponent.getField4());
                  System.out.println("SetterBindingPropsBean: field1: " + setterBindingPropsBean().getField1());
                  System.out.println("SetterBindingPropsBean: field2: " + setterBindingPropsBean().getField2());
                  System.out.println("SetterBindingPropsBean: field3: " + setterBindingPropsBean().getField3());
                  System.out.println("SetterBindingPropsBean: field4: " + setterBindingPropsBean().getField4());
                  System.out.println("SetterBindingImportedConfigProps: field1: " + setterBindingImportedConfigProps.getField1());
                  System.out.println("SetterBindingImportedConfigProps: field2: " + setterBindingImportedConfigProps.getField2());
                  System.out.println("SetterBindingImportedConfigProps: field3: " + setterBindingImportedConfigProps.getField3());
                  System.out.println("SetterBindingImportedConfigProps: field4: " + setterBindingImportedConfigProps.getField4());
                  System.out.println("--------------------------------------");
              };
          }
}
