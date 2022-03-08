<%@ include file="./header.jspf"%>

<p class="display-1">${pr.name}</p>

<table class="table">
	<tr>
		<td>Category</td>
		<td>${pr.category.name}</td>
	</tr>
	<tr>
		<td>Description</td>
		<td>${pr.category.description}</td>
	</tr>
	<tr>
		<td>Quantity per unit</td>
		<td>${pr.quantityPerUnit}</td>
	</tr>
	<tr>
		<td>Unit price</td>
		<td>$ ${pr.unitPrice}</td>
	</tr>
	<tr>
		<td>Units in stock</td>
		<td>${pr.unitsInStock}</td>
	</tr>
	<tr>
		<td>Units on order</td>
		<td>${pr.unitsOnOrder}</td>
	</tr>
	<tr>
		<td>Reorder level</td>
		<td>${pr.reorderLevel}</td>
	</tr>
	<tr>
		<td>Discontinued?</td>
		<td>${pr.discontinued==1 ? "Yes": "No"}</td>
	</tr>
</table>

<%@ include file="./footer.jspf"%>