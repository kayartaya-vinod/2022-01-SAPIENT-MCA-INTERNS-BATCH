<%@ include file="./header.jspf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<h3>Add a new shipper details</h3>


<div class="w-25">
	<sf:form modelAttribute="sh">
		<div class="mb-3">
			<label for="name" class="form-label">ID</label>
			<sf:input class="form-control" path="id" autofocus="true" />
			<sf:errors path="id" class="text-danger" />
		</div>

		<div class="mb-3">
			<label for="name" class="form-label">Company name</label>
			<sf:input class="form-control" path="name" />
		</div>

		<div class="mb-3">
			<label for="name" class="form-label">Phone number</label>
			<sf:input class="form-control" path="phone" />
		</div>
		<button class="btn btn-primary">Save</button>
	</sf:form>
</div>

<%@ include file="./footer.jspf"%>