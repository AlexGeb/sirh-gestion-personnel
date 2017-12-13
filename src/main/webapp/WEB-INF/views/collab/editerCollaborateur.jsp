<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../header.jsp"%>
<body>
	<%@include file="../navbar.jsp"%>
	<div class="container">
		<h1>Nouveau collaborateur</h1>
		<form method="post">
			<div class="form-group">
				<label for="nom">Nom</label> <input name="nom" type="text" class="form-control"
					id="nom" aria-describedby="nom" placeholder="Nom">
			</div>
			<div class="form-group">
				<label for="prenom">Prénom</label> <input name="prenom" type="text"
					class="form-control" id="prenom" aria-describedby="prenom"
					placeholder="Prénom">
			</div>
			<div class="form-group">
				<label for="birth">Date de naissance</label> <input name="date_naissance" type="date"
					class="form-control" id="birth" placeholder="Date de naissance">
			</div>
			<div class="form-group">
				<label for="adress">Adresse</label> <input name="adresse" type="text"
					class="form-control" id="adress" placeholder="Adresse">
			</div>
			<div class="form-group">
				<label for="num_secu">Numéro de sécurité sociale</label> <input name="num_secu_sociale" type="text"
					class="form-control" id="num_secu" placeholder="Numéro de sécurité sociale">
			</div>
			<button type="submit" class="btn btn-primary">Créer</button>
			<!-- http://localhost:10080/sgp/collaborateurs/editer?nom=&prenom=&date_naissance=&adresse=&num_secu_sociale= -->
		</form>
	</div>
</body>
</html>