# Spring Security Authentication

A backend authentication project built using **Java, Spring Boot, Spring Security, and PostgreSQL**. This project demonstrates secure user registration and login authentication with BCrypt password encryption and database-backed user authentication.

## 🚀 Features

- User Registration API
- User Login API
- Password encryption using BCrypt
- Database integration using Spring Data JPA
- Custom UserDetailsService implementation
- Authentication using AuthenticationManager
- Spring Security Filter Chain configuration
- CSRF protection
- Duplicate username validation
- Many-to-Many relationship between Users and Roles

## 🛠️ Technologies Used

- Java 22
- Spring Boot 4
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok
- Postman

## 📂 Project Structure

```text
src/main/java/com/strike/SpringSecurity
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   └── AuthController.java
│
├── dto
│   ├── LoginRequestDto.java
│   ├── LoginResponseDto.java
│   ├── RegisterRequestDto.java
│   └── RegisterResponseDto.java
│
├── model
│   ├── User.java
│   └── Role.java
│
├── repository
│   └── UserRepository.java
│
└── service
    ├── AuthService.java
    └── CustomUserDetailsService.java
```

## ⚙️ Configuration

1. Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/spring-security-authentication.git
```

2. Open the project in IntelliJ IDEA or Eclipse.

3. Create a PostgreSQL database:

```sql
CREATE DATABASE springsecurity;
```

4. Configure your database credentials in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/springsecurity
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

5. Run the Spring Boot application.

## 🔗 API Endpoints

### 1. User Registration

**Endpoint:**

```http
POST /api/auth/register
```

**Request Body:**

```json
{
  "username": "Aman",
  "password": "123456"
}
```

**Success Response:**

```json
{
  "username": "Aman",
  "message": "User Registered"
}
```

### 2. User Login

**Endpoint:**

```http
POST /api/auth/login
```

**Request Body:**

```json
{
  "username": "Aman",
  "password": "123456"
}
```

**Success Response:**

```json
{
  "username": "Aman",
  "message": "Login Successful"
}
```

**Invalid Credentials:**

Returns `401 Unauthorized` with a login failure message, if configured in the controller.

### 3. CSRF Token

**Endpoint:**

```http
GET /api/auth/csrf
```

Used to retrieve the CSRF token required for protected POST requests.

## 🔐 Authentication Flow

1. The client sends login credentials to the AuthController.
2. AuthController forwards the request to AuthService.
3. AuthService calls AuthenticationManager.
4. AuthenticationManager delegates authentication to an appropriate authentication provider.
5. CustomUserDetailsService retrieves user details from PostgreSQL.
6. PasswordEncoder verifies the entered password against the stored BCrypt password.
7. Spring Security returns the authentication result.
8. AuthService returns the login response.

## 🔒 Security Implementation

- Passwords are stored in BCrypt encoded format.
- Authentication is handled by Spring Security.
- CustomUserDetailsService loads user information from the database.
- CSRF protection is enabled using CookieCsrfTokenRepository.
- Public and authenticated endpoints are configured through SecurityFilterChain.

## 📚 Learning Objectives

Through this project, I am learning and implementing:

- Spring Security fundamentals
- Authentication and Authorization
- UserDetails and UserDetailsService
- AuthenticationManager
- PasswordEncoder and BCrypt
- SecurityFilterChain
- CSRF Protection
- Database-backed authentication

## 🚧 Future Improvements

- JWT Authentication
- JWT Authorization Filter
- Role-Based Access Control (RBAC)
- Protected REST APIs
- Global Exception Handling
- Refresh Token Mechanism

## 👨‍💻 Developer

**Aman Nasir Naikwade**

Aspiring Java Full Stack Developer

- GitHub: https://github.com/Aman8669
- Portfolio: https://aman-naikwade-portfolio.onrender.com/

---

⭐ If you find this project useful, feel free to explore the repository!