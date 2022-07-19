<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Fill the Product Details</h1>
				<form action="handel-product" method="POST">
					<div class="form-group">
						<label for="name">Product Name</label> <input type="text"
							name="name" placeholder="Enter the product name here"
							class="form-control" />
					</div>

					<div class="form-group">
						<label for="descriptio">Product Description</label>
						<textarea rows="5" name="description"
							placeholder="Enter product description here" class="form-control"></textarea>
					</div>
					<div class="form-group">
						<label for="price">Product Price </label> <input type="text"
							name="price" placeholder="Enter the product price here"
							class="form-control" />
					</div>
					<div class="container text-center">
					<a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Back</a>
					 <button type="submit" class="btn btn-primary">Add</button>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>