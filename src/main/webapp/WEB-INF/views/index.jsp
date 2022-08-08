<html>
<head>
<%@include file="./base.jsp"%>

<script type="text/javascript">
function myFunction() {
	  alert("Are u ready to delete the product");
	}

function myFanction() {
	  alert("Are u ready to Update the product");
	}

</script>
</head>
<body style="background-color:lightBlue;">

	<div class="container mt-3">
		<div class="col-md-12">
			<h1 class="text-center mb-3">Welcome to the device App</h1>

			<table class="table table-hover table-dark">
				<thead class="thead-dark">
					<tr>
						<th scope="col">S.NO</th>
						<th scope="col">Product Name</th>
						<th scope="col">Description</th>
						<th scope="col">Price</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${product}" var="p">
						<tr>
							<th scope="row">CustomerId${p.id}</th>
							<th scope>${p.name}</th>
							<td>${p.description }</td>
							<td class="font weight-bold">&#8377;${p.price }</td>
							<td><a href="delete/${p.id }" > <i onclick="myFunction()"  class="fas fa-trash" style="font-size:28px"></i>
                            <a href="update/${p.id }"> <i    onclick="myFanction()"   class="fas fa-pen-nib  text-danger" style="font-size:22px"></i>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="container text-center">
				<a href="addproduct" class="btn btn-outline-success">Add Product
				</a>
			</div>
		</div>
	</div>
</body>
</html>