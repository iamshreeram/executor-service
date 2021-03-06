# executor-service

[![Build Status](https://travis-ci.org/iamshreeram/executor-service.svg?branch=master)](https://travis-ci.org/iamshreeram/executor-service)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/us.shreeram.applications/executorservice/badge.svg)](https://maven-badges.herokuapp.com/maven-central/us.shreeram.applications/executorservice)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)


This is rest service which helps in invoking any OS level commands or can be used to trigger scripts that are in any machine where the application runs


## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites

Things you need to build the application

```
Java
Maven
```

### Build the application

A step by step process to build the code to JAR

```
git clone https://github.com/iamshreeram/executor-service.git
```

Extract the folder. Get into the folder do `mvn clean install` where pom.xml is located.

Note : Ensure Maven is configured in your system path

### Run the application

Snapshot version of Jar would have been created in target folder. Run it with below command

```
java -jar executorservice-1.0.jar
```

### Import as dependency

For Maven,

```xml
<dependency>
  <groupId>us.shreeram.applications</groupId>
  <artifactId>executorservice</artifactId>
  <version>1.0</version>
</dependency>
```

For SBT,

```
libraryDependencies += "us.shreeram.applications" % "executorservice" % "1.0"
```


### Next updates

* Monitor Service to check the script status
* Ensure any script or command in OS can run only once
* Accept multiple arguments from user and dynamically pass it to script
* Enable the service to run kernel level commands and return the output
* Host a Single page app to view the details of OS and status.
* Codecov set up is in progress.
