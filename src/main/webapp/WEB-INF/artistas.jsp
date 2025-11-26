<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Videojuegos</title>
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body>
    <nav>
        <a href="/artistas">Artistas</a>  
        <a href="/canciones">Canciones</a>   
        <a href="/canciones/formulario/agregar">Agregar Canción</a>  
        <a href="/artistas/formulario/agregar">Agregar Artista</a>    
    </nav>
        <div class="content">
	        <div class="contenedorCanciones">
	            <h1>Lista de Artistas</h1>
	            <ul class="listaDeCanciones">
		            <c:forEach var="artista" items="${listaArtistas}">
			            <li>
                            <a href="/artistas/detalle/${artista.id}">
                                <h3>${artista.nombre}</h3>
                            </a>
			            </li>
		            </c:forEach>
	            </ul>
	        </div>
        </div>
    </body>
</html>