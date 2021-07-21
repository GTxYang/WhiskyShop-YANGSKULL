<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<head>
<style>
.dropdownUser {
	position: relative;
	display: inline-block;
	width: max-content;
	cursor: pointer;
	font-weight: 200;
	background: none;
	padding: 8px 15px 5px;
	color: #fff;
}

.dropdownUser-content {
	display: none;
	position: absolute;
	background-color: #F9D9BE;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdownUser:hover .dropdownUser-content {
	display: block;
}

.dropdownUser-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdownUser:hover .dropdownUser-content {
	display: block;
}

.dropdownUser-content a:hover {
	background-color: #f1f1f1
}

form.example input[type=text] {
	padding: 10px;
	font-size: 17px;
	border: 1px solid grey;
	float: left;
	width: 80%;
	background: #f1f1f1;
}

/* Style the submit button */
form.example button {
	float: left;
	width: 20%;
	padding: 10px;
	background: #F9D9BE;
	color: white;
	font-size: 17px;
	border: 1px solid grey;
	border-left: none; /* Prevent double borders */
	cursor: pointer;
}

form.example button:hover {
	background: black;
}

/* Clear floats */
form.example::after {
	content: "";
	clear: both;
	display: table;
}
</style>


</head>
<div style="background: black">
	<div class="container">
		<div class="header_top">
			<div class="header_top_left">
				<div class="box_11">
					<a href="<c:url value="/Cart"/>">
						<h4>
							<p>
								Cart:
								<fmt:formatNumber type="number" maxFractionDigits="6"
									value="${TotalPriceCart }" />
								VNĐ (${TotalQuantyCart } items)

							</p>
							<img src="<c:url  value="/assets/user/images/bag.png"/>" alt="" />
							<div class="clearfix"></div>
						</h4>
					</a>
				</div>
				<div class="clearfix"></div>
			</div>

			<div class="header_top_right">


				<!-- ĐĂNG NHẬP RỒI -->
				<sec:authorize access="isAuthenticated()">
					<div class="lang_list">
						<div class="dropdownUser">
							<span style="display: block"> <i class="fa fa-user"
								aria-hidden="true"></i><span> Tài khoản:
									${pageContext.request.userPrincipal.name}</span>
							</span>

							<div class="dropdownUser-content">
								<a href="<c:url value="/userinfo"/>">User Information</a>
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<a href="<c:url value="/admin"/>">Admin Page</a>
								</sec:authorize>

							</div>
						</div>
					</div>

					<div class="lang_list">
						<div class="dropdownUser" style="margin-right: 20px">
							<span style="display: block"> <a style="color: white"
								href="<c:url value="/logout"/>"> <i
									class="fas fa-sign-out-alt"></i><span> Logout</span></a>
							</span>

						</div>

					</div>

				</sec:authorize>

				<!-- CHƯA ĐĂNG NHẬP -->
				<sec:authorize access="!isAuthenticated()">
					<div class="lang_list">
						<div class="dropdownUser" style="margin-right: 20px">
							<span style="display: block"> <a style="color: white"
								href="<c:url value="/Login"/>"> <i
									class="fas fa-sign-out-alt"></i><span> Login</span></a>
							</span>

						</div>

					</div> 
					<div class="lang_list">
						<div class="dropdownUser" style="margin-right: 20px">
							<span style="display: block"> <a style="color: white"
								href="<c:url value="/Register"/>"> <i class="fas fa-user-plus"></i><span> Register</span></a>
							</span>

						</div>

					</div>
				</sec:authorize>




				<!-- start search-->

				<!----//search-scripts---->
				<div class="clearfix"></div>

			</div>
			<div class="clearfix"></div>
		</div>


		<div class="header_bottom">
			<div class="logo" style="padding-left: 100px">


				<img style="display: block; margin-left: auto; margin-right: auto;"
					src="<c:url  value="/assets/user/images/yeahfinal.png"/>"
					alt="bootstrap sexy shop">

			</div>
			<div class="menu" style="padding-right: 230px">
				<ul class="megamenu skyblue">
					<c:forEach var="item" items="${menus}" varStatus="index">
						<c:if test="${index.first}">
							<li class="active grid">
						</c:if>
						<c:if test="${ not index.first}">
							<li class="">
						</c:if>

						<a class="color4" href="<c:url value="${item.url}"/>">
							${item.name}</a>
					</c:forEach>
					</li>

					<div class="clearfix"></div>
				</ul>
			</div>


			<form class="example" action="san-pham" style="margin: auto; max-width: 700px">
				<input type="text" placeholder="Search.." name="search">
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
			<div class="clearfix"></div>
		</div>
	</div>
</div>