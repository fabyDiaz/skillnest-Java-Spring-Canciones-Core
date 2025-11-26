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
        <a href="/artistas">Artistas</a>  
        <a href="/canciones">Canciones</a>     
    </nav>

    <div class="detalle-canciones">
            <h1>${cancion.titulo}</h1>
            <ul>
                <li><strong>Artista:</strong> ${cancion.artista.nombre}</li>
                <li><strong>Album:</strong> ${cancion.album}</li>
                <li><strong>Género:</strong> ${cancion.genero} </li>
                <li><strong>Idioma:</strong> ${cancion.idioma } </li>
                <li><strong>Fecha de Creación:</strong> ${cancion.fechaDeCreacion} </li>
                <li><strong>Fecha de Actualización:</strong> ${cancion.fechaDeActualizacion} </li>
            </ul>
        <div class="boton">
            <a class="btn" href="/canciones/formulario/editar/${cancion.id}">Editar</a>
            <form class="form-inline" action="/canciones/eliminar/${cancion.id}" method="POST">
                <input type="hidden" name="_method" value="DELETE"/>
                <button class="btn">Eliminar</button>
            </form>
        </div>

    </div>

</body>
</html>
