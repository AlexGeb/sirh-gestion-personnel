<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand"
		href="<c:url value='lister'/>">SGP</a> 
	<a class="nav-item nav-link active" href="<c:url value='lister'/>">Collaborateurs
		<span class="sr-only">(current)</span></a> 
	<a class="nav-item nav-link" href="<c:url value='nouveau'/>">Nouveau</a>
	<a class="nav-item nav-link" href="<c:url value='frequentations'/>">Statistiques</a>
</nav>