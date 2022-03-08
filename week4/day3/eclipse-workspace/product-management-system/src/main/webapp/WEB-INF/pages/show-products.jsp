<%@ include file="./header.jspf"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>${title!=null ? title: "List of all products" }</h2>
<table class="table">
	<thead>
		<tr>
			<th>Sl no</th>
			<th>Name</th>
			<th>Quantity per unit</th>
			<th>Unit price (USD)</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${requestScope.products}" var="p1" varStatus="vs">
			<tr>
				<td>${vs.index + 1}</td>
				<td>
				<a class="btn btn-link" href="./get-product?id=${p1.id}">
				${p1.name}
				</a>
				</td>
				<td>${p1.quantityPerUnit}</td>
				<td>${p1.unitPrice}</td>
			</tr>
		</c:forEach>
	</tbody>

</table>

<%@ include file="./footer.jspf"%>
