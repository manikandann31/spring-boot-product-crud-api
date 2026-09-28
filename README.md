# Spring Boot Product CRUD API

A RESTful Product Management API developed using Spring Boot,
Spring Data JPA, Hibernate and MySQL.

## Tech Stack

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- Git & GitHub

## Features

- Create a product
- Retrieve all products
- Retrieve product by ID
- Update product
- Delete product
- Persistent data storage using MySQL
- RESTful API architecture

## Project Architecture

Client
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
JPA/Hibernate
  ↓
MySQL

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /product/api/create | Create product |
| GET | /product/api/products | Get all products |
| GET | /product/api/product/{id} | Get product by ID |
| PUT | /product/api/update/{id} | Update product |
| DELETE | /product/api/delete/{id} | Delete product |

## Example Request

POST /product/api/create

{
    "name": "Laptop",
    "price": 55000
}

## Example Response

{
    "id": 1,
    "name": "Laptop",
    "price": 55000
}

## How to Run

1. Clone the repository
2. Open the project in Eclipse/IntelliJ
3. Configure MySQL
4. Update application.yml
5. Run the Spring Boot application
6. Test APIs using Postman
