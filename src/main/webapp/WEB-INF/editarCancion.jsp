<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Agregar Cancion</title>
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body>
     <nav>
        <a href="/canciones">Volver</a>    
    </nav>
        <h1>Agregar Canción:</h1>
        <form:form action="/canciones/procesa/editar" method="POST" modelAttribute="cancion">
            <input type="hidden" name="_method" value="PUT"/>
            
            <form:label path="titulo">Título:</form:label>
            <form:input type="text" path="titulo"/>
            <form:errors path="titulo"/>

            <form:label path="artista">Artista:</form:label>
            <form:input type="text" path="artista"/>
            <form:errors path="artista"/>

            <form:label path="album">Album:</form:label>
            <form:input type="text" path="album"/>
            <form:errors path="album"/>

            <form:label path="genero">Género:</form:label>
            <form:input type="text" path="genero"/>
            <form:errors path="genero"/>
            
            <form:label path="idioma">Idioma:</form:label>
            <form:input type="text" path="idioma"/>
            <form:errors path="idioma"/>

            <input type="hidden" name="id" value="${cancion.id}"/>

            <input type="submit" value="Editar"/>
        </form:form> 
    </body>
</html>