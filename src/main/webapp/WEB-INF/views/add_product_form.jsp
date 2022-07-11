<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">



body{
body {background-color: coral;}
 }


</style>


<script type="text/javascript">
function myFunction() {
	  alert("product added");
	}

</script>


<meta charset="ISO-8859-1">

<%@include file="./base.jsp"%>
</head>
<body  style="background-color:lightBlue;">
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<h1 class="text-center mb-3">Fill the product Details</h1>

				<form action="handle-product" method="post">
					<div class="form-group">
						<label for="username">ProductName</label> <input type="text" required="required"
							class="form-control" id="productname" name="name"
							aria-describedby="emailHelp" placeholder="Enter productname">
					</div>


					<div class="form-group">
						<label for="productDescription">productDescription</label>
						<textarea rows="4" class="form-control" id="productDescription"  required="required"
							name="description" placeholder="Enter the product Description"></textarea>
					</div>

					<div class="form-group">
						<label for="productprice">Product Price</label> <input
							type="number"  required="required"  class="form-control" id="productprice"
							aria-describedby="productprice" name="price"
							placeholder="Enter productc price">
					</div>

					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary"  onclick="myFunction()" >Add</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>