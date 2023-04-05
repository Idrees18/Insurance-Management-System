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
  * 'com.insurance': Contains the main application class and configuration files.
  * 'com.insurance.insurance_management.controller': Contains the RESTful API controllers.
  * 'com.insurance.insurance_management.entities': Contains the domain model classes.
  * 'com.insurance.insurance_management.repositories': Contains the Spring Data JPA repositories.
  * 'com.insurance.insurance_management.services: Contains the service classes that implement business logic.
* 'src/main/resources': Contains the application properties files.
* 'src/test': Contains the test classes.

## How to Run Locally

1. Clone the repository: git clone https://github.com/your-username/insurance-management-system.git
2. Navigate to the project directory: cd insurance-management-system
3. Build the project: mvn clean install
4. Run the project: mvn spring-boot:run
5. The application will start on port 8080. You can access the RESTful APIs using a tool like Postman.

## API Requests
The following API requests are available:

### Clients
* GET /api/clients: Fetch all clients.
* GET /api/clients/{id}: Fetch a specific client by ID.
* POST /api/clients: Create a new client.
* PUT /api/clients/{id}: Update a client's information.
* DELETE /api/clients/{id}: Delete a client.

## Insurance Policies
* GET /api/policies: Fetch all insurance policies.
* GET /api/policies/{id}: Fetch a specific insurance policy by ID.
* POST /api/policies: Create a new insurance policy.
* PUT /api/policies/{id}: Update an insurance policy.
* DELETE /api/policies/{id}: Delete an insurance policy.

## Claims
* GET /api/claims: Fetch all claims.
* GET /api/claims/{id}: Fetch a specific claim by ID.
* POST /api/claims: Create a new claim.
* PUT /api/claims/{id}: Update a claim's information.
* DELETE /api/claims/{id}: Delete a claim.

## Postman 

In this project, we have tested the RESTful APIs using the Postman application. We have created different requests for each API endpoint and tested various scenarios to ensure the proper functioning of the APIs.

For example, we have tested GET requests to fetch all clients, policies, and claims, as well as GET requests to fetch a specific client, policy, or claim by ID. We have also tested POST requests to create new clients, policies, and claims, PUT requests to update their information, and DELETE requests to remove them from the database.

During testing, we have ensured that the APIs are handling exceptions and validations properly. We have tested edge cases, such as creating a client with missing information, updating a non-existent policy, or deleting a claim associated with a policy.

Overall, we have used the Postman application to thoroughly test the APIs and ensure their proper functionality.

