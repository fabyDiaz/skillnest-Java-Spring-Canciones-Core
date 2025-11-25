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
        <a href="/canciones/formulario/agregar">Agregar</a>    
    </nav>
        <div class="content">
	        <div class="contenedorCanciones">
	            <h1>Lista de Canciones</h1>
	            <ul class="listaDeCanciones">
		            <c:forEach var="cancion" items="${listaCanciones}">
			            <li>
                            <a href="/canciones/detalle/${cancion.id}">
                                <h3>${cancion.titulo}</h3>
                            </a>
			            </li>
		            </c:forEach>
	            </ul>
	        </div>
        </div>
    </body>
</html>