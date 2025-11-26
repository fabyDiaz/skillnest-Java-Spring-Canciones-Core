<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
        <form:form action="/canciones/procesa/editar" method="POST" modelAttribute="cancion">
            <input type="hidden" name="_method" value="PUT"/>
            
            <form:label path="titulo">Título:</form:label>
            <form:input type="text" path="titulo"/>
            <form:errors path="titulo"/>

           <label for="artista">Artista:</label>
            <select name="artista.id" id="artista">
                <c:forEach items="${listaArtistas}" var="artista">
                    <option value="${artista.id}" 
                        ${cancion.artista.id == artista.id ? 'selected' : ''}>
                        ${artista.nombre}
                    </option>
                </c:forEach>
            </select>

            <form:label path="album">Album:</form:label>
            <form:input type="text" path="album"/>
            <form:errors path="album"/>

            <form:label path="genero">Género:</form:label>
            <form:input type="text" path="genero"/>
            <form:errors path="genero"/>
            
            <form:label path="idioma">Idioma:</form:label>
            <form:input type="text" path="idioma"/>
            <form:errors path="idioma"/>

            <input type="hidden" name="fechaDeCreacion" value="${cancion.fechaDeCreacion}"/>

            <input type="hidden" name="id" value="${cancion.id}"/>

            <input type="submit" value="Editar"/>
        </form:form> 
    </body>
</html>