<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../includes/header.jsp"%>
<body>
	<%@include file="../includes/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<h2>Nouveau collaborateur</h2>
		</div>
		<div class="col-md-12">
			<form method="post">
				<%@include file="../includes/newCollabForm.jsp"%>
				<div class="form-group row">
					<div class="col-sm-10">
						<button type="submit" class="btn btn-primary">Créer</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>