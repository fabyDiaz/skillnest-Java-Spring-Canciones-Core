<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Agregar Artista</title>
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body>
     <nav>
        <a href="/artistas">Artistas</a>  
        <a href="/canciones">Canciones</a>    
    </nav>
        <h1>Agregar Artista:</h1>
        <form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="artista">
            <form:label path="nombre">Nombre:</form:label>
            <form:input type="text" path="nombre"/>
            <form:errors path="nombre"/>

            <form:label path="apellido">Apellido:</form:label>
            <form:input type="text" path="apellido"/>
            <form:errors path="apellido"/>

            <form:label path="biografia">Biografía:</form:label>
            <form:input type="text" path="biografia"/>
            <form:errors path="biografia"/>

            <input type="submit" value="Agregar"/>
        </form:form> 
    </body>
</html>