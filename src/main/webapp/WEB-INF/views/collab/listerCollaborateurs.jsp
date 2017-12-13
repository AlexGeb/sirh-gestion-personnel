<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../header.jsp"%>
<body>
	<%@include file="../navbar.jsp"%>
	<div class="container">
		<h1>Les collaborateurs</h1>
		<div class="row">
			<%
				List<Collaborateur> collaborateurs = (List<Collaborateur>) request.getAttribute("collaborateurs");
				for (Collaborateur collab : collaborateurs) {
			%>
			<div class="card" style="width: 20rem;">
				<img class="card-img-top rounded img-thumbnail"
					src="<%=request.getContextPath()%>/images/<%=collab.getPhoto()%>"
					alt="Responsive image">
				<div class="card-body">
					<h4 class="card-title"><%=collab.getPrenom()%>
						<%=collab.getNom()%></h4>
					<p class="card-text">Date de naissance : <%=collab.getDate_naissance()%></p>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>