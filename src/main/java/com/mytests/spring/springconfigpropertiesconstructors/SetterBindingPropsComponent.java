package com.mytests.spring.springconfigpropertiesconstructors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


// this class is defined as configuration properties using @ConfigurationProperties @Componenyt class;
// despite the constructor presence, the setters should be used to bind properties
// no error should be shown
@ConfigurationProperties(prefix = "setter.component.props")
@Component
public class SetterBindingPropsComponent {

    String field1; // this field is binded (n/r by IDEA)
    String field2; // this field is binded (n/r by IDEA)
    String field3; // this field is NOT binded via ctor, but IDEA thinks it is
    String field4; // this field is NOT binded via ctor, but IDEA thinks it is


    public SetterBindingPropsComponent(String field3, String field4) {
        this.field3 = field3;
        this.field4 = field4;
    }

    public String getField3() {
        return field3;
    }

    public String getField4() {
        return field4;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }
}
