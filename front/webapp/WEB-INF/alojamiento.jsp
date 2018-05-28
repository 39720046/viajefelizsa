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
<title>Viaje Feliz | Información del Alojamiento</title>
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
		<h1>Datos del Alojamiento</h1>
		<table class="table">
		  <tbody>
		    <tr>
		      <td>Nombre:</td>
		      <td>${alojamiento.getNombre()}</td>
		    </tr>
		    <tr>
		      <td>Tipo de alojamiento:</td>
		      <td>${alojamiento.getTipo()}</td>
		    </tr>
		    <tr>
		      <td>Cantidad de personas: </td>
		      <td>${alojamiento.getCantidadPersonas()}</td>
		    </tr>
		    <tr>
		      <td>Número de habitaciones: </td>
		      <td>${alojamiento.getCantidadHabitaciones()}</td>
		    </tr>
		    <tr>
		      <td>Número de baños: </td>
		      <td>${alojamiento.getCantidadBanos()}</td>
		    </tr>
		    <tr>
		      <td>Calefacción: </td>
		      <td>${alojamiento.getCalefaccion()}</td>
		    </tr>
		    <tr>
		      <td>Aire acondicionado: </td>
		      <td>${alojamiento.getAireAcondicionado()}</td>
		    </tr>
		    <tr>
		      <td>Mascotas: </td>
		      <td>${alojamiento.getMascotas()}</td>
		    </tr>
		    <tr>
		      <td>Dirección: </td>
		      <td>${alojamiento.getDireccion()}</td>
		    </tr>
		    <tr>
		      <td>Ciudad: </td>
		      <td>${alojamiento.getCiudad()}</td>
		    </tr>
		    <tr>
		      <td>Barrio: </td>
		      <td>${alojamiento.getBarrio()}</td>
		    </tr>
		    <tr>
		      <td>Descripción: </td>
		      <td>${alojamiento.getDescripcion()}</td>
		    </tr>
		    <tr>
		      <td>Precio: </td>
		      <td>${alojamiento.getPrecio()}</td>
		    </tr>
		  </tbody>
		</table>
		<a href="${alojamiento.getId()}/reservacion">Reservar</a> <br><br><br>
	</div>
</body>
</html>