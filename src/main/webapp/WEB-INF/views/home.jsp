<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Spring list binder sample</title>
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<h1> List of items </h1>
	
	<h2>Current Items</h2>
	<ul>
		<c:forEach items="${order.items}" var="item">
			<li>#${item.id}, ${item.name} x ${item.quantity }, ${item.deleted ? 'Deleted' : 'Not deleted'} 
		</c:forEach>
	</ul>
	
	<form:form modelAttribute="order">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Delete</th>
					<th>Name</th>
					<th>Quantity</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${order.items}" var="item" varStatus="status">
					<tr>		
						<td>
							<form:hidden path="items[${status.index}].id"/>
							<form:checkbox path="items[${status.index}].deleted"/>
						</td>
						<td>
							<form:hidden path="items[${status.index}].name"/>
							${item.name}
						</td>
						<td>
							<form:input path="items[${status.index}].quantity"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:button>Update</form:button>
	</form:form>
</div>



</body>
</html>
