<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Agregar Cancion</title>
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body>
     <nav>
        <a href="/artistas">Artistas</a>  
        <a href="/canciones">Canciones</a>  
    </nav>
        <h1>Agregar Canción:</h1>
        <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
            <form:label path="titulo">Título:</form:label>
            <form:input type="text" path="titulo"/>
            <form:errors path="titulo"/>

            <form:label path="artista">Artista:</form:label>
            <form:select path="artista.id">
                <form:options items="${listaArtistas}" itemValue="id" itemLabel="nombre"/>
            </form:select>

            <form:label path="album">Album:</form:label>
            <form:input type="text" path="album"/>
            <form:errors path="album"/>

            <form:label path="genero">Género:</form:label>
            <form:input type="text" path="genero"/>
            <form:errors path="genero"/>
            
            <form:label path="idioma">Idioma:</form:label>
            <form:input type="text" path="idioma"/>
            <form:errors path="idioma"/>

            <input type="submit" value="Agregar"/>
        </form:form> 
    </body>
</html>