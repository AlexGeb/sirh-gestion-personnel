
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
		<input name="prenom" type="text" class="form-control" id="prenom"
			placeholder="Prénom" value="${collaborateur.prenom}"
			<c:if test="${collaborateur!=null}">readonly</c:if>>
	</div>
</div>
<div class="form-group row">
	<label for="birth" class="col-sm-3 col-form-label">Date de
		naissance</label>
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
		<input name="adresse" type="text" class="form-control" id="adresse"
			placeholder="Adresse" value="${collaborateur.adresse}">
	</div>
</div>
<div class="form-group row">
	<label for="num_secu" class="col-sm-3 col-form-label">Numéro de
		sécurité sociale</label>
	<div class="col-sm-9">
		<input name="num_secu_sociale" type="text" class="form-control"
			id="num_secu" placeholder="Numéro de sécurité sociale"
			value="${collaborateur.num_secu_sociale}"
			<c:if test="${collaborateur!=null}">readonly</c:if>>
	</div>
</div>
<div class="form-group row">
	<label for="phone" class="col-sm-3 col-form-label">Téléphone</label>
	<div class="col-sm-9">
		<input name="phone" type="text" class="form-control" id="phone"
			placeholder="Téléphone" value="${collaborateur.phone}">
	</div>
</div>
</div>