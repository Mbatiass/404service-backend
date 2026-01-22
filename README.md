# 404 Service – Backend  
**Servicio no encontrado… hasta ahora.**

Este repositorio contiene el **código fuente del backend** del proyecto **404 Service**, desarrollado en el contexto del **bootcamp de Desarrollo Web Full-Stack Java de Generation Chile**.

El backend está pensado como la capa encargada de la **lógica de negocio, persistencia de datos y exposición de servicios REST**, que serán consumidos por el frontend del sistema.

El proyecto simula un **servicio de E-commerce** donde usuarios pueden **contratar servicios de prestadores verificados**, de forma fácil, rápida y segura.

## 📋 Descripción del Proyecto

El backend de **404 Service** corresponde a una **API REST desarrollada con Java y Spring Boot**, diseñada para gestionar:

- Usuarios (clientes y prestadores)
- Servicios ofrecidos
- Disponibilidad de servicios
- Contrataciones
- Reseñas

Esta aplicación permite centralizar la información y preparar el sistema para su integración con el frontend y futuras funcionalidades.

## 🚀 Características Principales

- API REST desarrollada con **Spring Boot**
- Gestión de entidades principales del sistema
- Conexión a base de datos relacional
- Arquitectura organizada por capas
- Preparación para integración con frontend
- Uso de Maven para gestión de dependencias

## 🛠️ Tecnologías Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA / Hibernate**
- **Maven**
- **MySQL**
- **Git & GitHub**

## 📂 Estructura del Proyecto

```Bash
404service/
├── .idea/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.syndicate._service/
│   │   │           ├── controller/
│   │   │           ├── dto/
│   │   │           ├── exception/
│   │   │           ├── mapper/
│   │   │           ├── model/
│   │   │           ├── repository/
│   │   │           ├── security/
│   │   │           │   ├── config/
│   │   │           │   ├── controller/
│   │   │           │   ├── dto/
│   │   │           │   ├── jwt/
│   │   │           │   ├── model/
│   │   │           │   ├── repository/
│   │   │           │   └── service/
│   │   │           ├── service/
│   │   │           └── Application.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       ├── application.yaml
│   │       ├── application-local.yaml
│   │       ├── application-prod.yaml
│   │       ├── data.sql
│   │       └── schema.sql
│   └── test/
├── target/
├── .env
├── .gitattributes
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
└── pom.xml

```

La estructura sigue el estándar de proyectos **Spring Boot**, separando responsabilidades y facilitando la escalabilidad y el mantenimiento del código.

## 🔧 Instalación y Uso

### 1️⃣ Clonar el repositorio

git clone https://github.com/Mbatiass/404service-backend.git

### 2️⃣ Compilar el proyecto

mvn clean install

### 3️⃣ Ejecutar la aplicación

mvn spring-boot:run

La aplicación se ejecutará por defecto en:

http://localhost:8080

## 🗄️ Base de Datos

El backend está diseñado para trabajar con una **base de datos MySQL**, compartida con el frontend del proyecto (https://github.com/Stotelary/SA-HA1).

La base de datos contempla **seis entidades principales**:

- Usuario  
- Servicio  
- Disponibilidad de servicio  
- Imágenes de servicio  
- Contratación  
- Reseña  

El **modelo entidad–relación** y el **script de creación de tablas** se encuentran documentados en el repositorio del frontend, asegurando coherencia entre ambas capas del sistema.

---

## 🔌 Funcionamiento del Backend

El backend expone **endpoints REST** que permiten:

- Crear y gestionar usuarios  
- Registrar servicios  
- Consultar disponibilidad  
- Registrar contrataciones  
- Asociar reseñas a contrataciones  

Estos endpoints pueden ser probados utilizando herramientas como **Postman** o mediante la integración directa con el **frontend del proyecto**.

---

## 📚 Contenidos Aplicados del Bootcamp

Durante el desarrollo de este proyecto se aplicaron los siguientes contenidos:

- Programación orientada a backend con **Java**
- Desarrollo de **APIs REST**
- Uso de **anotaciones en Spring Boot**
- Persistencia de datos con **JPA / Hibernate**
- Gestión de dependencias con **Maven**
- Control de versiones con **Git**
- Trabajo colaborativo con **GitHub**

---

## ✒️ Autores

**Equipo 6 – “404 Syndicate”**

- Ariel Norambuena  
- Bayron Benavides  
- Camila San Martín  
- Cristian Delgadillo  
- Francesca Carcamo 
- Luis Gonzáles  
- Matías Pérez  

