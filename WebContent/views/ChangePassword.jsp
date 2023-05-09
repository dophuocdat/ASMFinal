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
	<div class="container-fluid m-0 p-0 container-h">
			<%@ include file="/include/header.jsp"%>
			
		<form method="post" action="#" class="row changePass">
			<div class="card">
				<div class="card-header">
					<h3 class="text-center">Change Password</h3>
				</div>
				<div class="card-body">
					<div>
						<label>Fullname</label> <input type="text" class="form-control"
							placeholder="fullname" name="fullname">
					</div>
					<div>
						<label>Email address</label> <input type="email"
							class="form-control" placeholder="name@example.com" name="email">
					</div>
					<div>
						<label>old Password</label> <input type="password"
							class="form-control" placeholder="Old Password"
							name="oldpassword">
					</div>
					<div>
						<label>new Password</label> <input type="password"
							class="form-control" placeholder="New Password"
							name="newpassword">
					</div>
				</div>

				<div
					class="card-footer d-flex justify-content-center align-items-center flex-column ">
					<button type="submit" class="btn btn-primary ">Save</button>
				</div>
			</div>
		</form>

	</div>

	<%@ include file="/include/footer.jsp"%>
</body>
</html>