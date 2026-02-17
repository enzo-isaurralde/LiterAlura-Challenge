<img width="416" height="217" alt="image" src="https://github.com/user-attachments/assets/a8490954-78f7-41c5-8578-9ed62b6ee90b" />


# LiterAlura Challenge 📚

Proyecto desarrollado como parte del **Challenge LiterAlura**, una aplicación backend construida con **Java + Spring Boot** que permite gestionar una biblioteca literaria a través de una API y una interfaz de consola.  

El objetivo es practicar el consumo de APIs externas, persistencia de datos con JPA/Hibernate, y aplicar buenas prácticas de arquitectura en proyectos Java.

---

## 🚀 Tecnologías utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL** (base de datos relacional)
- **Jackson** (serialización/deserialización JSON)
- **Maven** (gestión de dependencias)

---

## 📖 Funcionalidades principales
- Buscar libros por título utilizando la API de [Gutendex](https://gutendex.com/).
- Registrar libros en la base de datos local.
- Listar libros registrados.
- Listar autores registrados.
- Filtrar autores vivos en un determinado año.
- Filtrar libros por idioma.
- Persistencia de datos en PostgreSQL.

---

## ⚙️ Instalación y ejecución

### 1. Clonar el repositorio
```bash
git clone https://github.com/enzo-isaurralde/LiterAlura-Challenge.git
cd LiterAlura-Challenge
```

### 2. Configurar base de datos
Crea una base de datos en PostgreSQL, por ejemplo:
CREATE DATABASE literalura;


En el archivo application.properties (ubicado en src/main/resources), configura tus credenciales:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```


### 🖥️ Uso
La aplicación se ejecuta en consola y ofrece un menú interactivo con las siguientes opciones:

Buscar libro por título en Gutendex y guardarlo en la base de datos.

Listar libros registrados.

Listar autores registrados.

Listar autores vivos en un año específico.

Listar libros por idioma.

Salir.


### 📂 Estructura del proyecto
```
src/
 └── main/
     ├── java/com/literalura/
     │   ├── controller/   # Lógica de interacción con el usuario
     │   ├── model/        # Entidades JPA (Libro, Autor)
     │   ├── repository/   # Interfaces JPA Repository
     │   ├── service/      # Lógica de negocio y consumo de API
     │   └── LiterAluraApplication.java
     └── resources/
         ├── application.properties
         └── data.sql      # (Opcional) Datos iniciales
```
### 👨‍💻 Autor
Enzo Ariel Isaurralde  

<img width="346" height="503" alt="image" src="https://github.com/user-attachments/assets/c69c39e9-001e-47a8-a43e-4037c2fdc09f" />

