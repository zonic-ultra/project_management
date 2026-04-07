# 📌 Project Management System API

A secure and scalable RESTful API for managing **users, projects, tasks, and change logs**, built using **Java 21**, **Spring Boot**, **Spring Security (JWT)**, and **PostgreSQL**.

This system enforces **role-based access control (RBAC)** and tracks all task activity through **change logs (audit trail)**.

---

## 🚀 Features

### 🔐 Authentication

* User registration
* JWT-based login
* Secure password encryption

### 👥 User Management

* Get current authenticated user
* Get all users (ADMIN only)
* Get user by ID (ADMIN only)
* Delete user (ADMIN only)

### 📁 Project Management

* Create project (ADMIN)
* Update project (ADMIN)
* Delete project (ADMIN)
* View all projects (ADMIN)

### ✅ Task Management

* Create, update, delete tasks (ADMIN)
* View tasks:

  * ADMIN → all tasks
  * USER → assigned tasks only
* Update task status (ADMIN & USER)

### 📝 Change Logs

* Track all task changes automatically
* View all logs (ADMIN)
* View task-specific logs (ADMIN)
* Delete log (ADMIN)

---

## 🛠️ Tech Stack

* **Java 21**
* **Spring Boot**
* **Spring Security**
* **JWT Authentication**
* **Spring Data JPA (Hibernate)**
* **PostgreSQL**
* **Lombok**

---

## ⚙️ Setup Guide

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/project-management.git
cd project-management
```

---

### 2. Configure Application Properties

```properties
spring.datasource.url=YOUR_DB_URL
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

secretJwtString=YOUR_SECRET_KEY
```

---

### 3. Run the Application

```bash
mvn spring-boot:run
```

---

### 4. Base URL

```
http://localhost:8082
```

---

## 🔐 Authentication

### Register

```
POST /api/auth/register
```

### Login

```
POST /api/auth/login
```

### Authorization Header

```
Authorization: Bearer <your_token>
```

---

## 📌 API Endpoints

---

### 🔐 Auth (`/api/auth`)

| Method | Endpoint  | Access |
| ------ | --------- | ------ |
| POST   | /register | Public |
| POST   | /login    | Public |

---

### 👤 Users (`/api/users`)

| Method | Endpoint               | Description      | Access      |
| ------ | ---------------------- | ---------------- | ----------- |
| GET    | /current               | Get current user | ADMIN, USER |
| GET    | /get_all_member        | Get all users    | ADMIN       |
| GET    | /get_member?id={id}    | Get user by ID   | ADMIN       |
| DELETE | /delete_member?id={id} | Delete user      | ADMIN       |

---

### 📁 Projects (`/api/projects`)

| Method | Endpoint        | Description      | Access |
| ------ | --------------- | ---------------- | ------ |
| GET    | /               | Get all projects | ADMIN  |
| POST   | /create         | Create project   | ADMIN  |
| PUT    | /update?id={id} | Update project   | ADMIN  |
| DELETE | /delete?id={id} | Delete project   | ADMIN  |

---

### ✅ Tasks (`/api/tasks`)

| Method | Endpoint               | Description                                   | Access      |
| ------ | ---------------------- | --------------------------------------------- | ----------- |
| GET    | /                      | Get tasks (ADMIN = all, USER = assigned only) | ADMIN, USER |
| GET    | /find_by_id?id={id}    | Get task by ID                                | ADMIN       |
| POST   | /create                | Create task                                   | ADMIN       |
| PUT    | /update?id={id}        | Update task                                   | ADMIN       |
| PATCH  | /update_status?id={id} | Update task status                            | ADMIN, USER |
| DELETE | /delete?id={id}        | Delete task                                   | ADMIN       |

---

### 📝 Change Logs (`/api/change_logs`)

| Method | Endpoint                    | Description      | Access |
| ------ | --------------------------- | ---------------- | ------ |
| GET    | /                           | Get all logs     | ADMIN  |
| GET    | /get_change_log?id={taskId} | Get task history | ADMIN  |

---

## 🧠 Business Rules

### 🔐 Role-Based Access

#### 👑 ADMIN

* Full access to all modules
* Can manage users, projects, and tasks
* Can view all change logs

#### 👤 USER

* Can only view tasks assigned to them
* Can update task status

---

### 🔄 Task Behavior

* Default status: `TODO`
* Status can be updated by both ADMIN and USER
* Every status update automatically creates a **change log**

---

### 📝 Change Logs

Each log contains:

* Task reference
* Updated status
* User who made the change
* Optional remarks
* Timestamp

---

## 🔒 Security

* JWT-based authentication
* Password encryption using `PasswordEncoder`
* Method-level security using:

```java
@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
```

---

## ⚠️ Notes

* API uses `@RequestParam` instead of RESTful path variables:

```
/api/tasks/update?id=1
```

* Change logs are restricted to ADMIN only

* Always include JWT token for protected endpoints

---

## 📦 Future Improvements

* Convert endpoints to RESTful format (`/tasks/{id}`)
* Add pagination & filtering
* Improve validation handling
* Add unit and integration tests
* Dockerize application
* CI/CD pipeline setup

---

## 👨‍💻 Author

**DenDev**


MIT License
