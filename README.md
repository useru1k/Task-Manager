# Task-Manager

A simple Java console-based Task Manager that lets users add, view, and manage daily tasks efficiently.

## Features

- User Registration and Login
- Add, View, Update, and Delete personal tasks
- MySQL database integration using JDBC
- Modular code with `model`, `dao`, `controller`, and `view` packages

## 📁 Folder Structure (MVC-based)
```
TaskManagerApp/
│
├── model/
│   ├── User.java
│   └── Task.java
│
├── dao/
│   ├── UserDAO.java
│   └── TaskDAO.java
│
├── view/
│   ├── AuthView.java
│   └── TaskView.java
│
├── controller/
│   ├── AuthController.java
│   └── TaskController.java
│
├── util/
│   ├── DBConnection.java
│   └── PasswordUtil.java
│
├── Main.java
└── schema.sql
```
