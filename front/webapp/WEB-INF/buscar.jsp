<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<title>Viaje Feliz | Búsqueda</title>
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
		<c:if test="${mensaje}">
		  	<div class="alert alert-warning" role="alert" style="text-align: center">
		  		La fecha inicial es mayor a la fecha final.
		  	</div>
	  	</c:if>
		<form:form action="/front/alojamientos/buscar-alojamientos" method="post">
		  <h2>Buscar Alojamiento</h2><br>
		  <div class="form-group row">
		    <label for="initDate" class="col-sm-2 col-form-label">Fecha inicial:</label>
		    <div class="col-sm-10">
		      <input type="date" class="form-control" id="inputDate" name="fechaInicial">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="endDate" class="col-sm-2 col-form-label">Fecha final:</label>
		    <div class="col-sm-10">
		      <input type="date" class="form-control" id="inputEndDate" name="fechaFinal">
		    </div>
		  </div>
		  <button type="submit" class="btn btn-primary mb-2">Buscar</button>
		</form:form>
	</div>
</body>
</html>