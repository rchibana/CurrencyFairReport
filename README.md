# Currency Fair Report

Project responsible for show a report of transactions from CurrencyFair's customers.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 8+
```
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
```

CurrencyFairMessageProcessor Project
```
https://github.com/rchibana/CurrencyFairMessageProcessor
```

### Installing

After the download of Java 8+ and CurrencyFairMessageProcessor, follow the next steps

##### Code:

- Cloning the project:

```
$ git clone https://github.com/rchibana/CurrencyFairReport.git
```

##### Running the project 

- First of all, will be necessary to [start](https://github.com/rchibana/CurrencyFairMessageProcessor#running-the-project) the backend server

- Execute the following command:

```
$ ./gradlew bootRun --args='--spring.profiles.active=dev'
```

After the execution of the command above, you'll be able to access the frontend application.
```
http://localhost:8081/transactions
```

## Running the tests

The idea to run the tests in this project was thought to be easy to maintain and execute as well, bellow the command that must be executed inside the project folder:

```
$ ./gradlew clean build test
```

## Built With

* [Spring](https://spring.io/projects) - The web framework used
* [Gradle](https://gradle.org/) - Dependency Management
* [Intellij](https://www.jetbrains.com/idea/) - IDE used to develop the project

## Authors

* [Rodrigo Chibana](http://github.com/rchibana)
