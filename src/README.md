# Employee Management System

This is a Spring Boot application for managing employees. It includes features such as user authentication, JWT-based security, and API documentation using Swagger.

## Prerequisites

- Java 17
- Gradle
- MySQL

## Getting Started


## Configure the Database
Update the application.properties file with your MySQL database configuration.
- spring.datasource.url=jdbc:mysql://localhost:3306/your_database
- spring.datasource.username=your_username
- spring.datasource.password=your_password
- spring.jpa.hibernate.ddl-auto=update

## Build and Run the Application
- ./gradlew bootRun
- The application will start on http://localhost:8080.
- For saving the employee details, you can use the following API:
- POST:  http://localhost:8080/api/employees
- For fetching all employees, you can use the following API:
- GET:  http://localhost:8080/api/employees


## API Documentation
- Swagger UI is available at http://localhost:8080/swagger-ui.html.  
## Dependencies
- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Web
- Lombok
- Spring Boot Starter Validation
- MySQL Connector
- JSON Web Token (JWT)
- Springdoc OpenAPI UI
- Springdoc OpenAPI Data REST
- Security Configuration
- The application uses JWT for securing the APIs. The security configuration is defined in SecurityConfig.java.  
- Swagger Configuration
- Swagger is configured using Springdoc OpenAPI. The configuration is defined in SwaggerConfig.java.  
