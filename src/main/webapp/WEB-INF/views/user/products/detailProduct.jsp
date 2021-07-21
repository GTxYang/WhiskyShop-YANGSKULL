<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<html>
<body>

	<c:forEach var="item" items="${detail}">
		<div class="men">
			<div class="container">
				<div>
					<div class="single_left">
						<div class="labout span_1_of_a1">
							<div class="flexslider">
								<ul style="list-style-type: none;">

									<li data-thumb="images/s1.jpg"
										style="list-style-position: inside; border: 1px solid black;"><img
										src="<c:url value="/assets/user/images/products/${item.img}" />"
										style="width: 100%" /></li>

								</ul>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="cont1 span_2_of_a1 simpleCart_shelfItem">
							<h1 style="font-weight: bold">${item.name}</h1>
							<p class="availability">
								Availability: <span class="color">In stock</span>
							</p>
							<div class="price_single">
								<!-- giảm giá: <span class="reducedfrom">$140.00</span> -->
								<span class="amount item_price actual"><fmt:formatNumber
										type="number" maxFractionDigits="6" value="${item.price}" />
									VNĐ</span>
							</div>
							<div class="wish-list">
								<div style="">
									<h4>Deatils</h4>
								</div>
								<div >
									<ul>
										<li><p class="quick_desc">Volumn: ${item.volumn}%</p></li>
									</ul>
									<ul>
										<li><p class="quick_desc">Size: ${item.ml}ml</p></li>
									</ul>
									<ul>
										<li><p class="quick_desc">Brand: ${item.nameBrand}</p></li>
									</ul>

									<ul>
										<li><p class="quick_desc">Country: ${item.origin}</p></li>
									</ul>
								</div>



							</div>
							<h2 class="quick">Đôi nét về rượu:</h2>
							<p class="quick_desc">${item.title}</p>


							<div class="quantity_box">
								<ul class="product-qty">
									<span>Quantity:</span>
									<select>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
										<option>6</option>
									</select>
								</ul>
								<div class="clearfix"></div>
							</div>
							<a href="<c:url value="/AddCart/${item.id}" />"
								class="btn btn-primary btn-normal btn-inline btn_form button item_add item_1"
								target="_self">Add to cart</a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="sap_tabs">
						<div id="horizontalTab"
							style="display: block; width: 100%; margin: 0px;">
							<ul class="resp-tabs-list">
								<li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>Product
										Information</span></li>

							</ul>
							<div class="resp-tabs-container">
								<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
									<div class="facts">
										<ul class="tab_list">
											<li>${item.detail }</li>
										</ul>
									</div>
								</div>


							</div>
						</div>
					</div>
				</div>
				<div>
					<h3 class="m_1">Các sản phẩm khác</h3>
					<!--Set nếu mà tổng sp theo cate lớn hơn 4 thì chỉ lấy 3 tính lun 0   -->
					<c:set var="countList" value="${ productsByCate.size()}"/>
					<c:if test="${ productsByCate.size() > 4}"> 
						<c:set var="countList" value="3"/>
					</c:if>
					<c:if test="${productsByCate.size() > 0 }">
						<div class="row">
							<div class="clearfix"></div>

							<c:forEach var="item" items="${productsByCate}" begin="0" end="${countList }" varStatus="index">
								<div class="col-sm-3">
									<div class="card">
										<img
											src="<c:url value="/assets/user/images/products/${item.img}" />"
											alt="Denim Jeans" style="width: 100%">
										<h4><a href="<c:url value="/detail/${item.id}"/>">${item.name }</a></h4>
										<p class="price">
											<fmt:formatNumber type="number" maxFractionDigits="6"
												value="${item.price}" />
											VNĐ
										</p>
										<p>
											<button>Add to Cart</button>
										</p>
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

				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</c:forEach>
</body>
</html>