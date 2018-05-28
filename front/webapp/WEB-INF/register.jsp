<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<title>Viaje Feliz | Sign In</title>
</head>
<body>
	<div class="container">
		<form:form class="form-signin" action="/front/registro/registrar-usuario" method="post">
	        <h2 class="form-signin-heading">Regístrate en Viaje Feliz</h2>
	        <label for="name" class="sr-only">Nombre Completo</label>
	        <input type="text" id="inputName" class="form-control" placeholder="Nombre Completo" name= "fullname" required autofocus>
	        <br>
	        <label for="inputUsr" class="sr-only">Nombre de Usuario</label>
	        <input type="text" id="inputUsr" class="form-control" placeholder="Nombre de usuario" name="username" required autofocus>
	        <br>
	        <label for="inputPassword" class="sr-only">Contraseña</label>
	        <input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" name="password" required>
	        <br>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Registrarme</button>
	      </form:form>
	      <a href="/front/">Iniciar Sesión</a>
	</div>
</body>
</html>