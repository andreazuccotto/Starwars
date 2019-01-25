<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<link href="../css/signin.css" rel="stylesheet">
<title>Login</title>
</head>
<body>
	<div class="container text-center">
		<form class="form-signin" action="LoginServlet" method="post">
			<h1 class="h3 mb-3 font-weight-normal">Login</h1>
			<label for="inputUsername" class="sr-only">Nome utente</label>
			<input name="username" type="text" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Accedi</button>
		</form>
		<a class="btn btn-link" href="recuperaPassword.html">Password dimenticata?</a>
		<a class="btn btn-link" href="registrati.html">Registrati</a>
		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
	</div>
</body>
</html>