
<ul
	class="nav nav-pills nav-pills-bg-soft justify-content-sm-center  mb-4 px-3 mt-4"
	id="course-pills-tab" role="tablist">
	<li class="nav-item me-2 me-sm-5" role="presentation">
		<button class="nav-link mb-2 mb-md-0 active" id="course-pills-tab-1"
			data-bs-toggle="pill" data-bs-target="#course-pills-tabs-1"
			type="button" role="tab" aria-controls="course-pills-tabs-1"
			aria-selected="true">
			Top Music
		</button>
	</li>
	<li class="nav-item me-2 me-sm-5" role="presentation">
		<button class="nav-link mb-2 mb-md-0" id="course-pills-tab-2"
			data-bs-toggle="pill" data-bs-target="#course-pills-tabs-2"
			type="button" role="tab" aria-controls="course-pills-tabs-2"
			aria-selected="false" tabindex="-1">SPORTS</button>
	</li>
	<li class="nav-item me-2 me-sm-5" role="presentation">
		<button class="nav-link mb-2 mb-md-0" id="course-pills-tab-3"
			data-bs-toggle="pill" data-bs-target="#course-pills-tabs-3"
			type="button" role="tab" aria-controls="course-pills-tabs-3"
			aria-selected="false" tabindex="-1">FILM AND ANIMATION</button>
	</li>
	<li class="nav-item me-2 me-sm-5" role="presentation">
		<button class="nav-link mb-2 mb-md-0" id="course-pills-tab-4"
			data-bs-toggle="pill" data-bs-target="#course-pills-tabs-4"
			type="button" role="tab" aria-controls="course-pills-tabs-4"
			aria-selected="false" tabindex="-1">News & Politics</button>
	</li>
	<li class="nav-item me-2 me-sm-5" role="presentation">
		<button class="nav-link mb-2 mb-md-0" id="course-pills-tab-5"
			data-bs-toggle="pill" data-bs-target="#course-pills-tabs-5"
			type="button" role="tab" aria-controls="course-pills-tabs-5"
			aria-selected="false" tabindex="-1">ENTERTAINMENT</button>
	</li>

