# Configuration Properties Binding with Constructors and setters

the constructor binding should be used if both of the following are true:
1) the class is enabled as ConfigurationProperties via @EnableConfigurationProperties
  or scanned via @ConfigurationPropertiesScan
2) the class has a single constructor with parameters, or 
   single @ConstructorBinding annotated constructor

the setter binding should be used if the class has @Component annotation 
or is added as @Bean to the application context, even if it has some constructor.
Error should be reported for @ConstructorBinding annotations in the @Component class
and @Bean class.

Of course, any ConfigurationProperties class w/o constructor should use setter binding.

The records can be only scanned or enabled, @Component or @Bean cannot be used.
Actually we show the error in the @Component class - ok, but the @Bean class is not
reported.


https://youtrack.jetbrains.com/issue/IDEA-386403/Spring-Boot-config-keys-collected-in-a-wrong-way-when-both-constructor-and-setters-present

Special case: @ConfigurationProperties-annotated class imported via @Import: similar to @Component-annotated classes
https://youtrack.jetbrains.com/issue/IDEA-295486/Spring-Boot-report-as-error-the-ConfigurationProperties-annotated-class-with-explicit-or-implicit-ConstructorBinding-if-it-is
