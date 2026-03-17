# RigBuilder System Diagrams

## 1. App Architecture Overview

User (Mobile App)
        ↓
Frontend (Android UI - Kotlin/XML)
        ↓
Backend Services (Firebase / Cloud)
        ↓
Database (Firestore / Realtime DB)

---

## 2. Data Flow Diagram

User searches for a product
        ↓
App sends request to database/API
        ↓
Data is retrieved (price, specs)
        ↓
Results displayed to user

---

## 3. Build Planner Flow

User selects components
        ↓
App stores selected parts
        ↓
Compatibility check runs
        ↓
Total price is calculated
        ↓
Build is saved to user account