</ul>
<c:url var="showVideo" value="/OEServlet/showVideo" />
<!-- TabContent -->
<div class="tab-content container TabContent"
	id="course-pills-tabContent">
	<!-- Tab1 -->
	<div class="tab-pane fade show active tab-item"
		id="course-pills-tabs-1" role="tabpanel"
		aria-labelledby="course-pills-tab-1">
		<div class="g-4 row">
			<div class="bigTitle my-3">
				<h2 class="text-center bg-danger">Top Music</h2>
			</div>
			<c:forEach var="tempVideo" items="${listTopMusic }">
				<div class="col-lg-3 col-md-4 col-sm-6 pe-3" data-aos="fade-down"
					data-aos-easing="linear" data-aos-duration="400">
					<div class="item-video">
						<div class="card">
							<div class="card-body">
								<form action="${showVideo}?action=watch&id=${tempVideo.idVideo}"
									method="post">
									<div class="playVideo">
										<img src='${tempVideo.poster }' alt="img" class="w-100"
											style="height: 200px;"> <input type="submit"
											value="Play">

									</div>
									<div class="title">
										<div class="nameVideo">
											<h3>${tempVideo.title }</h3>
										</div>
										<span>${tempVideo.description }</span>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
	<!-- End Tab1 -->

	<!-- Tab2 -->
	<div class="tab-pane fade tab-item" id="course-pills-tabs-2"
		role="tabpanel" aria-labelledby="course-pills-tab-2">
		<div class="g-4 row">
			<div class="bigTitle my-3">
				<h2 class="text-center bg-danger">SPORTS</h2>
			</div>
			<c:forEach var="tempVideo" items="${listSport}">
				<div class="col-lg-3 col-md-4 col-sm-6 pe-3" data-aos="fade-down"
					data-aos-easing="linear" data-aos-duration="400">
					<div class="item-video">
						<div class="card">
							<div class="card-body">
								<form action="${showVideo}?action=watch&id=${tempVideo.idVideo}"
									method="post">
									<div class="playVideo">
										<img src='${tempVideo.poster }' alt="img" class="w-100"
											style="height: 200px;"> <input type="submit"
											value="Play">
									</div>
									<div class="title">
										<div class="nameVideo">
											<h3>${tempVideo.title }</h3>
										</div>
										<span>${tempVideo.description }</span>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


	<!-- End Tab2 -->
	<!-- Tab3 -->
	<div class="tab-pane fade tab-item" id="course-pills-tabs-3"
		role="tabpanel" aria-labelledby="course-pills-tab-3">
		<div class="g-4 row">
			<div class="bigTitle my-3">
				<h2 class="text-center bg-danger">FILM AND ANIMATION</h2>
			</div>
			<c:forEach var="tempVideo" items="${ListFimlAndAnim}">
				<div class="col-lg-3 col-md-4 col-sm-6 pe-3" data-aos="fade-down"
					data-aos-easing="linear" data-aos-duration="400">
					<div class="item-video">
						<div class="card">
							<div class="card-body">
								<form action="${showVideo}?action=watch&id=${tempVideo.idVideo}"
									method="post">
									<div class="playVideo">
										<img src='${tempVideo.poster }' alt="img" class="w-100"
											style="height: 200px;"> <input type="submit"
											value="Play">
									</div>
									<div class="title">
										<div class="nameVideo">
											<h3>${tempVideo.title }</h3>
										</div>
										<span>${tempVideo.description }</span>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>
	<!-- End Tab3 -->
	<!-- Tab4 -->
	<div class="tab-pane fade tab-item" id="course-pills-tabs-4"
		role="tabpanel" aria-labelledby="course-pills-tab-4">
		<div class="g-4 row">
			<div class="bigTitle my-3">
				<h2 class="text-center bg-danger">NEWS POLITICS</h2>
			</div>
			<c:forEach var="tempVideo" items="${listNewPolitics}">
				<div class="col-lg-3 col-md-4 col-sm-6 pe-3" data-aos="fade-down"
					data-aos-easing="linear" data-aos-duration="400">
					<div class="item-video">
						<div class="card">
							<div class="card-body">
								<form action="${showVideo}?action=watch&id=${tempVideo.idVideo}"
									method="post">
									<div class="playVideo">
										<img src='${tempVideo.poster }' alt="img" class="w-100"
											style="height: 200px;"> <input type="submit"
											value="Play">
									</div>
									<div class="title">
										<div class="nameVideo">
											<h3>${tempVideo.title }</h3>
										</div>
										<span>${tempVideo.description }</span>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- End Tab4 -->
	<!-- Tab 5 -->
	<div class="tab-pane fade tab-item" id="course-pills-tabs-5"
		role="tabpanel" aria-labelledby="course-pills-tab-4">
		<div class="g-4 row">
			<div class="bigTitle my-3">
				<h2 class="text-center bg-danger">ENTERTAINMENT</h2>
			</div>
			<c:forEach var="tempVideo" items="${listEntertainment}">
				<div class="col-lg-3 col-md-4 col-sm-6 pe-3" data-aos="fade-down"
					data-aos-easing="linear" data-aos-duration="400">
					<div class="item-video">
						<div class="card">
							<div class="card-body">
								<form action="${showVideo}?action=watch&id=${tempVideo.idVideo}"
									method="post">
									<div class="playVideo">
										<img src='${tempVideo.poster }' alt="img" class="w-100"
											style="height: 200px;"> <input type="submit"
											value="Play">
									</div>
									<div class="title">
										<div class="nameVideo">
											<h3>${tempVideo.title }</h3>
										</div>
										<span>${tempVideo.description }</span>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
	<!-- End tab 5 -->

</div>