# MVI Architecture Demo with Dagger-Hilt, Room, Retrofit & Coroutines

This project demonstrates a modern Android application built using **MVI (Model-View-Intent) architecture**, combined with **Dagger-Hilt for dependency injection**, **Room for local persistence**, and **Retrofit with Kotlin Coroutines & Flow for networking and reactive data handling**.

The goal of this project is to showcase a clean, scalable, and testable architecture suitable for production-grade Android applications.

---

## 🚀 Tech Stack

- **Kotlin**
- **MVI Architecture**
- **Dagger-Hilt (Dependency Injection)**
- **Room Database (Local Storage)**
- **Retrofit (Networking)**
- **Kotlin Coroutines**
- **Kotlin Flow (Reactive Streams)**
- **ViewModel (Jetpack Architecture Components)**
- **Clean Architecture Principles**

---

## 🏗 Architecture Overview

This project follows a **Clean MVI architecture** with a clear separation of concerns:

### Layers

- **UI Layer (View)**
  - Jetpack UI components
  - Observes state from ViewModel
  - Sends user intents

- **ViewModel (Intent Processor)**
  - Receives UI intents
  - Processes business logic via UseCases
  - Emits UI states

- **Domain Layer**
  - Contains business logic
  - UseCases
  - Pure Kotlin (no Android dependencies)

- **Data Layer**
  - Repository implementation
  - Remote data source (Retrofit)
  - Local data source (Room)

---

## 🔄 MVI Flow

      User Action (Intent)
              ↓
      ViewModel Processes Intent
              ↓
      Repository / UseCase Execution
              ↓
      Data Source (Room / Retrofit)
              ↓
      State Updated via Flow
              ↓
      UI Recomposition


---

## 🗂 Project Structure


      com.example.app
      │
      ├── data
      │ ├── local (Room DB, DAO, Entities)
      │ ├── remote (Retrofit APIs)
      │ ├── repository (Repository implementation)
      │
      ├── domain
      │ ├── model
      │ ├── repository (Interfaces)
      │ ├── usecase
      │
      ├── presentation
      │ ├── ui
      │ ├── viewmodel
      │ ├── state / intent
      │
      ├── di
      │ ├── AppModule
      │ ├── DatabaseModule
      │ ├── NetworkModule
      │
      └── MainApplication


---

## 💉 Dependency Injection (Dagger-Hilt)

Dagger-Hilt is used to manage dependencies across the application.

### Benefits:
- Reduces boilerplate code
- Simplifies dependency management
- Improves testability
- Supports modular architecture

---

## 🗄 Local Database (Room)

Room is used for offline caching and persistence.

Features:
- Entity separation from domain models
- DAO for database operations
- Supports Flow for reactive updates

---

## 🌐 Networking (Retrofit)

Retrofit is used for API communication.

Features:
- Coroutine support
- Structured API interfaces
- Clean separation from business logic

---

## 🔄 Reactive Programming (Flow)

Kotlin Flow is used to:
- Emit real-time UI states
- Handle async streams
- Combine local + remote data sources

---

## 📦 Key Features

- Clean MVI architecture implementation
- Offline-first support using Room
- Reactive UI updates with Flow
- Scalable project structure
- Dependency injection with Hilt
- Separation of Domain, Data & Presentation layers

---

## 🧠 Learning Purpose

This project is designed to help developers understand:

- How MVI architecture works in Android
- How to structure scalable Android applications
- How to combine Room, Retrofit, and Flow effectively
- How to implement Clean Architecture with Hilt

---

## 🙏 Credits

Inspired by and thanks to:

- Mitch Tabian  
  GitHub: https://github.com/mitchtabian/Dagger-Hilt-Playerground

---

## 📌 Future Improvements

- Add unit tests for ViewModel & UseCases
- Add UI tests with Espresso
- Implement pagination support
- Add multi-module architecture
- Migrate UI fully to Jetpack Compose

---

## 📄 License

This project is open-source and available for learning purposes.
