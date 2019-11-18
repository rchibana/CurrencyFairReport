# Currency Fair Report

Project responsible for show a report of transactions from CurrencyFair's customers.

## Problem Approach 

Thinking about all the points described on the paper, I decided to create this project separating frontend from backend,
 and below you'll be able to see my explanations:

1 - It's easier to scale, if necessary

2 - This application is light, so won't be necessary a robust machine, saving some money.

3 - I added a cache system to external calls, so it will avoid some overhead on the backend

4 - Spring Sleuth was added in this system as the backend, in order to track all the request and find out if there's a problem with the system's flow

5 - To build the frontend, I decided to use thymeleaf and bootstrap to be more productive. 

### Some improvements to the future

1 - We could add redis as a system of cache

2 - Some other kind of reports could be showed, like a chart or a dashboard 

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
