📌 Project Management System API

A secure and scalable REST API for managing users, projects, tasks, and change logs, built using Java 21, Spring Boot, Spring Security (JWT), and PostgreSQL.

The system enforces role-based access control (RBAC) and provides a complete audit trail for task updates.

🌐 Live Deployment
🔗 Frontend (React + Tailwind)
https://project-management-dendev.vercel.app/logs
☁️ Backend API
Dockerized and deployed on Render
🚀 Features
📊 Dashboard Overview

The system provides a quick summary of key data:

Total number of users (members)
Total number of projects
Total number of tasks

These metrics are displayed in the frontend dashboard for quick insights.

🔐 Authentication
User registration & login
JWT-based authentication
Secure password encryption
👥 User Management
Get current authenticated user
Update user profile (authenticated users)
Change password (authenticated users)

ADMIN only:

View all users
Get user by ID
Delete users
📁 Project Management (ADMIN)
Create project
Update project
Delete project
Get all projects
Get project by ID
✅ Task Management

ADMIN:

Create, update, delete tasks
View all tasks

USER:

View assigned tasks only
Update task status

SHARED:

Get task by ID (with access validation)
📝 Change Logs
Automatically created when task status changes
Stores remarks and status updates

ADMIN can:

View all logs
View logs per task
Delete logs
🛠️ Tech Stack
Backend
Java 21
Spring Boot
Spring Security
JWT Authentication
Spring Data JPA (Hibernate)
PostgreSQL
Lombok
Frontend
React (Create React App)
Tailwind CSS
Axios
Deployment
Docker (Backend containerization)
Render (Backend hosting)
Vercel (Frontend hosting)
⚙️ Setup (Backend)
1. Clone Repository
git clone https://github.com/your-username/project-management.git
cd project-management
2. Configure Application Properties
spring.datasource.url=YOUR_DB_URL
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

secretJwtString=YOUR_SECRET_KEY
3. Run Application
mvn spring-boot:run
4. Base URL
http://localhost:8082
🎨 Frontend Setup (React - No Vite)
1. Create App
npx create-react-app project-management-frontend
cd project-management-frontend
2. Install Dependencies
npm install axios react-router-dom
npm install -D tailwindcss postcss autoprefixer
npx tailwindcss init -p
3. Run Frontend
npm start
🔐 Authentication
Register
POST /api/auth/register
Login
POST /api/auth/login
Authorization Header
Authorization: Bearer <token>
📊 Dashboard Integration (Frontend)

Use these endpoints to display totals:

Total Users    → /api/users/total_members
Total Projects → /api/total_projects
Total Tasks    → /api/total_tasks

Counts can be derived from response length or improved with a dedicated dashboard endpoint.

📌 API Endpoints
🔐 Auth (/api/auth)
Method	Endpoint	Access
POST	/register	Public
POST	/login	Public
👤 Users (/api/users)
Method	Endpoint	Description	Access
GET	/current	Get current user	Authenticated
GET	/get_all_member	Get all users	ADMIN
GET	/get_member?id={id}	Get user by ID	ADMIN
PUT	/update_member?id={id}	Update user	Authenticated
PATCH	/change_password	Change password	Authenticated
DELETE	/delete_member?id={id}	Delete user	ADMIN
📁 Projects (/api/projects)
Method	Endpoint	Description	Access
GET	/	Get all projects	ADMIN
GET	/get_project?id={id}	Get project by ID	ADMIN
POST	/create	Create project	ADMIN
PUT	/update?id={id}	Update project	ADMIN
DELETE	/delete?id={id}	Delete project	ADMIN
✅ Tasks (/api/tasks)
Method	Endpoint	Description	Access
GET	/	Get tasks (ADMIN = all, USER = assigned)	ADMIN, USER
GET	/find_by_id?id={id}	Get task by ID	ADMIN, USER
POST	/create	Create task	ADMIN
PUT	/update?id={id}	Update task	ADMIN
PATCH	/update_status?id={id}	Update task status (with remarks)	ADMIN, USER
DELETE	/delete?id={id}	Delete task	ADMIN
📝 Change Logs (/api/change_logs)
Method	Endpoint	Description	Access
GET	/	Get all logs	ADMIN
GET	/get_change_log?id={taskId}	Get task history	ADMIN
DELETE	/delete?id={id}	Delete log	ADMIN
🧠 Business Rules
🔐 Roles
👑 ADMIN
Full access to system
Manage users, projects, tasks, and logs
👤 USER
View assigned tasks only
Update task status
Update profile & change password
🔄 Task & Change Log Behavior
Default task status: TODO
Status updates include:
New status
Optional remark
Every update:
Creates a Change Log
Stores:
user
status
remark
timestamp
🔒 Security
JWT-based authentication
Password encryption using PasswordEncoder
Method-level authorization:
@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
@PreAuthorize("isAuthenticated()")
⚠️ Notes
Uses @RequestParam instead of RESTful paths:
/api/projects/get_project?id=1
Ensure JWT token is included in secured endpoints
Access control enforced via @PreAuthorize
📦 Future Improvements
Add /dashboard/summary endpoint (totals)
Convert to RESTful endpoints (/projects/{id})
Add pagination & filtering
Global exception handler
Unit & integration tests
CI/CD pipeline
👨‍💻 Author

DenDev
