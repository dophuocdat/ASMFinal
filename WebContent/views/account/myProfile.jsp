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
		<div class="form-profile login p">
			<div class="card bg-light">
				<div class="card-header text-center">
					<h2>Profile</h2>
				</div>
				<div class="card-body h-100 gap-1 mt-0 pt-0 justify-content-sm-evenly  ">
					<div class="form-floating mb-3 mt-3">
						<input type="email" class="form-control" id="floatingInput"
							placeholder="name@example.com" value="${user.getFullname().toUpperCase() }" readonly>
						<label>Fullname</label>
					</div>
					<div class="form-floating">
						<input type="email" class="form-control" id="floatingEmail"
							placeholder="Email" value="${user.getEmail()}" readonly> <label>Email</label>
					</div>
					<div class="form-floating mt-3">
						<input type="text" class="form-control" id="floatingIdUser"
							placeholder="idUser" value="${user.getIdUser()}" readonly> <label>ID
							User</label>
					</div>
					<div class="form-floating mt-3">
						<input type="text" class="form-control" id="floatingRole"
							placeholder="Role" value="${user.getAdmin() ? 'Admin' : 'Người dùng'}" readonly> <label>Role</label>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="/include/link/link-footer.jsp"%>
</body>
</html>