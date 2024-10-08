# LibrarySystem Backend Restful API

This project is a backend RESTful API for managing a library system. It allows users to manage books, patrons, and borrowing records.

## Table of Contents
- [Installation Guide](#installation-guide)
- [API Endpoints](#api-endpoints)
    - [Books API](#books-api)
    - [Patrons API](#patrons-api)
    - [Records API](#records-api)
- [License](#license)

## Installation Guide

### 1. Run SQL Queries
Before starting the project, ensure your database is set up correctly.

1. Locate the SQL files in the `sql/` folder.
2. Execute the SQL queries in your desired database (e.g., MySQL, PostgreSQL, etc.) to create the necessary tables and populate initial data.

### 2. Import Project into IntelliJ IDEA
1. Open **IntelliJ IDEA**.
2. Choose `File > Open`, then navigate to the root directory of the project and select it.
3. IntelliJ IDEA will automatically detect the project structure.

### 3. Run Maven to Download Dependencies
Once the project is loaded into IntelliJ IDEA:

1. Open the **Maven** window (usually on the right side of the screen).
2. Click on the **Reload** button to download the project's dependencies from `pom.xml`.

### 4. Edit `application.properties`
Update the database connection in `src/main/resources/application.properties` with your specific database configuration:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```

Once completed, the application should be ready to run!

---

## API Endpoints

### Books API

- **GET** `findAll()`: `/books`
  - Fetches all books in the library.
  
- **GET** `getBook()`: `/books/{bookId}`
  - Fetches details of a specific book using the `bookId`.
  
- **POST** `addBook()`: `/books`
  - Adds a new book to the library. The book details must be provided in the request body.
  
- **PUT** `updateBook()`: `/books/{bookID}`
  - Updates the details of an existing book using the `bookID`.
  
- **DELETE** `deleteBook()`: `/books/{bookID}`
  - Deletes a book from the library using the `bookID`.

### Patrons API

- **GET** `findAll()`: `/patrons`
  - Fetches all library patrons.
  
- **GET** `getPatron()`: `/patrons/{patronId}`
  - Fetches details of a specific patron using the `patronId`.
  
- **POST** `addPatron()`: `/patrons`
  - Adds a new patron to the library system. The patron details must be provided in the request body.
  
- **PUT** `updatePatron()`: `/patrons/{patronID}`
  - Updates the details of an existing patron using the `patronID`.
  
- **DELETE** `deletePatron()`: `/patrons/{patronID}`
  - Deletes a patron from the library system using the `patronID`.

### Records API

- **POST** `borrowBook()`: `/api/record/{bookId}/patron/{patronId}`
  - Allows a patron to borrow a book using the `bookId` and `patronId`.
  
- **PUT** `returnBook()`: `/api/record/{bookId}/patron/{patronId}`
  - Records the return of a borrowed book by a patron.

---

## License

This project is licensed under the MIT License.

---

This README file provides a clear installation guide, API documentation, and essential steps for using the LibrarySystem Backend. Feel free to modify it based on your specific project needs!
