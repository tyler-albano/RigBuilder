# RigBuilder
Android app for comparing PC part prices and building custom rigs.

## Project Description
RigBuilder is an Android mobile application designed to help users compare computer components and plan custom PC builds in one centralized platform. The app aims to simplify the process of building a computer by organizing product information, supporting comparison, and enabling future build planning features.

At the current stage, RigBuilder is a working prototype that demonstrates a core feature: displaying a list of PC parts using a modern Android UI.

---

## Problem Being Addressed
Building a PC requires comparing prices across multiple websites and ensuring compatibility between parts. This process is time-consuming and confusing.

RigBuilder addresses this problem by providing:
- A centralized view of PC components
- Organized part information
- A foundation for future comparison and build tools

---

## Platform
- Android (Primary platform)
- Developed using Android Studio
- Programming Language: Kotlin

---

## Front-End and Back-End Support

### Front-End
- Android UI built with XML and Kotlin
- RecyclerView used to display a dynamic, scrollable list of PC parts
- Simple and user-friendly interface with structured item layouts
- Designed to support future navigation and additional screens

### Back-End
- Currently uses **local mock data** for development
- Data structured using a Kotlin data class (`PCPart`)
- Data managed through a mock provider (`MockPartsData`)

> Note: Firebase and API integration are planned for future implementation.

---

## Functionality

### Current Functionality
- Display a list of PC parts
- Show part details (name, category, brand, and price)
- Scrollable list using RecyclerView

### Planned Functionality
- Search and filter PC parts
- Compare prices across retailers
- Product detail screen
- Build planner for custom PCs
- Compatibility checker
- Budget tracking
- User profile and saved builds

---

## Design (Wireframes)
Wireframes illustrate the layout of key screens including:
- Home screen
- Product listing screen
- Product detail screen
- Build planner screen
- User profile screen

Current implementation reflects the **Product Listing screen**.

![Wireframes](docs/wireframes.png)

---

## Technologies Used

### Current Technologies
- Android Studio
- Kotlin
- XML layouts
- RecyclerView
- Android SDK

### Planned Technologies
- Firebase (Authentication, Firestore)
- REST APIs / JSON
