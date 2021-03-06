<%@ include file="./header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Shipper details</h3>

<table class="table w-50">
	<tr>
		<td>ID:</td>
		<td class="lead">${sh.id}</td>
	</tr>
	<tr>
		<td>Company name:</td>
		<td class="lead">${sh.name}</td>
	</tr>
	<tr>
		<td>Phone number:</td>
		<td class="lead">${sh.phone}</td>
	</tr>
</table>

<a class="btn btn-primary" href="./edit-shipper?id=${sh.id}">Edit</a>
<a class="btn btn-danger" href="./delete-shipper?id=${sh.id}">Delete</a>
<%@ include file="./footer.jspf"%>