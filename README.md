# Mostrar Canciones

## Descripción

Aplicación web desarrollada en Spring Boot que permite visualizar un catálogo de canciones almacenadas en una base de datos MySQL. Los usuarios pueden consultar la lista completa de canciones y acceder a información detallada de cada una, incluyendo artista, álbum, género e idioma.

## Objetivos

- Implementar el patrón arquitectónico MVC (Model-View-Controller) completo en Spring Boot
- Establecer conexión y comunicación con una base de datos MySQL
- Crear y gestionar entidades JPA con anotaciones de persistencia
- Desarrollar la capa de repositorio utilizando Spring Data JPA
- Implementar la capa de servicio para lógica de negocio
- Construir controladores que manejen peticiones HTTP GET con parámetros dinámicos
- Renderizar vistas JSP con datos provenientes de la base de datos

## Puntos Clave

### Arquitectura en Capas
La aplicación implementa una separación clara de responsabilidades:
- **Capa de Modelo**: Entidades JPA que representan la estructura de datos
- **Capa de Repositorio**: Interfaces que extienden CrudRepository para acceso a datos
- **Capa de Servicio**: Lógica de negocio y coordinación entre repositorio y controlador
- **Capa de Controlador**: Manejo de peticiones HTTP y enrutamiento
- **Capa de Vista**: JSPs que presentan la información al usuario

### Persistencia de Datos
A diferencia de proyectos anteriores que usaban HashMap en memoria, esta aplicación:
- Conecta con una base de datos real (MySQL)
- Los datos persisten incluso después de reiniciar la aplicación
- Utiliza JPA/Hibernate para mapeo objeto-relacional
- Gestiona automáticamente timestamps de creación y actualización

### Inyección de Dependencias
Uso intensivo de `@Autowired` para:
- Inyectar repositorios en servicios
- Inyectar servicios en controladores
- Aprovechar el contenedor IoC de Spring

### Enrutamiento Dinámico
Implementación de rutas con variables de path usando `@PathVariable` para acceder a recursos específicos por ID.

## Configuración Inicial

### Base de Datos
Antes de ejecutar la aplicación, es necesario crear la base de datos en MySQL:
```sql
CREATE DATABASE canciones_db;
```

### Datos de Prueba
Para propósitos de demostración y testing, se insertaron las siguientes canciones iniciales:
```sql
INSERT INTO canciones 
(titulo, artista, album, genero, idioma, fecha_de_creacion, fecha_de_actualizacion)
VALUES
('Bohemian Rhapsody', 'Queen', 'A Night at the Opera', 'Rock', 'Inglés', '2025-11-23', '2025-11-23'),
('Shape of You', 'Ed Sheeran', 'Divide', 'Pop', 'Inglés', '2025-11-23', '2025-11-23'),
('Clandestino', 'Manu Chao', 'Clandestino', 'Alternativo', 'Español', '2025-11-23', '2025-11-23'),
('Vivir Mi Vida', 'Marc Anthony', '3.0', 'Salsa', 'Español', '2025-11-23', '2025-11-23');
```

## Extensión: Agregar Canciones

### Funcionalidad Agregada
Se implementó la capacidad de crear nuevas canciones mediante un formulario web con:
- **Validaciones del lado del servidor**: Campos con longitud mínima requerida usando `@Size`
- **Binding de formularios**: Uso de Spring Form Tags con `modelAttribute` para enlazar objetos
- **Manejo de errores**: Visualización de mensajes de validación específicos por campo con `<form:errors>`
- **Persistencia POST**: Método POST para enviar datos y guardarlos en la base de datos

## Extensión: Actualizar Canciones

### Funcionalidad Agregada
Se implementó la capacidad de editar canciones existentes mediante un formulario precargado con:
- **Formulario prellenado**: Los campos se cargan automáticamente con los datos actuales de la canción
- **Validaciones en edición**: Mismas validaciones que en creación para mantener integridad
- **Actualización mediante PUT**: Uso de método HTTP PUT (simulado con POST) para actualizar registros

