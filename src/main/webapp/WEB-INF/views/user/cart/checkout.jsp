<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>

<base href="${pageContext.servletContext.contextPath}/">



</head>


<body>

	<div class="buyer-in">

		<div class="container">
			<div class="buyerInfo">
				<h3>Thông tin giao hàng</h3>
				<div class="row">

					<form:form action="test" modelAttribute="userInFo" method="get"
						id="usrform">
						<div class="col-sm-6 ">
							<div class="col-sm-6">
								<form:input path="id" type="hidden" disabled="true" />
								<span>Họ</span>
								<form:input path="first_name" type="text" disabled="true" />
								<span>Email</span>
								<form:input path="email" type="text" disabled="true" />
								<span>Địa chỉ</span>
								<form:input path="address" type="text" disabled="true" />
							</div>
							<div class="col-sm-6">
								<span>Tên</span>
								<form:input path="last_name" type="text" disabled="true" />
								<span>Số điện thoại</span>
								<form:input path="phone" type="text" disabled="true" />
							</div>
						</div>
					</form:form>

					<div>
						<form:form action="checkout" modelAttribute="bill" method="post" id="bill">
							<form:input  path="id_user" type="hidden" />
			
					
						
					</div>

					<div class="col-sm-6">
						<span>Ghi chú<label>*</label></span>
						<form:textarea rows="9" cols="50" name="comment" path="note" />

					</div>
					
				</div>
			</div>

			<div class="buyerOrder">
				<h3>Thông tin đơn hàng</h3>
				<table class="table table-bordered table-condensed">
					<thead>
						<tr style="background-color: F9D9BE">
							<th>Product</th>
							<th>Product Deatils</</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Total</th>
						</tr>

					</thead>

					<tbody>
						<c:forEach var="item" items="${Cart}" varStatus="index">


							<tr class="cart-header${index.count} ">
								<td><img width="100"
									src=<c:url value="assets/user/images/products/${item.value.product.img}"/>
									alt=""></td>
								<td>${item.value.product.name}<br>${item.value.product.ml}
									ml<br>${item.value.product.volumn} %
								</td>
								<td><fmt:formatNumber type="number" maxFractionDigits="6"
										value="${item.value.product.price}" /> VNĐ</td>
								<td>${item.value.quantity}</td>
								<td><fmt:formatNumber type="number" maxFractionDigits="6"
										value="${item.value.price}" /> VNĐ</td>


							</tr>


						</c:forEach>
						<tr>

							<!--#F9D9BE  -->
							<td colspan="4"></td>
							<td style="background-color: #f17676ba; font-weight: bold">Tổng
								tiền: <fmt:formatNumber type="number" maxFractionDigits="6"
									value="${TotalPriceCart}" /> VNĐ
							</td>




						</tr>
					</tbody>
				</table>
			</div>
			<div class="register-but">

				<input type="submit" value="Thanh Toán"></input>
				<div class="clearfix"></div>

			</div>

</form:form>


		</div>
	</div>
</body>