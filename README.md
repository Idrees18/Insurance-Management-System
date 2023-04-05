# Insurance-Management-System
The Insurance Management System is a web application built using Spring Boot, Spring Data JPA, and MySQL that allows users to manage clients, insurance policies, and claims. The system provides RESTful APIs for creating, updating, retrieving, and deleting clients, insurance policies, and claims. The APIs are implemented with exception handling and validation to ensure proper API usage and data integrity.

## Features
* Manage clients: Users can create, update, retrieve, and delete clients.
* Manage insurance policies: Users can create, update, retrieve, and delete insurance policies associated with a client.
* Manage claims: Users can create, update, retrieve, and delete claims associated with an insurance policy.
* Exception handling: The system provides proper error messages and HTTP status codes when exceptions occur.
* Validation: The system validates API requests to ensure data integrity.
* Embedded database or MySQL: The system can use either an embedded database or MySQL.

## Project Structure

The project is structured as follows:

* 'src/main/java': Contains the source code.
** 'com.insurance': Contains the main application class and configuration files.
** 'com.insurance.insurance_management.controller': Contains the RESTful API controllers.
** 'com.insurance.insurance_management.entities': Contains the domain model classes.
** 'com.insurance.insurance_management.repositories': Contains the Spring Data JPA repositories.
** 'com.insurance.insurance_management.services: Contains the service classes that implement business logic.
* 'src/main/resources': Contains the application properties files.
* 'src/test': Contains the test classes.

