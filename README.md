# Book API
This app allows users to retrieve information about books stored in DB. Data between user and DB is transferred in JSONs using REST API with simple CRUD support (GET, PUT, POST, DELETE).

You can also access book data via web admin panel.

# Content
What you can do with API:
- get info about all books (GET, /books)
- get info about a certain book by ID (GET, /books/{id})
- add a new book to database (POST, /books)
- edit book's data (PUT, /books)
- delete a book from database by ID (DELETE, /books/{id})

What you can do with admin panel:
- get info about all books
- get info about a certain book by ID
- add a new book to database
- edit book's data
- delete a book from database by ID

# Design patterns used:
- REST API
- MVC
- Controller
- Service
- Repository
- DTO + Mapper
- validators

# Technologies used: 
- Java
- Spring MVC, servlets, JSTL
- Hibernate, Hibernate Validator, Spring ORM
- Spring Data
- MySQL
- ModelMapper
- Jackson
- Lombok
- webjars
- Maven

# Copyright
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
