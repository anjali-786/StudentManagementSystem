# 🎓 Student Management System

A **console-based Student Management System developed using Core Java**. The application allows users to manage student records through CRUD operations and provides persistent file storage so that student data is retained even after the application is closed.

This project was developed to demonstrate practical understanding of **Java, Object-Oriented Programming, Collections Framework, File Handling, Exception Handling, and Modular Design**.

---

## 📌 Features

* ➕ Add new student records
* 📋 View all students
* 🔍 Search student by ID
* ✏️ Update student information
* 🗑️ Delete student records
* 📊 Sort students by marks
* 🔢 Count total students
* 💾 Save student records to a file
* 📂 Load student records automatically when the application starts
* ⚠️ Exception handling for invalid input and missing students
* ✅ Input validation for age and marks
* 🧩 Modular project structure using multiple Java packages

---

## 🛠️ Technologies Used

* **Java**
* **Object-Oriented Programming (OOP)**
* **Collections Framework**
* **File Handling**
* **Exception Handling**
* **Java I/O**
* **VS Code**
* **Git & GitHub**

---

## 🧠 Java Concepts Demonstrated

### 1. Object-Oriented Programming

The project uses several important OOP concepts:

* Encapsulation
* Classes and Objects
* Constructors
* Getters and Setters
* Method Overriding
* Abstraction through modular class design

### 2. Collections Framework

`ArrayList<Student>` is used to store and manage student records dynamically.

```java
private ArrayList<Student> students;
```

### 3. CRUD Operations

The application implements:

| Operation | Function             |
| --------- | -------------------- |
| Create    | Add Student          |
| Read      | View/Search Students |
| Update    | Modify Student       |
| Delete    | Remove Student       |

### 4. File Handling

Student records are stored in:

```text
data/students.txt
```

The application uses:

* `FileReader`
* `FileWriter`
* `BufferedReader`
* `BufferedWriter`

This provides basic **data persistence**.

### 5. Exception Handling

The project handles:

* Invalid integer input
* Invalid decimal input
* Missing student records
* File-related errors
* Invalid marks
* Invalid age

A custom exception is also implemented:

```java
StudentNotFoundException
```

---

## 📂 Project Structure

```text
StudentManagementSystem/
│
├── src/
│   ├── Main.java
│   │
│   ├── model/
│   │   └── Student.java
│   │
│   ├── service/
│   │   └── StudentService.java
│   │
│   ├── exception/
│   │   └── StudentNotFoundException.java
│   │
│   └── util/
│       └── FileHandler.java
│
├── data/
│   └── students.txt
│
├── out/
│
└── README.md
```

---

## ⚙️ How the Application Works

```text
                ┌──────────────────────┐
                │       Main.java      │
                │   User Interaction   │
                └──────────┬───────────┘
                           │
                           ▼
                ┌──────────────────────┐
                │   StudentService     │
                │ Business Operations  │
                └──────────┬───────────┘
                           │
                           ▼
                ┌──────────────────────┐
                │      Student         │
                │   Student Objects    │
                └──────────┬───────────┘
                           │
                           ▼
                ┌──────────────────────┐
                │    FileHandler       │
                │  File Persistence    │
                └──────────┬───────────┘
                           │
                           ▼
                ┌──────────────────────┐
                │  students.txt        │
                │    Data Storage      │
                └──────────────────────┘
```

---

# 💻 Requirements

Before running the project, make sure you have:

* Java JDK 8 or higher
* VS Code
* Java Extension Pack for VS Code
* Git (optional, for GitHub)

Check your Java installation:

```bash
java -version
```

Check the Java compiler:

```bash
javac -version
```

---

# ▶️ How to Run

## 1. Clone the Repository

```bash
git clone https://github.com/your-username/StudentManagementSystem.git
```

Move into the project directory:

```bash
cd StudentManagementSystem
```

---

## 2. Compile the Project

Open the VS Code terminal from the project root and run:

```bash
javac -d out src/Main.java src/model/Student.java src/service/StudentService.java src/exception/StudentNotFoundException.java src/util/FileHandler.java
```

---

## 3. Run the Application

```bash
java -cp out Main
```

---

# 🖥️ Application Menu

When the application starts, the following menu is displayed:

