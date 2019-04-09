# Selenium - Java - Maven - Cucumber
## Installation
Install !(Java JDK)[https://www.oracle.com/technetwork/java/javase/downloads/index.html] and !(Maven)[http://maven.apache.org/] and install the required tools
```bash
mvn clean install
```

## Running Cucumber Tests
Running a feature file 
```bash
mvn clean test -Dcucumber.options="src/test/java/features/facebook_login.feature"
```

Running a tag
```bash
mvn clean test -Dcucumber.options="src/test/java/features --tags @@facebook_login"
```

## Reporting 
surefile reports >> target/surefire-reports
cucumber reports >> target/cucumber-html-report
