# BDD Test Automation Framework
This project is a BDD test automation framework, which provides structured and standard way of creating automated test scripts for GUI tests across application. 

## Tools & Libraries
The test automation framework comprises following tools and libraries currently, can be added/updated as per own need:
* Cucumber-JVM: BDD Framework
* Custom Page Object Pattern and utility functions
* Selenium WebDriver
* JAVA
* TestNg
* Maven
* Lombok

## Machine Configuration
Configure Ubuntu / Windows and setup:
* Java 8
* Git
* Maven

## Compile, Build and Run Tests
* Execution through Runner file:
  * For sequential execution, goto the TripSearchRunner.java file and Run it.

* Execution through Maven:
  * Under pom.xml file, created a profile 
    * Trip-search-runner: For sequential execution.
    * Command to execute profile: "mvn clean verify -P Trip-search-runner"

## Reports
* Cucumber provides multiple formats to produce reports and configure in Runner files. Currently following reports are configured:
  * HTML Report: target/cucumber-reports/cucumber.html
  * XML Report: target/cucumber-reports/Cucumber.xml
  * JSON Report: target/cucumber-reports/Cucumber.json

## Reference framework
* Link: https://github.com/TestCraftStatusneo/BDDFRAMEWORK
