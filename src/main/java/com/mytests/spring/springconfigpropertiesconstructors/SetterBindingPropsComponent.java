package com.mytests.spring.springconfigpropertiesconstructors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


// this class is defined as configuration properties using @ConfigurationProperties @Componenyt class;
// despite the constructor presence, the setters should be used to bind properties

@ConfigurationProperties(prefix = "setter.component.props")
@Component
public class SetterBindingPropsComponent {

    String field1; // this field is binded (n/r by IDEA)
    String field2; // this field is binded (n/r by IDEA)
    SomeBean3 field3; // this field is NOT binded via ctor, but IDEA thinks it is
    SomeBean4 field4; // this field is NOT binded via ctor, but IDEA thinks it is


    public SetterBindingPropsComponent(SomeBean3 field3, SomeBean4 field4) {
        this.field3 = field3;
        this.field4 = field4;
    }

    public SomeBean3 getField3() {
        return field3;
    }

    public SomeBean4 getField4() {
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

@Component
class SomeBean3 {

}
@Component
class SomeBean4 {

}