```text
==============================================
       STUDENT MANAGEMENT SYSTEM
==============================================

--------------- MENU ----------------
1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Sort Students by Marks
7. Count Students
8. Exit
-------------------------------------
Enter your choice:
```

---

# 📝 Sample Usage

### Add Student

```text
Enter your choice: 1

---------- ADD STUDENT ----------
Enter Student ID: 101
Enter Name: Anjali
Enter Age: 21
Enter Course: Java
Enter Marks: 87.5

Student added successfully.
```

### View Students

```text
Enter your choice: 2

---------------- STUDENT RECORDS ----------------
ID: 101   | Name: Anjali               | Age: 21  | Course: Java            | Marks: 87.50
--------------------------------------------------
```

### Search Student

```text
Enter your choice: 3

---------- SEARCH STUDENT ----------
Enter Student ID: 101

Student Found:
ID: 101   | Name: Anjali               | Age: 21  | Course: Java            | Marks: 87.50
```

### Update Student

```text
Enter your choice: 4

---------- UPDATE STUDENT ----------
Enter Student ID: 101
Enter New Name: Anjali Kumar
Enter New Age: 22
Enter New Course: Advanced Java
Enter New Marks: 92

Student updated successfully.
```

### Delete Student

```text
Enter your choice: 5

---------- DELETE STUDENT ----------
Enter Student ID: 101

Student deleted successfully.
```

---

# 💾 Data Persistence

Student information is automatically stored in:

```text
data/students.txt
```

Example:

```text
101,Anjali,21,Java,87.5
102,Ravi,22,Python,91.0
103,Sita,21,SQL,82.5
```

When the application starts, the stored records are automatically loaded into the `ArrayList`.

Therefore, the data remains available even after the program is closed.

---

# 🔐 Input Validation

The application validates user input.

### Age

```text
Age must be greater than 0.
```

### Marks

Marks must be between:

```text
0 - 100
```

### Empty Input

Student name and course cannot be empty.

### Invalid Number

If the user enters:

```text
Enter Age: abc
```

the application asks for a valid integer instead of terminating.

---

# 📚 Key Classes

## `Student`

Responsible for representing a student object.

Contains:

* Student ID
* Name
* Age
* Course
* Marks

---

## `StudentService`

Contains the main business logic.

Responsible for:

* Adding students
* Searching students
* Updating students
* Deleting students
* Sorting students
* Displaying students

---

## `FileHandler`

Responsible for file persistence.

It provides:

```java
saveStudents()
```

and

```java
loadStudents()
```

---

## `StudentNotFoundException`

Custom exception used when a requested student ID does not exist.

---

## `Main`

Acts as the entry point of the application and handles:

* Menu display
* User input
* Calling service methods
* Exception handling

---

# 🎯 Learning Objectives

This project helped demonstrate practical knowledge of:

```text
Core Java
   ↓
OOP
   ↓
Collections Framework
   ↓
Exception Handling
   ↓
File Handling
   ↓
CRUD Operations
   ↓
Modular Programming
   ↓
Data Persistence
```

---

# 🚀 Future Enhancements

The project can be extended with:

* [ ] MySQL database integration
* [ ] JDBC connectivity
* [ ] Login and authentication
* [ ] Student attendance management
* [ ] Grade calculation
* [ ] Course management
* [ ] GUI using Java Swing or JavaFX
* [ ] REST API using Spring Boot
* [ ] Search by name or course
* [ ] Export student records to CSV
* [ ] Pagination for large datasets
* [ ] Unit testing using JUnit

---

# 📈 Possible Future Version

### Version 1.0

Current console-based application:

```text
Java + OOP + ArrayList + File Handling
```

### Version 2.0

Database-based application:

```text
Java + OOP + JDBC + MySQL
```

### Version 3.0

Web-based application:

```text
Java + Spring Boot + MySQL + REST API
```

This provides a clear path for improving the project from a beginner-level Core Java application into a more advanced Java backend project.

---

# 👩‍💻 Author

**Latha Anjali**

B.Tech Computer Science Engineering

---

# ⭐ If You Like This Project

If you find this project useful for learning Java, consider giving the repository a ⭐ on GitHub.

---

## 📄 License

This project is created for **educational and portfolio purposes**.

# StudentManagementSystem
A console-based Student Management System built with Java, demonstrating OOP, Collections Framework, CRUD operations, exception handling, and file-based data persistence.
