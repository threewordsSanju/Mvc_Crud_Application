<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
function myFunction() {
	  alert("Your product is Updating");
	}

</script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:lightBlue;">

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<h1 class="text-center mb-3">Update the device Details</h1>
				<form action="${pageContext.request.contextPath}/update-product" method="post">


					<div class="form-group">
						<label for="id">Product ID</label> <input type="number" required="required"
							class="form-control" id="id" name="id"
							aria-describedby="emailHelp" value="${products.id}">
					</div>


					<div class="form-group">
						<label for="username">ProductName</label> <input type="text"  required="required"
							class="form-control" id="productname" name="name"
							aria-describedby="emailHelp" placeholder="Enter productname"
							value="${products.name }">
					</div>


					<div class="form-group">
						<label for="productDescription">productDescription</label>
						<textarea rows="5" class="form-control" id="productDescription" required="required"
							name="description" placeholder="Enter the product Description">${products.description }</textarea>
					</div>

					<div class="form-group">
						<label for="productprice">Product Price</label> <input
							type="number" class="form-control" id="productprice" required="required"
							aria-describedby="productprice" name="price"
							placeholder="Enter productc price" value="${products.price }">
					</div>

					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-danger">Back</a>
						<button onclick="myFunction()"  type="submit" class="btn btn-warning">Update</button>
					</div>

				</form>
				<hr>
			</div>
		</div>
	</div>


</body>
</html>