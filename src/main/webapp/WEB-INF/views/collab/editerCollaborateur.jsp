<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../header.jsp"%>
<body>
	<%@include file="../navbar.jsp"%>
	<div class="container">
		<div class="row">
			<c:choose>
				<c:when test="${collaborateur!=null}">
					<div class="col-lg-6">
						<h4>${collaborateur.nom}&nbsp;${collaborateur.prenom}</h4>
					</div>
					<div class="col-lg-6">
						<h5>${collaborateur.matricule}</h5>
					</div>
				</c:when>
				<c:otherwise>
					<h2>Nouveau collaborateur</h2>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="row" style="padding-top: 20px;">
			<div class="col-md-4">
				<img class="card-img-top rounded img-thumbnail"
					src="<%=request.getContextPath()%>/images/default-avatar.png">
			</div>
			<div class="col-md-8">
				<form method="post">
					<div id="accordion" role="tablist">
						<!-- IDENTITE -->
						<div class="card">
							<div class="card-header" role="tab" id="headingOne">
								<h5 class="mb-0">
									<a data-toggle="collapse" href="#collapseOne"
										aria-expanded="false" aria-controls="collapseOne">Identité</a>
								</h5>
							</div>
						</div>
						<div id="collapseOne" class="collapse show" role="tabpanel"
							aria-labelledby="headingOne" data-parent="#accordion">
							<div class="card-body">
								<div class="form-group row">
									<label for="nom" class="col-sm-3 col-form-label">Nom</label>
									<div class="col-sm-9">
										<input name="nom" type="text" class="form-control" id="nom"
											placeholder="Nom" value="${collaborateur.nom}"
											<c:if test="${collaborateur!=null}">readonly</c:if>>
									</div>
								</div>
								<div class="form-group row">
									<label for="prenom" class="col-sm-3 col-form-label">Prénom</label>
									<div class="col-sm-9">
										<input name="prenom" type="text" class="form-control"
											id="prenom" placeholder="Prénom"
											value="${collaborateur.prenom}"
											<c:if test="${collaborateur!=null}">readonly</c:if>>
									</div>
								</div>
								<div class="form-group row">
									<label for="birth" class="col-sm-3 col-form-label">Date
										de naissance</label>
									<div class="col-sm-9">
										<input name="date_naissance" type="date" class="form-control"
											id="birth" placeholder="Date de Naissance"
											value="${collaborateur.date_naissance}"
											<c:if test="${collaborateur!=null}">readonly</c:if>>
									</div>
								</div>
								<div class="form-group row">
									<label for="adresse" class="col-sm-3 col-form-label">Adresse</label>
									<div class="col-sm-9">
										<input name="adresse" type="text" class="form-control"
											id="adresse" placeholder="Adresse"
											value="${collaborateur.adresse}">
									</div>
								</div>
								<div class="form-group row">
									<label for="num_secu" class="col-sm-3 col-form-label">Numéro
										de sécurité sociale</label>
									<div class="col-sm-9">
										<input name="num_secu_sociale" type="text"
											class="form-control" id="num_secu"
											placeholder="Numéro de sécurité sociale"
											value="${collaborateur.num_secu_sociale}"
											<c:if test="${collaborateur!=null}">readonly</c:if>>
									</div>
								</div>
								<div class="form-group row">
									<label for="phone" class="col-sm-3 col-form-label">Téléphone</label>
									<div class="col-sm-9">
										<input name="phone" type="text" class="form-control"
											id="phone" placeholder="Téléphone"
											value="${collaborateur.phone}">
									</div>
								</div>
							</div>
						</div>
						<!-- FIN INDENTITE -->
						<!-- POSTE -->
						<div class="card">
							<div class="card-header" role="tab" id="headingTwo">
								<h5 class="mb-0">
									<a class="collapsed" data-toggle="collapse" href="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo">Poste</a>
								</h5>
							</div>
							<div id="collapseTwo" class="collapse" role="tabpanel"
								aria-labelledby="headingTwo" data-parent="#accordion">
								<div class="card-body">
									<div class="form-group row">
										<label for="poste" class="col-sm-3 col-form-label">Poste</label>
										<div class="col-sm-9">
											<input name="intiulePoste" type="text" class="form-control"
												id="poste" placeholder="Poste"
												value="${collaborateur.initulePoste}">
										</div>
									</div>
									<div class="form-group row">
										<label for="dept" class="col-sm-3 col-form-label">Département</label>
										<div class="col-sm-9">
											<input name="departement" type="text" class="form-control"
												id="dept" placeholder="Département"
												value="${collaborateur.departement.nom}">
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- FIN POSTE -->

						<!-- COORDONNEES BANCAIRES -->
						<div class="card">
							<div class="card-header" role="tab" id="headingThree">
								<h5 class="mb-0">
									<a class="collapsed" data-toggle="collapse"
										href="#collapseThree" aria-expanded="false"
										aria-controls="collapseThree">Coordonnées bancaires</a>
								</h5>
							</div>
							<div id="collapseThree" class="collapse" role="tabpanel"
								aria-labelledby="headingThree" data-parent="#accordion">
								<div class="card-body">
									<div class="form-group row">
										<label for="banque" class="col-sm-3 col-form-label">Banque</label>
										<div class="col-sm-9">
											<input name="banque" type="text" class="form-control"
												id="banque" placeholder="Banque"
												value="${collaborateur.banque}">
										</div>
									</div>
									<div class="form-group row">
										<label for="bic" class="col-sm-3 col-form-label">BIC</label>
										<div class="col-sm-9">
											<input name="bic" type="text" class="form-control" id="bic"
												placeholder="BIC" value="${collaborateur.bic}">
										</div>
									</div>
									<div class="form-group row">
										<label for="iban" class="col-sm-3 col-form-label">IBAN</label>
										<div class="col-sm-9">
											<input name="iban" type="text" class="form-control" id="iban"
												placeholder="IBAN" value="${collaborateur.iban}">
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- FIN COORDONNEES BANCAIRES -->
					</div>
					<div class="form-group row">
						<div class="col-sm-10">
							<button type="submit" class="btn btn-primary">Sauvegarder</button>
						</div>
					</div>
				</form>
			</div>
		</div>
</body>
</html>