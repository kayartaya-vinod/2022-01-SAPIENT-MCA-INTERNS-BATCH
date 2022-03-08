<%@ include file="header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Add a new product</h1>

<form action="./add-new-product" method="post">

	<div class="form-group row">
		<label for="name" class="col-sm-2 col-form-label">Name</label>
		<div class="col-sm-3">
			<input type="text" class="form-control" id="name" name="name">
		</div>
	</div>
	<div class="form-group row">
		<label for="quantityPerUnit" class="col-sm-2 col-form-label">Quantity
			per unit</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="quantityPerUnit"
				name="quantityPerUnit">
		</div>
	</div>
	<div class="form-group row">
		<label for="unitPrice" class="col-sm-2 col-form-label">Unit
			price</label>
		<div class="col-sm-2">
			<input type="text" class="form-control" id="unitPrice"
				name="unitPrice">
		</div>
	</div>
	<div class="form-group row">
		<label for="unitsInStock" class="col-sm-2 col-form-label">Units
			in stock</label>
		<div class="col-sm-2">
			<input type="number" class="form-control" id="unitsInStock"
				name="unitsInStock">
		</div>
	</div>
	<div class="form-group row">
		<label for="unitsOnOrder" class="col-sm-2 col-form-label">Units
			on order</label>
		<div class="col-sm-2">
			<input type="number" class="form-control" id="unitsOnOrder"
				name="unitsOnOrder">
		</div>
	</div>
	<div class="form-group row">
		<label for="reorderLevel" class="col-sm-2 col-form-label">Reorder
			level</label>
		<div class="col-sm-2">
			<input type="number" class="form-control" id="reorderLevel"
				name="reorderLevel">
		</div>
	</div>
	<div class="form-group row">
		<label for="supplierId" class="col-sm-2 col-form-label">Supplier
			(ID)</label>
		<div class="col-sm-2">
			<input type="number" class="form-control" id="supplierId"
				name="supplierId">
		</div>
	</div>
	<div class="form-group row">
		<label for="categoryId" class="col-sm-2 col-form-label">Category</label>
		<div class="col-sm-2">
			<select class="form-select" name="categoryId">
				<option value="-1">--Select--</option>
				<c:forEach items="${categories}" var="c">
					<option value="${c.id}">${c.name}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group row">
		<label for="discontinued" class="col-sm-2 col-form-label">Discontinued?</label>
		<div class="col-sm-4">
			<label><input type="radio" class="form-check-input"
				id="discontinued" name="discontinued" value="1"> Yes</label> <label><input
				type="radio" class="form-check-input" id="discontinued"
				name="discontinued" value="0"> No</label>
		</div>
	</div>
	<button class="btn btn-primary">Save</button>
</form>

<%@ include file="footer.jspf"%>