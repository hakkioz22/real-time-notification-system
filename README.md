# Real-Time Notification System

This is a Real-Time Notification System built with Java Spring Boot using a modular monolithic architecture. The system is designed to handle various types of notifications (e.g., email, SMS, push notifications) and utilizes an event-driven architecture to manage and process these notifications efficiently.

## Features

- **Modular Monolithic Architecture**: The application is organized into modules to maintain a clean and maintainable codebase.
- **Event-Driven Architecture**: Notifications are processed using events, allowing for a decoupled and scalable system.
- **Multiple Notification Channels**: Currently supports email notifications, with the possibility to extend to other notifications.
- **REST API**: Provides a RESTful API for creating and retrieving notifications.
- **MongoDB Integration**: Notifications are stored in a MongoDB database for persistence.

## Getting Started

### Prerequisites

- **Java 17**
- **Maven**
- **Docker** (for running MongoDB)
- **MongoDB** (or use a local/remote MongoDB instance)

### Installation

1. **Clone the repository:**

   git clone https://github.com/your-username/real-time-notification-system.git
   cd real-time-notification-system

2. Install mongodb

   docker run --name mongodb -d -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=username -e MONGO_INITDB_ROOT_PASSWORD=password mongo

3. Configure application.properties file with new configs

4. Run the project

