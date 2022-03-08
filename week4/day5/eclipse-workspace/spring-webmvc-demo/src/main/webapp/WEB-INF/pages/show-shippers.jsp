<%@ include file="./header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Shipper list</h3>

<ul>
	<c:forEach items="${shippers}" var="sh">
		<li><a href="./shipper-details?id=${sh.id}"> ${sh.name} </a></li>
	</c:forEach>
</ul>


<%@ include file="./footer.jspf"%>