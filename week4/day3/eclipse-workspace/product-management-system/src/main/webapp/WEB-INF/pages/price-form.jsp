<%@ include file="./header.jspf"%>

<h1>Search products by price range</h1>

<form action="./search-by-price-range">
	<div class="form-group row">
		<label for="minPrice" class="col-sm-2 col-form-label">Minimum
			price</label>
		<div class="col-sm-3">
			<input type="text" class="form-control" id="minPrice" name="min">
		</div>
	</div>
	<div class="form-group row">
		<label for="maxPrice" class="col-sm-2 col-form-label">Maximum
			price</label>
		<div class="col-sm-3">
			<input type="text" class="form-control" id="maxPrice" name="max">
		</div>
	</div>

	<button class="btn btn-primary">Submit</button>
</form>
<%@ include file="./footer.jspf"%>