package com.mytests.spring.springconfigpropertiesconstructors.scanned;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;


@ConfigurationProperties(prefix = "ctor.explicit.scanned.props")
public class CtorBindingPropsExplicitScanned {

    String field1;
    String field2;
    String field3;
    String field4;

    @ConstructorBinding
    public CtorBindingPropsExplicitScanned(String field3, String field4) {
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
