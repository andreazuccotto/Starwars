<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">

<title>Homepage</title>
</head>
<body class="bg-secondary">

	<jsp:include page="header.jsp" />

	<main>
	<div class="container mt-5">

		<h2 class="text-light">Impostazioni</h2>

		<div class="table-responsive bg-light">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Username</th>
						<th scope="col">Email</th>
						<th scope="col">Tipo Utente</th>
						<th scope="col">Registrazione</th>
						<th scope="col">Ultimo Accesso</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${sessionScope.user.username}</td>
						<td>${sessionScope.user.email}</td>
						<td><c:choose>
								<c:when test="${sessionScope.user.tipoUtente == 0}">Admin</c:when>
								<c:otherwise>User</c:otherwise>
							</c:choose></td>
						<td><fmt:formatDate type="both" dateStyle="short" timeStyle="medium"
								value="${sessionScope.user.dataRegistrazione}" /></td>
						<td><fmt:formatDate type="both" dateStyle="short" timeStyle="medium"
								value="${sessionScope.user.dataUltimoAccesso}" /></td>
					</tr>
				</tbody>
			</table>
		</div>


		<div class="accordion" id="accordionExample">
			<div class="card">
				<div class="card-header" id="headingOne">
					<h2 class="mb-0">
						<button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true"
							aria-controls="collapseOne">Cambia password</button>
					</h2>
				</div>

				<div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
					<div class="card-body">
						<form class="form-inline" action="ChangePasswordServlet" method="post">
							<div class="form-group mb-2">
								<label for="inputCurPassword">Password corrente</label>
								<input id="inputCurPassword" name="oldPassword" type="password" class="form-control" required>
							</div>
							<div class="form-group mb-2">
								<label for="inputNewPassword">Nuova password</label>
								<input id="inputNewPassword" name="newPassword" type="password" class="form-control" required>
							</div>
							<div class="form-group mb-2">
								<label for="inputConfirmPassword">Conferma nuova password</label>
								<input id="inputConfirmPassword" name="confirmPassword" type="password" class="form-control" required>
							</div>
							<button type="submit" class="btn btn-primary mb-2">Modifica</button>
						</form>
						<c:if test="${not empty infoMessage}">
							<div class="alert alert-success" role="alert">${infoMessage}</div>
						</c:if>
						<c:if test="${not empty errorMessage}">
							<div class="alert alert-danger" role="alert">${errorMessage}</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>