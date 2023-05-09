<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/include/link/link-head.jsp"%>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="global" />
	<div class="container-fluid m-0 p-0 container-h">
		
			<%@ include file="/include/header.jsp"%>
	
		<%@ include file="/include/slide.jsp"%>
		<!-- Tab menu -->
		<%@ include file="/include/content.jsp"%>
		<!-- Content -->

		<!-- End Content -->
		<!-- <footer class="container-fluid bg-danger mt-3">
<h2>Footer</h2>
    </footer> -->
	</div>


	<!-- Bootstrap JavaScript Libraries -->
	<%@ include file="/include/link/link-footer.jsp"%>
	<%-- <script src="<c:url value ="/views/index.js"/>"></script> --%>
</body>
</html>