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

 <form method="post" action="/ASMFinal/OEServlet/register" class="register"
        style="padding-top: unset !important;">
        <div class="card">
            <div class="card-header">
                <h3 class="text-center ">Sign up</h4>
                <div>
                    <h5 class="text-center text-danger">${ErrorRegister}</h5>
                </div>
            </div>
            <div class="card-body">
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="FullName"
                        name="fullName"> <label for="floatingInput">FullName</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="Id User" name="idUser">
                    <label for="floatingInput">ID User</label>
                </div>
                <div class="form-floating">
                    <input type="email" class="form-control" id="floatingEmail" placeholder="Email" name="email">
                    <label for="floatingEmail">Email</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password"
                        name="password"> <label for="floatingPassword">Password</label>
                </div>

            </div>

            <div class="card-footer d-flex justify-content-center align-items-center flex-column ">
                <button type="submit" class="btn btn-primary ">Sign up</button>
                <div class="other d-flex gap-3" style="background-color: rgba(152, 148, 148, 0.3); border-radius: 20px; padding: 10px; margin-top: 10px;">
                    <span class="fs-5 fw-lighter">Return Sign in <a class="text-info" href="/ASMFinal/views/account/login.jsp" >Here</a> </span>
                    <span class="fs-5 fw-lighter">Forget Password <a class="text-info" href="./ChangePassword.html" >Here</a></span>
                  </div>

            </div>
        </div>
    </form>

	</div>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>