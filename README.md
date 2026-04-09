# 📌 Project Management System API

A secure and scalable REST API for managing **users, projects, tasks, and change logs**, built with **Java 21**, **Spring Boot**, **Spring Security (JWT)**, and **PostgreSQL**.

The system enforces **role-based access control (RBAC)** and provides a full **audit trail** for task changes.

---

## 🚀 Features

### 🔐 Authentication

* User registration & login (JWT)
* Secure password encryption
* Token-based authorization

---

### 👥 User Management

* Get current authenticated user
* Update user profile (authenticated users)
* Change password (authenticated users)
* Admin-only:

  * View all users
  * Get user by ID
  * Delete user

---

### 📁 Project Management (ADMIN)

* Create project
* Update project
* Delete project
* View all projects

---

### ✅ Task Management

* ADMIN:

  * Create, update, delete tasks
  * View all tasks
* USER:

  * View assigned tasks
  * Update task status
* Shared:

  * Get task by ID (with access validation)

---

### 📝 Change Logs

* Automatically created when task status changes
* Includes remarks and status updates
* ADMIN can:

  * View all logs
  * View logs per task
  * Delete logs

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

## ⚙️ Setup

### 1. Clone Repository

```bash id="clone1"
git clone https://github.com/your-username/project-management.git
cd project-management
```

---

### 2. Configure Environment

```properties id="config1"
spring.datasource.url=YOUR_DB_URL
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

secretJwtString=YOUR_SECRET_KEY
```

---

### 3. Run Application

```bash id="run1"
mvn spring-boot:run
```

---

### 4. Base URL

```id="base1"
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

### Header

```
Authorization: Bearer <token>
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

| Method | Endpoint               | Description         | Access        |
| ------ | ---------------------- | ------------------- | ------------- |
| GET    | /current               | Get current user    | Authenticated |
| GET    | /get_all_member        | Get all users       | ADMIN         |
| GET    | /get_member?id={id}    | Get user by ID      | ADMIN         |
| PUT    | /update_member?id={id} | Update user profile | Authenticated |
| PATCH  | /change_password       | Change password     | Authenticated |
| DELETE | /delete_member?id={id} | Delete user         | ADMIN         |

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
| GET    | /find_by_id?id={id}    | Get task by ID                                | ADMIN, USER |
| POST   | /create                | Create task                                   | ADMIN       |
| PUT    | /update?id={id}        | Update task                                   | ADMIN       |
| PATCH  | /update_status?id={id} | Update task status (with remarks)             | ADMIN, USER |
| DELETE | /delete?id={id}        | Delete task                                   | ADMIN       |

---

### 📝 Change Logs (`/api/change_logs`)

| Method | Endpoint                    | Description      | Access |
| ------ | --------------------------- | ---------------- | ------ |
| GET    | /                           | Get all logs     | ADMIN  |
| GET    | /get_change_log?id={taskId} | Get task history | ADMIN  |
| DELETE | /delete?id={id}             | Delete log       | ADMIN  |

---

## 🧠 Business Rules

### 🔐 Roles

#### 👑 ADMIN

* Full system access
* Manages users, projects, tasks, and logs

#### 👤 USER

* Can view assigned tasks only
* Can update task status
* Can update profile & change password

---

### 🔄 Task & Change Log Behavior

* Default task status: `TODO`
* Updating status requires:

  * New status
  * Optional remark
* Every update:

  * Creates a **ChangeLog record**
  * Stores:

    * user
    * status
    * remark
    * timestamp

---

## 🔒 Security

* JWT Authentication
* Password encryption using `PasswordEncoder`
* Method-level authorization:

```java id="sec1"
@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
```

```java id="sec2"
@PreAuthorize("isAuthenticated()")
```

---

## ⚠️ Notes

* Uses `@RequestParam` instead of RESTful path variables:

```
/api/tasks/update?id=1
```

* Ensure JWT token is included in all secured endpoints

* Access control is enforced at method level

---

## 📦 Future Improvements

* Convert endpoints to RESTful (`/tasks/{id}`)
* Add pagination & filtering
* Unit & integration testing
* Docker & CI/CD
* Role hierarchy improvements

---

## 👨‍💻 Author

Judens Bandal (DenDev)

---
