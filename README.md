# Task-Manager

- TaskManager is a simple, console-based Java application designed to help users efficiently manage their daily tasks. With features to add, view, and track tasks, it provides a simple way to stay organized and boost productivity.

## Features

- User Registration and Login
- Add, View, Update, and Delete personal tasks
- MySQL database integration using JDBC
- Modular code with `model`, `dao`, `controller`, and `view` packages

## Folder Structure

```
  TaskManagerApp/src
  ├── model/
  │   ├── User.java
  │   └── Task.java
  ├── dao/
  │   ├── UserDAO.java
  │   └── TaskDAO.java
  ├── view/
  │   ├── AuthView.java
  │   └── TaskView.java
  ├── controller/
  │   ├── AuthController.java
  │   └── TaskController.java
  ├── util/
  │   ├── DBConnection.java
  │   └── PasswordUtil.java
  ├── Main.java
  └── schema.sql
```

## Future Simple Updates

- Add a priority field (LOW, MEDIUM, HIGH) in the Task model and database.
-  Secure password storage using SHA-256 hashing
-  Add functionality to export tasks to a .txt or .csv file.
