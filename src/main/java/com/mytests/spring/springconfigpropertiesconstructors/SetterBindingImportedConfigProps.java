package com.mytests.spring.springconfigpropertiesconstructors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "setter.imported.props")
public class SetterBindingImportedConfigProps {  // false error is reported
    String field1; // this field is binded (n/r by IDEA)
    String field2; // this field is binded (n/r by IDEA)
    SomeBean5 field3; // this field is NOT binded via ctor, but IDEA thinks it is
    SomeBean6 field4; // this field is NOT binded via ctor, but IDEA thinks it is


    public SetterBindingImportedConfigProps(SomeBean5 field3, SomeBean6 field4) {
        this.field3 = field3;
        this.field4 = field4;
    }

    public SomeBean5 getField3() {
        return field3;
    }

    public SomeBean6 getField4() {
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
class SomeBean5 {
    @Override
    public String toString() {
        return "SomeBean5: not binded as property";
    }
}
@Component
class SomeBean6 {
    @Override
    public String toString() {
        return "SomeBean6: not binded as property";
    }
}
