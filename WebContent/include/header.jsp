<%-- <fmt:setLocale value="${sessionScope.lang }" scope="request" />
	<fmt:setBundle basename="global" scope="request" /> --%>
	
<header style="padding-bottom: 70px">
	<nav class="navbar header navbar-expand-lg position-fixed  w-100 px-5">
		<a class="navbar-brand" href="#"> <img src="${urlImg}/LOGO.png"
			alt="" width="70px">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarsExample" aria-controls="navbarsExample05"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarsExample">
			<ul
				class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 menu">
				<li><a href="/ASMFinal/OEServlet" class="nav-link px-2">Home</a></li>
				<li><a href="#" class="nav-link px-2">FAQs</a></li>
				<li><a href="#" class="nav-link px-2">About</a></li>
			</ul>
			<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3 search"
				role="search">
				<input type="search" class="form-control" placeholder="Search..."
					aria-label="Search"> <i class="fas fa-magnifying-glass"></i>
			</form>
			<div class="d-flex justify-content-center align-items-center gap-4">
				<div class="dropdown-center text-start">
					<a href="#"
						class="d-block link-dark text-decoration-none dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false"> <i
						class="fas fa-globe text-light"></i>
					</a>
					<ul class="dropdown-menu text-small dropdown-menu-lg-end">
						<li><a class="dropdown-item" href="?lang=vi">VN</a></li>
						<li><a class="dropdown-item" href="?lang=en_US">EN</a></li>
						<li><a class="dropdown-item" href="#">US</a></li>
						<li><a class="dropdown-item" href="#">UK</a></li>
					</ul>
				</div>

				<div class="dropdown-center text-start text-black">
					<a href="#"
						class="d-block link-dark text-decoration-none dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false"> <c:if
							test="${not logger}">
							<img src="https://github.com/mdo.png" alt="mdo" width="32"
								height="32" class="rounded-circle">
						</c:if> <c:if test="${logger}">
							<span>${user.getFullname().toUpperCase() }</span>
						</c:if>
					</a>
					<ul class="dropdown-menu text-small dropdown-menu-lg-end">
						<c:if test="${logger }">
							<li>
								<form action="/ASMFinal/OEServlet/myProfile" method="post">
									<button class="dropdown-item"
										style="background: transparent; outline: none; border: none;">
										My Profile</button>
								</form>
							</li>
							<li><form action="/ASMFinal/OEServlet/myFavorite"
									method="post">
									<button class="dropdown-item"
										style="background: transparent; outline: none; border: none;">
										My Favorite</button>
								</form></li>
							<li>
								<button type="button" class=" dropdown-item"
									data-bs-toggle="modal" data-bs-target="#modalId">My
									Video</button>
							</li>
							<li><a class="dropdown-item" href="#">Setting</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li><a class="dropdown-item"
								href="/ASMFinal/views/ChangePassword.jsp">Change Password</a></li>
							<li>
								<form action="/ASMFinal/OEServlet/Logout" method="post">
									<button class="dropdown-item"
										style="background: transparent; outline: none; border: none;">
										Logout</button>
								</form>
							</li>
						</c:if>
						<c:if test="${not logger }">
							<li><a class="dropdown-item"
								href="/ASMFinal/views/account/login.jsp">Sign in</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<div class="modal fade" id="modalId" tabindex="-1"
		data-bs-backdrop="static" data-bs-keyboard="false" role="dialog"
		aria-labelledby="modalTitleId" aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-lg"
			role="document">
			<div class="modal-content">
				<div class="modal-header justify-content-center">
					<h5 class="modal-title" id="modalTitleId">Upload Video</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="/ASMFinal/OEServlet/uploadVideo" method="post" enctype="multipart/form-data">
						<div class="input-group mb-3">
							<input type="file" class="form-control" id="inputGroupFile02"
								accept="video/*" name="videoFile" required> <label
								class="input-group-text" for="inputGroupFile02">Video
								File</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingTitle"
								name="title" placeholder="Title" required="required"> <label
								for="floatingTitle">Title</label>
						</div>
						<div class="form-floating mb-3">
							<textarea class="form-control" placeholder="Description here"
								id="floatingDescription" name="description"
								style="height: 100px"  ></textarea>
							<label for="floatingDescription">Description</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="floatingCategory"
								name="category" placeholder="category"> <label
								for="floatingCategory">Category</label>
						</div>
						<select class="form-select mb-3"
							aria-label="Default select example" id="privacyStatus"
							name="privacyStatus">
							<option selected>Privacy Status</option>
							<option value="public">Public</option>
							<option value="unlisted">Unlisted</option>
							<option value="private">Private</option>
						</select>



						<button type="submit" class="btn btn-primary">Upload
					</form>

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
		const myModal = new bootstrap.Modal(document.getElementById('modalId'),
				options)
	</script>
</header>

