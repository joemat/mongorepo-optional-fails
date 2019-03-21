A tiny test project to demonstrate issues with Spring-Data 2.1.5

When running the testcase of this project from master branch which is based on SpringBoot 2.1.3 this error is thrown:

```
java.lang.UnsupportedOperationException: Cannot set immutable property java.util.Optional.value
```

The same test runs through without error in the springboot-2.0.6 branch.

See also https://stackoverflow.com/questions/53395198/spring-common-data-2-1-2-mongodb-cant-deserialise-optional-value
