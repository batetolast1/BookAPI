# Book API
This app allows users to retrieve information about books stored in mocked database. Data between user and DB is transferred in JSONs using REST API with simple CRUD support (GET, PUT, POST, DELETE).

# Content
What you can do:
- get info about all books (GET, /books)
- get info about a certain book by ID (GET, /books/{id})
- add a new book to database (POST, /books)
- edit book's data (PUT, /books)
- delete a book from database by ID (DELETE, /books/{id})

# Design patterns used:
- REST API
- MVC
- Dependency Injection
- Controller
- Service
- Repository
- DTO + Mapper

# Technologies used: 
- Java 15
- Spring MVC
- Servlets
- Jackson
- Log4j2
- Maven

# Copyright
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
