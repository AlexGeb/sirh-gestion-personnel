<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../includes/header.jsp"%>
<body>
	<%@include file="../includes/navbar.jsp"%>
	<div class="container-fluid">
		<h1>Les collaborateurs</h1>

		<div class="row">
			<div class="col-lg-4 align-self-center">
				<p class="text-right">Rechercher un nom ou un prénom commencant
					par :</p>
			</div>
			<div class="col-lg-2">
				<form method="get">
					<div class="form-group">
						<input name="recherche" type=text class="form-control"
							value="${searchValue}" placeholder="Recherche">
					</div>
				</form>
			</div>
			<div class="col-lg-4 offset-lg-2 align-self-center">
				<div class="form-check">
					<label class="form-check-label"> <input
						class="form-check-input" type="checkbox" value="">Voir les
						collaborateurs désactivés
					</label>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<p class="text-right">Filtrer par département :</p>
			</div>
			<div class="col-lg-4">
				<form method="get" class="form-inline">
					<div class="form-group mx-sm-3">
						<select name="departement">
							<option value="all">Tous</option>
							<c:forEach var="dept" items="${departements}">
								<option value="${dept.nom}"
									${dept.nom == selectedDept ? 'selected="selected"' : ''}>${dept.nom}</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Filtrer</button>
				</form>
			</div>
		</div>

		<div class="row">
			<c:forEach var="collab" items="${collaborateurs}">
				<div class="col-auto" style="padding-bottom: 10px;">
					<div class="card" style="max-width: 20rem;">
						<h4 class="card-header">${collab.nom}&nbsp;${collab.prenom}</h4>
						<div class="card-body row">
							<div class="col-3">
								<img class="rounded img-thumbnail"
									src="<%=request.getContextPath()%>/images/${collab.photo}"
									alt="Responsive image">
							</div>
							<div class="col-9">
								<div class="card-text">
									<ul class="list-unstyled">
										<li><small>Fonction : <strong>${collab.intitulePoste}</strong></small></li>
										<li><small>Departement : <strong>${collab.departement.nom}</strong></small></li>
										<li><small>Email : <strong>${collab.emailPro}</strong></small></li>
										<li><small>Telephone : <strong>${collab.phone}</strong></small></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="card-footer text-muted">
							<a href="<c:url value='editer?matricule=${collab.matricule}'/>"
								class="btn btn-primary" role="button">Modifier</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>


	</div>
</body>
</html>