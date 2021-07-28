<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>

<base href="${pageContext.servletContext.contextPath}/">

</head>
<body>



	<div class="men">
		<div class="container">
			<div class="col-md-3 sidebar_men">
				<h3>LOẠI RƯỢU</h3>
				<ul class="product-categories color">
					<c:forEach var="item" items="${categorys}">
						<li class="cat-item cat-item-42"><a
							href="<c:url value="san-pham/category/${item.id }"/>">${item.name}</a>
						</li>
					</c:forEach>
				</ul>
				<h3>Hãng Rượu</h3>
				<ul class="product-categories color">
					<c:forEach var="item" items="${brands}">
						<li class="cat-item cat-item-42"><a
							href="<c:url value="san-pham/brands/${item.id }"/>">${item.name}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-md-8 mens_right">
				<div class="dreamcrub">
					<ul class="breadcrumbs">
						<li class="home"><a href="index.html" title="Go to Home Page">Home</a>&nbsp;
							<span>&gt;</span></li>
						<li class="home">&nbsp; All Product &nbsp;</li>
					</ul>

					<div class="clearfix"></div>
				</div>
				<div class="mens-toolbar">
					<div class="sort">
						<div class="sort-by">
							<label>Sort By</label> <select>
								<option value="">Position</option>
								<option value="">Name</option>
								<option value="">Price</option>
							</select> <a href=""><img src="images/arrow2.gif" alt=""
								class="v-middle"></a>
						</div>
					</div>

					<div class="clearfix"></div>
				</div>




				<c:if test="${productsPaginate.size() > 0 }">
					<div class="row">
						<div class="clearfix"></div>

						<c:forEach var="item" items="${productsPaginate}"
							varStatus="index">
							<div class="col-sm-4">
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
							<c:if test="${(index.index+1) % 3 == 0 }">
					</div>
					<c:if test="${( index.index +1) < productsPaginate.size()}">
						<div class="row">
							<div class="clearfix"></div>
					</c:if>
				</c:if>

				</c:forEach>
				</c:if>





				<script src="<c:url value="assets/user/js/cbpViewModeSwitch.js" />"
					type="text/javascript"></script>
				<script src="<c:url value="assets/user/js/classie.js" />"
					type="text/javascript"></script>
			</div>


			<div class="clearfix"></div>
			<div style="justify-content: center;">
				<ul class="women_pagenation dc_paginationA dc_paginationA06">
					<li><a href="#" class="previous">Page : </a></li>
					<c:forEach var="item" begin="1" end="${paginateInfo.totalPage}"
						varStatus="loop">
						<c:if test="${(loop.index) == paginateInfo.currentPage }">
							<li class="active"><a
								href="san-pham/category/${id}/${loop.index}"> ${loop.index}
							</a></li>
						</c:if>
						<c:if test="${(loop.index) != paginateInfo.currentPage }">
							<li><a href="san-pham/category/${id}/${loop.index}">
									${loop.index}</a></li>
						</c:if>
					</c:forEach>

				</ul>
			</div>
		</div>



	</div>


</body>
</html>