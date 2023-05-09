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


		<form method="post" action="/ASMFinal/OEServlet/Login"
			class="row login">
			<div class="card">
				<div class="card-header">
					<h3 class="text-center">Sign in</h3>
					<div>
						<h3>${message }</h3>
					</div>
				</div>
				<div class="card-body">
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="floatingInput"
							placeholder="Id User" name="idUser"> <label
							for="floatingInput">ID User</label>
					</div>
					<div class="form-floating">
						<input type="password" class="form-control" id="floatingPassword"
							placeholder="Password" name="password"> <label
							for="floatingPassword">Password</label>
					</div>
					<div
						class="reme text-light d-flex justify-content-center align-items-center gap-2 fs-4">
						<input type="checkbox" value="remeber" checked> Remember
						me?
					</div>
				</div>

				<div
					class="card-footer d-flex justify-content-center align-items-center flex-column ">
					<button type="submit" class="btn btn-primary ">Sign in</button>
					<div class="other d-flex gap-3"
						style="background-color: rgba(152, 148, 148, 0.3); border-radius: 20px; padding: 10px; margin-top: 10px;">
						<span class="fs-5 fw-medium">You can sign up <a
							class="text-info" href="/ASMFinal/views/account/signUp.jsp">Here</a>
						</span> <span class="fs-5 fw-medium">Forget Password <a
							class="text-info" href="./ChangePassword.html">Here</a></span>
					</div>
					<hr>
					<span class="text-light fs-5 fw-light">Login by Social</span>
					<div
						class="socical_login d-flex justify-content-center align-items-center gap-5">

						<a href="#" class="fs-2"> <i
							class="fab fa-facebook-square text-info"></i>
						</a> <a href="#" class="fs-2"> <i
							class="fab fa-google text-danger"></i>
						</a> <a href="#" class="fs-2"> <i
							class="fab fa-twitter-square text-primary"></i>
						</a>
					</div>

				</div>
			</div>
		</form>


	</div>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>