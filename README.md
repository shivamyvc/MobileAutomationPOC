# 📱 MobileAutomationPOC

A scalable and cross-platform Mobile Automation Framework built using Appium, Java, and TestNG, designed to support both Android and iOS platforms with a single unified codebase.

---

## 🚀 Overview

This project demonstrates a production-ready automation framework architecture focused on:

- Cross-platform execution (Android & iOS)
- Clean and maintainable code structure
- Parallel execution capability
- Industry-standard design patterns

---

## 🏗️ Tech Stack

| Category            | Technology        |
|--------------------|------------------|
| Language           | Java             |
| Automation Tool    | Appium           |
| Test Framework     | TestNG           |
| Build Tool         | Maven            |
| Design Pattern     | Page Object Model (POM) |

---

## ⚙️ Key Features

- Cross-platform support using AppiumDriver
- Driver Factory design pattern for driver initialization
- ThreadLocal driver management (parallel execution ready)
- Explicit wait handling (no hard-coded waits)
- Modular and scalable framework structure
- Supports both local and remote execution

---

## 📂 Project Structure

MobileAutomationPOC
│── base/              # Base test setup and initialization  
│── driver/            # Driver factory and driver management  
│── pages/             # Page Object classes  
│── tests/             # Test classes  
│── utils/             # Utility classes (waits, helpers)  
│── resources/         # Configuration files  

---

## ▶️ Execution Steps

### 1. Clone the Repository
git clone https://github.com/shivamyvc/MobileAutomationPOC.git

### 2. Install Dependencies
mvn clean install

### 3. Run Tests
mvn test

---

## 📱 Platform Support

| Platform | Status |
|----------|--------|
| Android  | Implemented |
| iOS      | Planned |

Note: The framework is designed to support iOS. Locator implementation will be added once an iOS device is available.

---

## 🔮 Future Enhancements

- Extent Reports integration with screenshots
- Logging implementation using Log4j / SLF4J
- Data-driven testing (Excel / JSON)
- iOS locator strategy implementation
- CI/CD integration (Jenkins / GitHub Actions)
- Cloud execution (BrowserStack / LambdaTest)

---

## 💡 Framework Highlights

- Designed with scalability and reusability in mind  
- Supports parallel test execution using ThreadLocal  
- Built using industry best practices  
- Easily extendable for enterprise-level automation  

---

## 👨‍💻 Author

Shivam Yadav  
Automation Test Engineer  
Mumbai, India  

---

## ⭐ Support

If you like this project, give it a star on GitHub and feel free to contribute!
