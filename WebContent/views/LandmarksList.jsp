<%@page import="main.java.etities.Landmark"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Полный список достопримечательностей</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- Custom CSS -->
<link href="css/album.css" rel="stylesheet">
</head>

<body>
	<header>
		<div class="bg-dark">
			<!-- header -->
			<div>
				<h3 class="text-white">Достопримечательности Копенгагена</h3>
			</div>
		</div>
	</header>
	<div class="album py-5 bg-light">
		<div class="container">

			<div class="row">

				<%
					List<Landmark> landmarks = (List<Landmark>) request.getAttribute("landmarkList");
					for (Landmark landmark : landmarks) {
				%>
				<div class="col-md-4">
					<div class="card mb-4 shadow-sm">

						<svg class="bd-placeholder-img card-img-top" width="100%"
							height="225" xmlns="http://www.w3.org/2000/svg"
							preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
							aria-label="Placeholder: Thumbnail">	
            		 	<title>
							<%= landmark.getName() %>
						</title>
            	<rect width="100%" height="100%" fill="#55595c" />
            	<image x="0" y="0" width="100%" height="100%"
								xlink:href=<%out.println("\"" + request.getContextPath() + "/images/" + landmark.getName() + ".png\"");%> />
            </svg>
						<div class="card-body">
							<p class="card-text">
								<%= landmark.getDescription() %>
							</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
									<!-- <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button> -->
								</div>
								<small class="text-muted">
									<%= landmark.getCategory() %>
								</small>
							</div>
						</div>
					</div>
				</div>
				<%
					}
				%>

			</div>
		</div>
	</div>

</body>
</html>