<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<body>
	<!-- 
Body Section 
-->

	<div class="main">
		<div class="container">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" style="margin-top: 10px">
					<c:forEach var="item" items="${slides}" varStatus="index">
						<c:if test="${index.first}">
							<div class="item active">
						</c:if>
						<c:if test="${ not index.first}">
							<div class="item">
						</c:if>
						<img style="width: 100%; height: 400px"
							src=<c:url value="assets/user/images/slide/${item.img}"/>
							alt="bootstrap ecommerce templates" />
				</div>

				</c:forEach>


			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<div class="middle_content">
		<div class="container">
			<div class="row">
				<div style="padding-top: 40px"></div>

				<div class="col-sm-4" style="display: flex">
					<div
						style="width: 74px; height: 74px; line-height: 72px; border-radius: 500px; border: 1px solid; color: #F9D9BE">
						<i class="far fa-credit-card fa-2x" style="padding-top: 23px"></i>
					</div>
					<div
						style="text-align: left; padding-left: 10px; padding-top: 10px">
						<h4 style="font-weight: bold; padding-right: 80px">THANH TOÁN
							ONLINE</h4>
						<h5>Chấp nhận tất cả thẻ trong nước và quốc tế</h5>
					</div>

				</div>

				<div class="col-sm-4" style="display: flex">
					<div
						style="width: 74px; height: 74px; line-height: 72px; border-radius: 500px; border: 1px solid; color: #F9D9BE">
						<i class="fas fa-exchange-alt fa-2x" style="padding-top: 23px"></i>
					</div>
					<div
						style="text-align: left; padding-left: 10px; padding-top: 10px">
						<h4 style="font-weight: bold; padding-right: 80px">CHÍNH SÁCH
							ĐỔI TRẢ</h4>
						<h5>Đổi trả miễn phí trong 3 ngày</h5>
					</div>

				</div>

				<div class="col-sm-4" style="display: flex">
					<div
						style="width: 74px; height: 74px; line-height: 72px; border-radius: 500px; border: 1px solid; color: #F9D9BE">
						<i class="fas fa-shipping-fast fa-2x" style="padding-top: 23px"></i>
					</div>
					<div
						style="text-align: left; padding-left: 10px; padding-top: 10px">
						<h4 style="font-weight: bold;">GIAO HÀNG NHANH</h4>
						<h5>Giao hàng 1 tiếng cho đơn hàng HCM</h5>
					</div>

				</div>
			</div>



			<div class="row">
				<div style="padding-top: 40px"></div>

				<div class="col-sm-4" style="display: flex">
					<div
						style="width: 74px; height: 74px; line-height: 72px; border-radius: 500px; border: 1px solid; color: #F9D9BE">
						<i class="fas fa-comments fa-2x" style="padding-top: 23px"></i>
					</div>
					<div
						style="text-align: left; padding-left: 10px; padding-top: 10px">
						<h4 style="font-weight: bold; padding-right: 80px">TƯ VẤN
							24/7</h4>
						<h5>Gọi ngay 0908 163 188</h5>
					</div>

				</div>

				<div class="col-sm-4" style="display: flex">
					<div
						style="width: 74px; height: 74px; line-height: 72px; border-radius: 500px; border: 1px solid; color: #F9D9BE">
						<i class="fas fa-shopping-cart fa-2x" style="padding-top: 23px"></i>
					</div>
					<div
						style="text-align: left; padding-left: 10px; padding-top: 10px">
						<h4 style="font-weight: bold;">VẬN CHUYỂN MIỄN PHÍ</h4>
						<h5>Đối với đơn hàng từ 500k</h5>
					</div>

				</div>

				<div class="col-sm-4" style="display: flex">
					<div
						style="width: 74px; height: 74px; line-height: 72px; border-radius: 500px; border: 1px solid; color: #F9D9BE">
						<i class="fas fa-user-plus fa-2x" style="padding-top: 23px"></i>
					</div>
					<div
						style="text-align: left; padding-left: 10px; padding-top: 10px">
						<h4 style="font-weight: bold; padding-right: 80px">ƯU ĐÃI HẤP
							DẪN</h4>
						<h5>Giới thiệu bạn bè để nhận được sự ưu đãi</h5>
					</div>

				</div>

			</div>
		</div>
		<hr />

		<div class="content_middle_bottom">
			<div class="header-left" id="home">
				<h3>LOẠI RƯỢU MỚI</h3>


				<div class="container">


					<c:if test="${newproducts.size() > 0 }">
						<div class="row">
							<div class="clearfix"></div>

							<c:forEach var="item" items="${newproducts}" varStatus="index">
								<div class="col-sm-3">
									<div class="card">
										<img
											src="<c:url value="/assets/products/${item.img}" />"
											alt="Denim Jeans" style="width: 100%">
										<h4><a href="<c:url value="/detail/${item.id}"/>">${item.name }</a></h4>
										<p class="price">
											<fmt:formatNumber type="number" maxFractionDigits="6"
												value="${item.price}" />
											VNĐ
										</p>
										<c:if test="${item.quanty == 0 }">
										<p>
											<button>Out Of Stock</button>
										</p>
										</c:if>
										<c:if test="${item.quanty > 0 }">
										<p>
											<button>Add to Cart</button>
										</p>
										</c:if>
										
									</div>
								</div>
								<c:if test="${(index.index+1) % 4 ==0 }">
							</div>
						<c:if test="${( index.index +1) < newproducts.size()}">
								<div class="row">
								<div class="clearfix"></div>
						</c:if>
					</c:if>

					</c:forEach>
					</c:if>

					<hr />
				</div>

				<div class="container">
					<h3>LOẠI RƯỢU NỔI BẬT</h3>

					<c:if test="${highlightproducts.size() > 0 }">
						<div class="row">
							<div class="clearfix"></div>

							<c:forEach var="item" items="${highlightproducts}"
								varStatus="index">
								<div class="col-sm-3">
									<div class="card">
										<img
											src="<c:url value="/assets/products/${item.img}" />"
											alt="Denim Jeans" style="width: 100%">
										<h4><a href="<c:url value="/detail/${item.id}"/>">${item.name }</a></h4>
										<p class="price"><p class="price">
											<fmt:formatNumber type="number" maxFractionDigits="6"
												value="${item.price}" />
											VNĐ
										</p></p>
										
											<c:if test="${item.quanty == 0 }">
										<p>
											<button style="background-color: gray;" disabled>Out Of Stock</button>
										</p>
										</c:if>
										<c:if test="${item.quanty > 0 }">
										<form method="get" action="AddCart/${item.id}">
											<p>
												<button>Add to Cart</button>
											</p>
										</form>
									</c:if>
									</div>
								</div>
								<c:if test="${(index.index+1) % 4 ==0 }">
						
						</div>
						<c:if test="${( index.index +1) < highlightproducts.size()}">
							<div class="row">
								<div class="clearfix"></div>
						
						</c:if>
					</c:if>

					</c:forEach>
					</c:if>
				</div>

				<div class="container"">
					<div class="container">
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								<li data-target="#myCarousel" data-slide-to="1"></li>
								<li data-target="#myCarousel" data-slide-to="2"></li>
							</ol>

							<!-- Wrapper for slides -->
							<div class="carousel-inner" style="margin-top: 10px">
								<c:forEach var="item" items="${slides}" varStatus="index">
									<c:if test="${index.first}">
										<div class="item active">
									
									</c:if>
									<c:if test="${ not index.first}">
										<div class="item">
									
									</c:if>
									<img style="width: 100%; height: 400px"
										src=<c:url value="assets/user/images/slide/${item.img}"/>
										alt="bootstrap ecommerce templates" />
							
							</div>

							</c:forEach>


						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel"
							data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>






			</div>
		</div>
	</div>

</body>
