<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>

<base href="${pageContext.servletContext.contextPath}/">






</head>
<body>
	<c:if test="${not empty Cart}">
		<div class="container" style="padding-top: 15px">
			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th></th>
						<th></th>
						<th>Product</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total</th>
					</tr>

				</thead>

				<tbody>
					<c:forEach var="item" items="${Cart}" varStatus="index">


						<tr class="cart-header${index.count} ">
							<td style="width: 50px"><a
								href="<c:url value="/DeleteCart/${item.value.product.id}" />"
								class="close1 "></a></td>
							<td><img width="100"
							src="<c:url value="/assets/products/${item.value.product.img}"/>"
								
								alt=""></td>
							<td>${item.value.product.name}<br>${item.value.product.ml}
								ml<br>${item.value.product.volumn} %
							</td>
							<td><fmt:formatNumber type="number" maxFractionDigits="6"
									value="${item.value.product.price}" /> VNĐ</td>
							<td style="width: 50px">
								<div class="col-lg-2">
									<div class="input-group">
										<span class="input-group-btn">
											<button type="button"
												class="quantity-left-minus btn btn-danger btn-number"
												data-type="minus" data-field="">
												<span class="glyphicon glyphicon-minus"></span>
											</button>
										</span> <input style="width: 50px; height: 34px" type="text"
											id="quantity-${item.value.product.id}" name="quantity"
											class="form-control input-number"
											value="${item.value.quantity}" min="1" max="100"> <span
											class="input-group-btn">
											<button type="button"
												class="quantity-right-plus btn btn-success btn-number"
												data-type="plus" data-field="">
												<span class="glyphicon glyphicon-plus"></span>
											</button>
										</span>
									</div>
								</div>
							</td>
							<td><fmt:formatNumber type="number" maxFractionDigits="6"
									value="${item.value.price}" /> VNĐ</td>

							<td>
								<button data-id="${item.value.product.id}" class="btn-edit-cart"
									style="float: right">UpdateCart</button>
							</td>
						</tr>


					</c:forEach>
				</tbody>
			</table>
			<div>
				<h4>CART TOTALS</h4>
				<table class="table table-bordered table-condensed"
					style="text-align: end; width: fit-content;">
					<tr>
						<th class="total">Tổng tiền</th>
						<td class="total"><fmt:formatNumber type="number"
								maxFractionDigits="6" value="${TotalPriceCart}" /> VNĐ</td>
					</tr>
					<tr>
						<th class="total">Giảm giá</th>
						<td class="total">0%</td>
					</tr>
					<tr>
						<th class="total">Tổng</th>
						<td class="total"><fmt:formatNumber type="number"
								maxFractionDigits="6" value="${TotalPriceCart}" /> VNĐ</td>
					</tr>

				</table>
			</div>


			<div style="float: left">
				<a class="order" href="<c:url value="/checkout" />">Place Order</a>
			</div>

		</div>

		<content tag="script"> <script>
			$(".btn-edit-cart").on("click", function() {
				var id = $(this).data("id");
				var quanty = $("#quantity-" + id).val();
				/* 			alert("EditCart/"+id+"/"+quanty); */
				window.location = "EditCart/" + id + "/" + quanty;
			});
		</script> </content>

	</c:if>




	<c:if test="${empty Cart }">
	<div class="container" style="padding-top: 15px">
		<h3 style="text-align: center">Giỏ hàng của bạn đang trống</h3>
	</div>
	</c:if>



</body>
</html>