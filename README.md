 

---

# Task Management System

## Introduction
The "Task Management System" system is an advanced task management application designed to streamline the process of handling tasks from creation to completion. Developed using Spring Boot and integrated with JPA for database interactions, this system offers a robust solution for users needing efficient task tracking and management in a collaborative environment.

## Features
- **Task Management**: Create, update, retrieve, and delete tasks efficiently through a user-friendly interface.
- **Email Notifications**: Automatic email notifications keep team members informed when tasks are added or completed.
- **Completed Tasks Archive**: Completed tasks are automatically moved to a separate entity, maintaining a clear separation from active tasks.
- **RESTful API**: The system provides a RESTful API for easy integration with other applications or frontend frameworks.

## Technologies Used
- **Spring Boot**: For backend development and application configuration.
- **Java Mail Sender**: For handling email notifications.
- **JPA (Java Persistence API)**: For ORM and database interaction.
- **MySQL Database**: For data storage (configurable).

## Getting Started

### Prerequisites
- Java 11 or later
- Maven
- An SMTP server or configuration for email notifications

### Installation
1. **Clone the repository:**
   ```
   git clone https://github.com/yourgithubusername/task-management-system.git
   cd task-management-system
   ```

2. **Configure application properties:**
   - Update `src/main/resources/application.properties` with your database and email server details.

3. **Build the application:**
   ```
   mvn clean install
   ```

4. **Run the application:**
   ```
   mvn spring-boot:run
   ```

5. **Access the API:**
   - The API will be available at `http://localhost:9080/TDList`

## Usage
- **Add a new task**: POST `/newTask`
- **View all tasks**: GET `/AllTask`
- **Update a task**: PUT `/updateTask/{id}`
- **Complete a task**: PUT `/completedTask/{id}`
- **Delete a task**: DELETE `/deleteTask/{id}`

## Future Improvements
- **Scalability Enhancements**: Optimize the system for higher loads and larger datasets.
- **User Authentication and Authorization**: Integrate OAuth2 for secure API access and operation handling based on user roles.
- **Advanced Reporting**: Develop comprehensive analytics and reporting features for better insight into task management metrics.

##Final Note
While the system may appear simple, it serves as a foundational project to stabilize and enhance backend development skills, particularly with Spring Boot. It acts as an effective learning tool for understanding and applying backend principles and technologies in real-world applications.

---

