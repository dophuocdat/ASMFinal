<%@page import="com.google.api.services.youtube.model.Video"%>
<%@page import="APIYTB.APIYTB"%>
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
	<c:url var="showVideo" value="/OEServlet/showVideo" />
	<c:url var="url" value="/OEServlet" />
	<div class="container-fluid m-0 p-0 container-h">
		<%@ include file="/include/header.jsp"%>

		<div class="View row m-0">
			<div class="showVideo col-lg-8">
				<%-- <select id="streams" disabled></select>
				<video data-yt2html5="https://www.youtube.com/embed/<%=idVideo%>"
					height="300" width="100%" controls></video> --%>
				<iframe height="500" width="100%"
					src="https://www.youtube.com/embed/${idVideo}"
					title="YouTube video player" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
					allowfullscreen></iframe>
				<div class="decsVideoShow row">
					<div class="nameVideoShow col-lg-8">
						<h3>${info[0] }</h3>
						<div class="text-light">
							<strong>Views:</strong> <span>${info[2] } 👷</span>
						</div>
						<span class="title">${info[1] } </span>

					</div>

					<c:if test="${not UserNotLogin}">
						<div class="likeAndShare col-lg-4 d-flex gap-4 align-items-start">
							<div
								class="like d-flex justify-content-center align-items-center">
								<button id="like-button" type="submit" class="search-button"
									style="background: transparent; outline: none; border: none;">
									<i id="iconLike"
										class="fas fa-thumbs-up text-light ${active ?'like' :'unlike' }"></i>
								</button>


								<span class="text-light">${info[3]}</span>
							</div>

							<div
								class="share d-flex justify-content-center align-items-center">
								<!-- Modal trigger button -->
								<button type="button" class="btn btn-primary btn-lg"
									data-bs-toggle="modal" data-bs-target="#modalId1"
									style="background: transparent; outline: none; border: none;">
									<i class="fas fa-share-alt"></i>
								</button>

								<!-- Modal Body -->
								<!-- if you want to close by clicking outside the modal, delete the last endpoint:data-bs-backdrop and data-bs-keyboard -->
								<div class="modal fade" id="modalId1" tabindex="-1"
									data-bs-backdrop="static" data-bs-keyboard="false"
									role="dialog" aria-labelledby="modalTitleId" aria-hidden="true">
									<div
										class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-lg"
										role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="modalTitleId">Modal title</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="modal-body">
												<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
													<li class="nav-item" role="presentation">
														<button class="nav-link active" id="pills-Gmail-tab"
															data-bs-toggle="pill" data-bs-target="#pills-Gmail"
															type="button" role="tab" aria-controls="pills-Gmail"
															aria-selected="true">
															Gmail <i class="fas fa-envelope"></i>
														</button>
													</li>
													<li class="nav-item" role="presentation">
														<button class="nav-link" id="pills-Facebook-tab"
															data-bs-toggle="pill" data-bs-target="#pills-Facebook"
															type="button" role="tab" aria-controls="pills-Facebook"
															aria-selected="false">
															Facebook <i class="fab fa-facebook"></i>
														</button>
													</li>
													<li class="nav-item" role="presentation">
														<button class="nav-link" id="pills-Twitter-tab"
															data-bs-toggle="pill" data-bs-target="#pills-Twitter"
															type="button" role="tab" aria-controls="pills-Twitter"
															aria-selected="false">
															Twitter <i class="fab fa-twitter"></i>
														</button>
													</li>
													<li class="nav-item" role="presentation">
														<button class="nav-link" id="pills-Instagram-tab"
															data-bs-toggle="pill" data-bs-target="#pills-Instagram"
															type="button" role="tab" aria-controls="pills-Instagram"
															aria-selected="false">
															Instagram <i class="fab fa-instagram"></i>
														</button>
													</li>

												</ul>
												<div class="tab-content" id="pills-tabContent">


													<div class="tab-pane fade show active" id="pills-Gmail"
														role="tabpanel" aria-labelledby="pills-gmail-tab"
														tabindex="0">
														<div class="mb-3">
															<label for="to" class="form-label">To</label> <input
																type="email" class="form-control" id="to" class="To"
																placeholder="" readonly="readonly"
																value="${user.getEmail()}" />
														</div>
														<div class="mb-3">
															<label for="from" class="form-label">From</label> <input
																type="email" class="form-control" id="From" class="From"
																required="required">
														</div>
														<div class="mb-3">
															<label for="link" class="form-label">Link Video</label> <input
																type="text" class="form-control" id="link" name="link"
																placeholder="https://example.com"
																value="https://www.youtube.com/embed/${idVideo}">
														</div>
														<div class="mb-3">
															<label for="message" class="form-label">Message</label>
															<textarea class="form-control" id="message"
																name="message" rows="3"></textarea>
														</div>
														<button type="button" id="sendMail"
															class="btn btn-primary">Send</button>
														<span>${MessageSendMail}</span>
													</div>



													<div class="tab-pane fade" id="pills-Facebook"
														role="tabpanel" aria-labelledby="pills-Facebook-tab"
														tabindex="0">
														<div class="mb-3">
															<label for="" class="form-label">Link Facebook</label> <input
																type="text" class="form-control" name="" id=""
																aria-describedby="helpId" placeholder=""> <small
																id="helpId" class="form-text text-muted">Help</small>
														</div>
													</div>
													<div class="tab-pane fade" id="pills-Twitter"
														role="tabpanel" aria-labelledby="pills-Twitter-tab"
														tabindex="0">
														<div class="mb-3">
															<label for="" class="form-label">Link Twitter</label> <input
																type="text" class="form-control" name="" id=""
																aria-describedby="helpId" placeholder=""> <small
																id="helpId" class="form-text text-muted">Help</small>
														</div>
													</div>
													<div class="tab-pane fade" id="pills-Instagram"
														role="tabpanel" aria-labelledby="pills-Instagram-tab"
														tabindex="0">
														<div class="mb-3">
															<label for="" class="form-label">Link Instagram</label> <input
																type="text" class="form-control" name="" id=""
																aria-describedby="helpId" placeholder=""> <small
																id="helpId" class="form-text text-muted">Help</small>
														</div>
													</div>
												</div>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div>


								<!-- Optional: Place to the bottom of scripts -->
								<script>
								const myModal = new bootstrap.Modal(document.getElementById('modalId1'), options)

							</script>
							</div>

						</div>
						<%-- <div class="d-block text-danger ">
							<span>${UserNotLogin}</span>
						</div> --%>
					</c:if>
					<input type="hidden" value="${idVideo}" id="idVideoYTB">
				</div>
			</div>
			<div
				class="propose col-lg-4 d-flex row flex-lg-column  gap-5 align-items-center ">
				<div class="search_video">
					<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3 search"
						role="search" action="${showVideo}?action=watch&id=${idVideo}"
						method="post">
						<input type="search" class="form-control" placeholder="Search..."
							aria-label="Search" name="p">
						<button type="submit" class="search-button">
							<span class="visually-hidden">Search</span> <i
								class="fas fa-magnifying-glass"></i>
						</button>
					</form>
				</div>
				<c:forEach var="tempVideoSearch" items="${listVideoSearch}">
					<div class="item col-xs-12 d-flex gap-3">
						<form
							action="${showVideo}?action=watch&id=${tempVideoSearch.idVideo}"
							method="post">
							<div class="playVideo">
								<img src="${ tempVideoSearch.poster}" alt="img"> <input
									type="submit" value="Play">
							</div>
							<div class="desc d-flex flex-column">
								<h5 class="name text-light">${tempVideoSearch.title }</h4>
							</div>
						</form>
					</div>
				</c:forEach>


			</div>
		</div>
	</div>

	<script> 
	$(document).ready(function() {
		 var attrLike = $('#iconLike').attr('class')
		console.log(attrLike)
		if(attrLike.indexOf('like') != -1) {
      		  $('#iconLike').addClass('liked');
  	   	 }
 		$('#like-button').click(()=>{
			var idVideoYTB = $('#idVideoYTB').val();
				console.log(idVideoYTB)
			$.ajax({
				type: 'POST',
				url: '?action=liked&id='+ idVideoYTB,
				
				}).then((data)=>{
					 var attrLike = $('#iconLike').attr('class')
				 if (attrLike.indexOf('like') != -1) {
       				 $('#iconLike').toggleClass('liked');
   				 	}
			
				})
		
			})
		$('#sendMail').click(()=>{
				var to = $('#to').val();
				  var from = $('#From').val();
				  var link = $('#link').val();
				  var message = $('#message').val();
				  console.log()
				var idVideoYTB = $('#idVideoYTB').val();
				console.log("sendMail")
				$.ajax({
				type: 'POST',
				url: '?action=share&id='+ idVideoYTB,
				data: {
				      to: to,
				      from: from,
				      link: link,
				      message: message
				    }
				}).then((data)=>{
					
				})
			})

		})
</script>

	<%-- <%@ include file="/include/link/link-videohtml5.jsp"%> --%>
	<!-- Bootstrap JavaScript Libraries -->
	<%@ include file="/include/link/link-footer.jsp"%>
	<%-- <script src="<c:url value ="/views/index.js"/>"></script> --%>
</body>
</html>



