<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Viaje Feliz | Reservación</title>
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
		<h2>Reservar Alojamiento | Diligencie sus datos</h2><br>
		<form:form action="/front/guardar" method="post">
		  <div class="form-group row">
		    <label for="name" class="col-sm-2 col-form-label">Nombre Completo: </label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputName" name="nombre">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="identification" class="col-sm-2 col-form-label">Número de identificación:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputIdentification" name="identificacion">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="address" class="col-sm-2 col-form-label">Dirección de residencia:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputAddress" name="direccion">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="telephone" class="col-sm-2 col-form-label">Teléfono:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputTelephone" name="telefono">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="cellphone" class="col-sm-2 col-form-label">Celular:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputCellphone" name="celular">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="numberCard" class="col-sm-2 col-form-label">Número de la tarjeta:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputNumberCard" name="numTarjeta">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="dateExpiration" class="col-sm-2 col-form-label">Fecha de expiración:</label>
		    <div class="col-sm-10">
		      <input type="date" class="form-control" id="inputDateExpiration" name="fechaExp">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="nameCard" class="col-sm-2 col-form-label">Nombre como aparece en la tarjeta:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputNameCard" name="nombreTarj">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="total" class="col-sm-2 col-form-label">Precio total:</label>
		    <div class="col-sm-10">
		      <input type="text" readonly="readonly" class="form-control" id="inputTotal" name="valor" value="${valor}">
		    </div>
		  </div>
		  <button type="submit" class="btn btn-primary mb-2">Confirmar Reserva</button>
		</form:form>
	</div>
</body>
</html>