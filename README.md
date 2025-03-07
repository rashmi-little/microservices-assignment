# Microservices Architecture with Spring Cloud

This project demonstrates a microservices architecture using Spring Cloud, where multiple services interact dynamically through service discovery, centralized configuration, and fault tolerance.

## Overview

The following components are part of this architecture:

1. **Config Service (Spring Cloud Config Server)**
2. **Eureka Server (Service Registry)**
3. **Employee Management Service (Existing Service)**
4. **Performance Review Service**
5. **API Gateway (Spring Cloud Gateway)**

Each service communicates with each other and is registered with Eureka for dynamic discovery. The configuration for the services is centralized and stored in a GitHub repository. Fault tolerance and rate limiting are implemented using Spring Cloud's features.

## Project Structure

- **Config Service:** Centralized configuration service running on port `8888` that serves configuration to the microservices.
- **Eureka Server:** Service registry running on port `8761` for dynamically registering and discovering services.
- **Employee Management Service:** Existing service that registers with Eureka Server and fetches configuration from the Config Service.
- **Performance Review Service:** Manages employee performance reviews, stores ratings and feedback, uses Feign Client to fetch employee data, and implements Circuit Breaker for fault tolerance.
- **API Gateway:** Acts as a centralized entry point for routing requests, implements rate limiting using Resilience4j, and registers with Eureka Server.

## Prerequisites

Before running the application, ensure that the following tools are installed:

- JDK 11 or later
- Maven
- Docker (optional, for containerization)
- Git

## Setting Up the Services

### 1. Config Service

The Config Service acts as a centralized configuration provider for the microservices. The configuration is stored in a **GitHub repository**.

**Steps to set up:**
- Clone the [GitHub repository](https://github.com/rashmi-little/microservices-config-repo) where configuration files are stored.
- Set up the **Config Service** Spring Boot application with the Spring Cloud Config Server dependency.
- Ensure it runs on port `8888`.
- The configuration is fetched dynamically by other services using this server.

### 2. Eureka Server

Eureka Server acts as the service registry for all microservices.

**Steps to set up:**
- Create a Spring Boot project with the Eureka Server dependency.
- Enable Eureka Server with the `@EnableEurekaServer` annotation.
- Run the Eureka Server on port `8761`.
- All other services will register with Eureka for service discovery.

### 3. Employee Management Service

The Employee Management Service manages employee data and is already an existing service in your project. It registers with Eureka Server and fetches configuration dynamically from the Config Service.

### 4. Performance Review Service

The Performance Review Service handles employee ratings and feedback.

**Steps to set up:**
- Create a Spring Boot application for the Performance Review Service.
- Store employee ratings and feedback in a database (either a new database or the same database used by the Employee Management Service).
- Implement a Feign Client to fetch employee details from the Employee Management Service.
- Use a **Circuit Breaker** for fault tolerance in case the Employee Management Service is down or not responding.
- Register the service with Eureka Server.

### 5. API Gateway

The API Gateway serves as the centralized entry point for routing requests.

**Steps to set up:**
- Create a Spring Boot application for the API Gateway.
- Use **Spring Cloud Gateway** for routing requests to appropriate microservices.
- Implement **Rate Limiting** using **Resilience4j** to limit the number of requests to the services.
- Register the API Gateway with Eureka Server.

## Running the Project

1. **Start the Config Service** (on port `8888`).
2. **Start the Eureka Server** (on port `8761`).
3. **Start the Employee Management Service** and **Performance Review Service** (both will register with Eureka Server).
4. **Start the API Gateway** to act as the entry point.

## Accessing the Services

- Eureka Server UI: [http://localhost:8761](http://localhost:8761)
- Config Service: [http://localhost:8888](http://localhost:8888)
- API Gateway: [http://localhost:8765](http://localhost:8080) (Routes to different services)

## Features

- **Service Discovery:** Using Eureka Server to dynamically register and discover services.
- **Centralized Configuration:** Using Spring Cloud Config Server to provide configurations from a GitHub repository.
- **Circuit Breaker:** Implemented using Spring Cloud's resilience features to ensure fault tolerance in the Performance Review Service.
- **Rate Limiting:** Implemented using Resilience4j to control the number of requests per minute to the API Gateway.
- **Feign Client Integration:** Used for seamless communication between the Performance Review Service and the Employee Management Service.

## Technologies Used

- **Spring Boot**
- **Spring Cloud Config**
- **Spring Cloud Eureka**
- **Spring Cloud Gateway**
- **Spring Cloud Circuit Breaker**
- **Feign Client**
- **Resilience4j**
- **GitHub for Configuration Storage**
- **MySql Database (or your preferred DB)**

## Future Enhancements

- Implement **OAuth2 Authentication** for secure access to the services.
- Add **Service Monitoring** with Spring Boot Actuator and Prometheus.
- Expand fault tolerance features with **Hystrix** or **Resilience4j**.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
