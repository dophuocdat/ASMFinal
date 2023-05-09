<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Youtube API</h2>
	<form action="" method="get">
		<input type="text" name="search" placeholder="Search. . ." /> <input
			type="submit" value="Search" />
	</form>
	<ul>
		<c:forEach var="tempVideo" items="${Videos}">
			<p>${tempVideo.title}</p>
			<li><a
				href='/ASMFinal/views/showVideo.jsp?id=${tempVideo.idVideo}'> <img
					alt='${tempVideo.title }' src=${tempVideo.poster } />
			</a></li>
		</c:forEach>




	</ul>
</body>
</html>