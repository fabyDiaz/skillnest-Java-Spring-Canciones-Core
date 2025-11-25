<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle Videojuego</title>
     <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <nav>
        <a href="/canciones">Volver</a>    
    </nav>

    <div class="detalle-canciones">
            <h1>${cancion.titulo}</h1>
            <ul>
                <li><strong>Artista:</strong> ${cancion.artista}</li>
                <li><strong>Album:</strong> ${cancion.album}</li>
                <li><strong>Género:</strong> ${cancion.genero} </li>
                <li><strong>Idioma:</strong> ${cancion.idioma } </li>
                <li><strong>Fecha de Creación:</strong> ${cancion.fechaDeCreacion} </li>
                <li><strong>Fecha de Actualización:</strong> ${cancion.fechaDeActualizacion} </li>
            </ul>
        <div class= "boton">
            <a class="btnVolver" href="/canciones/formulario/editar/${cancion.id}">Editar</a>
        <div>
    </div>

</body>
</html>
