# Spring Boot CRUD Application with H2 Database

A simple CRUD (Create, Read, Update, Delete) application built with Java 17, Spring Boot 3.1.5, Spring Data JPA, and H2 in-memory database.

## Features

- RESTful API for User management
- Spring Data JPA for database operations
- H2 in-memory database
- Lombok for reducing boilerplate code
- Full CRUD operations

## Technologies Used

- Java 17
- Spring Boot 3.1.5
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## Project Structure

```
crud-app/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/crudapp/
│       │       ├── controller/
│       │       │   └── UserController.java
│       │       ├── entity/
│       │       │   └── User.java
│       │       ├── repository/
│       │       │   └── UserRepository.java
│       │       ├── service/
│       │       │   ├── UserService.java
│       │       │   └── impl/
│       │       │       └── UserServiceImpl.java
│       │       └── CrudAppApplication.java
│       └── resources/
│           └── application.properties
└── pom.xml
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. Clone or navigate to the project directory
2. Run the application using Maven:

```bash
mvn spring-boot:run
```

Or build and run the JAR:

```bash
mvn clean package
java -jar target/crud-app-1.0.0.jar
```

The application will start on `http://localhost:8080`

### Accessing H2 Console

The H2 database console is available at: `http://localhost:8080/h2-console`

**Connection Details:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

## API Endpoints

### Create User
```
POST /api/users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "phone": "1234567890",
  "address": "123 Main St"
}
```

### Get All Users
```
GET /api/users
```

### Get User by ID
```
GET /api/users/{id}
```

### Get User by Email
```
GET /api/users/email/{email}
```

### Update User
```
PUT /api/users/{id}
Content-Type: application/json

{
  "name": "John Updated",
  "email": "john.updated@example.com",
  "phone": "0987654321",
  "address": "456 Oak Ave"
}
```

### Delete User
```
DELETE /api/users/{id}
```

## Testing with cURL

### Create a User
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"John Doe\",\"email\":\"john@example.com\",\"phone\":\"1234567890\",\"address\":\"123 Main St\"}"
```

### Get All Users
```bash
curl http://localhost:8080/api/users
```

### Get User by ID
```bash
curl http://localhost:8080/api/users/1
```

### Update User
```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"John Updated\",\"email\":\"john.updated@example.com\",\"phone\":\"0987654321\",\"address\":\"456 Oak Ave\"}"
```

### Delete User
```bash
curl -X DELETE http://localhost:8080/api/users/1
```

## Response Codes

- `200 OK` - Successful GET/PUT request
- `201 Created` - Successful POST request
- `204 No Content` - Successful DELETE request
- `400 Bad Request` - Invalid request (e.g., duplicate email)
- `404 Not Found` - Resource not found

## Database Schema

### User Table
| Column  | Type         | Constraints           |
|---------|--------------|----------------------|
| id      | BIGINT       | PRIMARY KEY, AUTO_INCREMENT |
| name    | VARCHAR(255) | NOT NULL             |
| email   | VARCHAR(255) | NOT NULL, UNIQUE     |
| phone   | VARCHAR(255) |                      |
| address | VARCHAR(255) |                      |

## License

This project is open source and available for educational purposes.