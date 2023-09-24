# Java Cucumber BDD Project with Page Object Model

This is a Java-based Cucumber BDD (Behavior-Driven Development) project built using the Page Object Model (POM) architecture. It is designed for automating web UI applications. This project combines the power of Cucumber for writing feature files in a human-readable format and the Page Object Model for maintaining a clean and maintainable test automation framework.
This repository contains the test automation code to test the Jupiter Toys web application.

## Project Structure

The project structure is organized to promote modularity, scalability, and ease of maintenance. Here's a brief overview of the project structure:

```
java-bdd-jupiter-toys/
|-- src/
|   |-- main/
|   |   |-- java/
|   |   |   |-- framework/lib/
|   |   |   |   |-- HelperMethods.java
|   |   |   |   |-- PropertiesHandler.java
|   |   |   |-- config/
|   |   |   |   |-- AppConfig.java
|   |-- test/
|   |   |-- java/
|   |   |   |-- mz/co/gps/
|   |   |   |   |-- features/
|   |   |   |   |   |-- Cart.feature
|   |   |   |   |   |-- Contact.feature
|   |   |   |   |-- pages/
|   |   |   |   |   |-- ....
|   |   |   |   |-- steps/
|   |   |   |   |   |-- ....
|   |   |   |   |   |-- TestRunner.java
|   |   |   |   |   |-- Hooks.java
|   |   |-- resources/
|   |   |   |-- global.properties
|-- target/
|-- pom.xml
|-- README.md
```

## Dependencies

This project uses the following libraries and frameworks:

- **Cucumber**: A BDD framework for writing feature files and step definitions.
- **Selenium WebDriver**: For interacting with web elements and automating browser actions.
- **Maven**: A build automation and project management tool for managing project dependencies and building the project.
- **JUnit/TestNG**: For test execution and reporting (choose one based on your preference).
- **Gherkin**: The language used to write feature files in a human-readable format.

## Getting Started

1. Clone this repository to your local machine.

```bash
git clone https://github.com/gurpreetskairon/java-bdd-jupiter-toys.git
```

2. Navigate to the project directory.

```bash
cd java-bdd-jupiter-toys
```

3. Install the project dependencies using Maven.

```bash
mvn clean install
```

## Running Tests

You can run the Cucumber tests using the provided runners:

```bash
mvn test
```

To run the tests using a specific tag:
   If we wish to run just the Cart feature test cases, we can specify the tag as follows:

```bash
	mvn verify -Dcucumber.filter.tags="@Cart"
```

To run the tests using multiple tags:
   If we wish to run the tests that match either tag @Contact and tag @Testcase_1, use the following command:

```bash
	mvn verify -Dcucumber.filter.tags="@Cart or @Testcase_1"
```

## Reporting

Test reports will be generated in the `target` directory. You can view them to check the test results and any failures.
