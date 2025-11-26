<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle Artista</title>
     <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <nav>
        <a href="/artistas">Artistas</a>  
        <a href="/canciones">Canciones</a>   
    </nav>

    <div class="detalle-canciones">
            <h1>${artista.nombre}</h1>
            <ul>
                <li><strong>Nombre:</strong> ${artista.nombre}</li>
                <li><strong>Apellido:</strong> ${artista.apellido}</li>
                <li><strong>Biografía:</strong> ${artista.biografia} </li>
                <li><strong>Fecha de Creación:</strong> ${artista.fechaCreacion} </li>
                <li><strong>Fecha de Actualización:</strong> ${artista.fechaActualizacion} </li>
            </ul>
        <div class="boton">
            <a class="btn" href="/artista/formulario/editar/${artista.id}">Editar</a>
            <form class="form-inline" action="/artista/eliminar/${artista.id}" method="POST">
                <input type="hidden" name="_method" value="DELETE"/>
                <button class="btn">Eliminar</button>
            </form>
        </div>

    </div>

</body>
</html>
