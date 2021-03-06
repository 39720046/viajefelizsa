<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Viaje Feliz | Alojamientos Disponibles</title>
</head>
<body>

	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">VIAJE FELIZ S.A.</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="/front/alojamientos/buscar">Buscar</a></li>
	      <li><a href="/front/alojamientos">Alojamientos</a></li>
	      <li><a href="/front/mis-reservaciones">Mis reservaciones</a></li>
	      <li><a href="/front/logout">Cerrar Sesión</a></li>
	    </ul>
	  </div>
	</nav>

	<div class="container">
		<h2>Listado de Alojamientos</h2>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Nombre del Alojamiento</th>
		      <th scope="col">Ver</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${list}" var="item">
			    <tr>
			      <td>${item.getNombre()}</td> 
			      <td>
			      	<c:choose>
			      		<c:when test="${value}">
			      			<a href="${item.getId()}">Información</a>
			      		</c:when>
			      		<c:otherwise>
			      			<a href="alojamientos/${item.getId()}">Información</a>
			      		</c:otherwise>
			      	</c:choose>
			      </td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>
	</div>
</body>
</html>