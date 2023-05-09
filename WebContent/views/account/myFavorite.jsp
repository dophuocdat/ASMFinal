<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/include/link/link-head.jsp"%>
</head>

<body>
	<div class="container-fluid container-h">

		<%@ include file="/include/header.jsp"%>
		<div class="form-profile">
			<div class="card bg-light">
				<div class="card-header text-center">
					<h2>List My Favorite</h2>
				</div>
				<div class="card-body ">
					<table id="tableFav" class="table table-hover">
						<thead>
							<tr>
								<th scope="col">ID Video</th>
								<th scope="col">Title</th>
								<th scope="col">Description</th>
								<th scope="col">Views</th>
								<th scope="col">Date</th>
								<th scope="col">like</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var = "tempMyFav" items ="${ListMyFavorite}">
							<tr>
								<th scope="row">${tempMyFav.idVideo}</th>
								<td>${tempMyFav.title}</td>
								<td>${tempMyFav.description}</td>
								<td>${tempMyFav.views}</td>
								<td>${tempMyFav.likeDate}</td>
								<td>
									<form action="/Unlike">
										<button type="submit" class="btn btn-danger">
											<i class="fas fa-thumbs-up"></i>
										</button>
									</form>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="/include/link/link-footer.jsp"%>
</body>
</html>