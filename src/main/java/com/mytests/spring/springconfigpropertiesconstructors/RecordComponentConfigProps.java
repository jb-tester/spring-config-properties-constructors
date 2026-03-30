package com.mytests.spring.springconfigpropertiesconstructors;

// error should be shown for @Component-annotated CP record - ok
//@ConfigurationProperties(prefix = "record.config.props")
//@Component
public record RecordComponentConfigProps(String field1, String field2) {
}
