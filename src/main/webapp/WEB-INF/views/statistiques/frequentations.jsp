<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<%@include file="../includes/header.jsp"%>
<body>
	<%@include file="../includes/navbar.jsp"%>
</body>
<div class="container">

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Chemin</th>
				<th>Nombre de visites</th>
				<th>Min (ms)</th>
				<th>Max (ms)</th>
				<th>Moyenne (ms)</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="visiteStat" items="${visites}">
				<tr>
					<td>${visiteStat.key}</td>
					<td>${ visiteStat.value.count }</td>
					<td>${ visiteStat.value.min }</td>
					<td>${ visiteStat.value.max }</td>
					<td>${ visiteStat.value.average }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
</html>