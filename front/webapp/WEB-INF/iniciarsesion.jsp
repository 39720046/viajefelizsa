<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<title>Viaje Feliz | Log In</title>
</head>
<body>
<br>
	<div class="container">
	  <c:if test="${mensaje}">
	  	<div class="alert alert-danger" role="alert" style="text-align: center">
	  		El nombre de usuario y la contraseña que ingresaste no coinciden con nuestros registros. <br>
	  		Por favor, revisa e inténtalo de nuevo.
	  	</div>
	  </c:if>
      <form:form class="form-signin" action="/front/login" method="post">
        <h2 class="form-signin-heading">Bienvenido a Viaje Feliz</h2>
        <label for="inputUsr" class="sr-only">Nombre de Usuario</label>
        <input type="text" id="inputUsr" class="form-control" placeholder="Nombre de usuario" name="username" autofocus>
        <br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar Sesión</button>
      </form:form>
      <a href="/front/registro">Regístrate</a>

    </div> <!-- /container -->
</body>
</html>