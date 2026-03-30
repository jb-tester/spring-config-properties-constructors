package com.mytests.spring.springconfigpropertiesconstructors;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "ctor.implicit.enabled.props")
public class CtorBindingPropsImplicitEnabled {

    String field1; // this field is not binded
    String field2; // this field is not binded
    String field3; // binded via constructor
    String field4; // binded via constructor

    public CtorBindingPropsImplicitEnabled(String field3, String field4) {
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
