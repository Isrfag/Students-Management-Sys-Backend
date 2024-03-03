# Aplicación de gestión de alumnos con Springboot
Aplicación backend construída usando Java y Springboot que muestra los datos provenientes de una base de datos local MySQL. La API será consumida por un mi propio
frontend creado usando React.js
El repositorio del frontend está alojado aquí https://github.com/Isrfag/Students-Management-Sys-Frontend

## Tecnología y dependencias usadas:
1. Java 17 junto Springboot 3.2.3
2. Lombok
3. MySQL connector
4. Spring web
5. Model mapper

## Características de la aplicación.
- Recuperación de todos los alumnos alojados en la base de datos a través del primer endpoint GET
- Recuperación de un solo alumno por su Id a través del segundo(usa el id como pathvariable) enpoint GET
- Creación de nuevos alumnos en la base datos a través del endpoint POST
- Edición de cualquier alumnos a través del endpoint PUT(usando la id para ver si existe en la base de datos)
- Eliminación de alumnos(si existen en la base de datos)

### Actividad realizada por Israel Fernandez Agudo



## -- English version:


# Frontend Students Management React App
Backend API built using Java with Springboot framework that shows data from a local MySQL database.The Api will be consumed by my own React.js frontend.
Frontend repository can be found here https://github.com/Isrfag/Students-Management-Sys-Frontend

## Tech and dependencies used:
1. Java 17 alongside Springboot 3.2.3
2. Lombok
3. MySQL connector
4. Spring web
5. Model mapper

## App Features:
- Get information from all students hosted in the database through the fist GET endpoint.
- Get data from a single student in the database by its id, through the second GET endpoint(id is a pathvariable)
- Creation of new students through the POST enpoint.
- Update any student through the PUT endpoint using the id to checks if the student exists into the database.
- Delete any student if exist in database.

### Activity made by Israel Fernandez Agudo