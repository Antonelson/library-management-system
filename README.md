# 📚 Library Management System

A full-stack **Library Management System** built using **Spring Boot**, **REST APIs**, **JWT Authentication**, **Spring Data JPA**, **Oracle Database**, and a simple **HTML/CSS/JavaScript frontend**.

---

## 🚀 Features

### 🔐 Authentication
- User Registration
- User Login
- JWT-based Authentication
- Secured REST APIs using Spring Security

### 📖 Library Operations
- Add book details
- View book details  
  - View all books  
  - Find book by ID
- Update book details
- Delete book details

---

## 🛠 Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- RESTful APIs
- JWT (JSON Web Token)
- Spring Data JPA (Hibernate)
- Oracle Database
- Maven

### Frontend
- HTML
- CSS
- JavaScript

---

## 📁 Project Structure

```
library-management-system/
│
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   └── resources/
│   │   └── test/
│   ├── pom.xml
│   ├── mvnw
│   └── application.properties
│
├── frontend/
│   ├── Auth/
│   ├── Operation/
│   ├── Scripts/
│   └── index.html
│
└── README.md
```

This project follows a monorepo structure with separate backend and frontend folders.

## 🔐 JWT Authentication Flow

1. User logs in with valid credentials
2. Backend generates a JWT with an expiration time
3. Token is sent to the client
4. Client stores the token in `localStorage`
5. Token is sent in the `Authorization: Bearer <token>` header for every request
6. JWT filter validates the token on each request
7. If valid → access is allowed  
   If invalid or expired → request is rejected

---

## ▶️ How to Run the Project

### Backend

1. Open the `backend` folder in IntelliJ IDEA
2. Update `application.properties` with:
   - Oracle database URL
   - Username
   - Password
   - JWT secret key
3. Run `LibraryApplication.java`

### Frontend

1. Open the `frontend` folder
2. Open `index.html` in a browser
3. Use the login and register pages to interact with backend REST APIs

---

## ⚠️ Notes

- Ensure Oracle Database is running before starting the backend
- Update database credentials correctly in `application.properties`
- JWT token must be sent in the `Authorization` header for protected APIs

---

## 👨‍💻 Author

**Anto Nelson**

---

## ⭐ Support

If you like this project, consider giving it a ⭐ on GitHub 🙂
