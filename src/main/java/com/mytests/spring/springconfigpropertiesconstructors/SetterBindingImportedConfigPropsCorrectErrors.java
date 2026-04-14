package com.mytests.spring.springconfigpropertiesconstructors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "setter.imported.props.invalid")
public class SetterBindingImportedConfigPropsCorrectErrors {
    String field1;
    String field2;
    SomeBean7 field3;
    SomeBean8 field4;

    // any of following ctors presence should cause the class-level error:
    // https://youtrack.jetbrains.com/issue/IDEA-295486/Spring-Boot-report-as-error-the-ConfigurationProperties-annotated-class-with-explicit-or-implicit-ConstructorBinding-if-it-is
    // ok in IDEA

    // error should be reported if this explicit annotation exists
    /*@ConstructorBinding
    public SetterBindingImportedConfigPropsCorrectErrors(SomeBean7 field3, SomeBean8 field4) {
        this.field3 = field3;
        this.field4 = field4;
    }*/
    // error should be reported  - there is not annotated constructor with args that are not autowired beans
    /*public SetterBindingImportedConfigPropsCorrectErrors(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }*/

    public SomeBean7 getField3() {
        return field3;
    }

    public SomeBean8 getField4() {
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
class SomeBean7 {
    @Override
    public String toString() {
        return "SomeBean7: not binded as property";
    }
}
@Component
class SomeBean8 {
    @Override
    public String toString() {
        return "SomeBean8: not binded as property";
    }
}
