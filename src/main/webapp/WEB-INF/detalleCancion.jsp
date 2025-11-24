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
            <h1>${cancion.getTitulo()}</h1>
            <ul>
                <li><strong>Artista:</strong> ${cancion.getArtista()}</li>
                <li><strong>Album:</strong> ${cancion.getAlbum()}</li>
                <li><strong>Género:</strong> ${cancion.getGenero()} </li>
                <li><strong>Idioma:</strong> ${cancion.getIdioma() } </li>
                <li><strong>Fecha de Creación:</strong> ${cancion.getFechaDeCreacion()} </li>
                <li><strong>Fecha de Actualización:</strong> ${cancion.getFechaDeActualizacion()} </li>
            </ul>
    </div>

</body>
</html>
