# 🎓 Student Management System

A simple **Spring Boot** application to manage students, departments, courses, and professors, with full CRUD operations, DTOs, validations, and JWT-based authentication.

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **Spring Security + JWT**
- **PostgreSQL**
- **Lombok**
- **Maven**

---

## 📦 Features

✅ Student CRUD  
✅ Department CRUD  
✅ Course CRUD  
✅ Professor CRUD  
✅ Many-to-Many and One-to-Many JPA relationships  
✅ DTOs with validation using Jakarta  
✅ JWT-based authentication (register & login)  
✅ Global exception handling  
✅ Clean and layered architecture (Controller, Service, Repository, Model, DTO)

---

## 📁 Project Structure

src/
└── main/
├── java/
│ └── com.example.student_management/
│ ├── controller/
│ ├── model/
│ ├── dto/
│ ├── repository/
│ ├── service/
│ ├── config/
│ └── security/
└── resources/
├── application.properties
└── ...


---

## 🧪 API Endpoints

### 🔐 Authentication

| Method | Endpoint           | Description       |
|--------|--------------------|-------------------|
| POST   | `/api/auth/register` | Register user     |
| POST   | `/api/auth/login`    | Login + get token |

### 👨‍🎓 Students

| Method | Endpoint                | Description       |
|--------|-------------------------|-------------------|
| GET    | `/api/students/all`     | List all students |
| POST   | `/api/students/create`  | Create student    |
| PUT    | `/api/students/update`  | Update student    |
| DELETE | `/api/students/{id}`    | Delete student    |

> Similar endpoints exist for `/api/departments`, `/api/courses`, and `/api/professors`

---

## ✅ How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/student-management.git
   cd student-management

2. Configure application.properties with your PostgreSQL DB:

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


🧑‍💻 Author
Amr Mohamed
Backend Developer — Spring Boot & Node.js
LinkedIn | GitHub


تحرير
نسخ
تحرير
