# Student Teacher Course Management System

## Overview
This project is a simple management system for handling students, teachers, and courses. It utilizes MySQL as the database management system, Thymeleaf for frontend templating, and Spring Boot for backend development.

## Features
- **Student Management:** Add, update, delete, and view student information.
- **Teacher Management:** Add, update, delete, and view teacher information.
- **Course Management:** Assign courses to students and teachers, view course details.

## Technologies Used
- **Frontend:** Thymeleaf
- **Backend:** Spring Boot
- **Database:** MySQL

## Setup Instructions
1. **Database Setup:**
   - Install MySQL on your local machine if not already installed.
   - Create a new database schema named `students`.

2. **Clone the Repository:**
   ```bash
   git clone <repository_url>
   ```

3. **Configure Database:**
   - Open application.properties file located in src/main/resources.
   - Update database connection properties (URL, username, password) according to your MySQL setup.

4. **Run the Application:**
   - Navigate to the project directory.
   - Run the following command:
    ```bash
    ./mvnw spring-boot:run
    ```
This will start the Spring Boot application.

5. **Access the Application:**

  - Open a web browser.
  - Visit http://localhost:8080 to access the application.

## Project Structure
The project structure is organized as follows:
```
student-teacher-course-management/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.sms/
│   │   │       ├── controller/
│   │   │       │   ├── StudentController.java
│   │   │       │   ├── TeacherController.java
│   │   │       │   └── CourseController.java
│   │   │       ├── model/
│   │   │       │   ├── Student.java
│   │   │       │   ├── Teacher.java
│   │   │       │   └── Course.java
│   │   │       ├── repository/
│   │   │       │   ├── StudentRepository.java
│   │   │       │   ├── TeacherRepository.java
│   │   │       │   └── CourseRepository.java
│   │   │       ├── service/
│   │   │       │   ├── SMSService.java
│   │   │       └── StudentsApplication.java
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   └── templates/
│   │   │       ├── students.html
│   │   │       ├── teachers.html
│   │   │       ├── courses.html
│   │   │       ├── createStudent.html
│   │   │       ├── createTeacher.html
│   │   │       ├── createCourse.html
│   │   │       ├── updateStudent.html
│   │   │       ├── updateTeacher.html
│   │   │       └── updateCourse.html
│   │   └── webapp/
│   └── test/
├── pom.xml
└── README.md
```

## UI

1. **Student View {http://localhost:8080/students}**
   
   <img width="1285" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/15f9321f-312b-483b-b279-d9fb7196c4ff">
   <img width="1260" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/c0f2ec22-0376-460d-b901-865dc1f53bf2">
   <img width="1255" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/25f4fc07-8bf4-4dd8-be0a-5a32cc2ef78e">
   <img width="1252" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/4d644dfd-7f6f-453a-b6d1-ab12bbfa8546">
   <img width="1246" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/2169d641-f394-4eef-8853-7e9e90fbdaed">

2. **Teachers View {http://localhost:8080/teachers}**
   
   <img width="1282" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/257451c4-f822-4a3b-9efd-9316f030cd3d">
   <img width="1240" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/84a24d6e-3bf1-44bf-b6d5-741cb3ff6a99">
   <img width="1238" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/87fd8778-762f-46c1-aad0-5644739d9d71">
   <img width="1217" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/c9d8be7d-3afe-46e9-a006-e1bcb8b115b1">
   <img width="1225" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/a7ed202d-71fc-4f35-b711-db039e28c811">


2. **Courses View {http://localhost:8080/courses}**
   <img width="1241" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/e35c5385-f623-4fa4-afbb-2c71dac8f5aa">
   <img width="1257" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/9fd667cf-a6cf-422a-9331-f9c6794baf03">
   <img width="1238" alt="image" src="https://github.com/hspsuhas/StudentManagementSystem/assets/85097320/13cc2088-2685-442a-add9-a4e380122632">


