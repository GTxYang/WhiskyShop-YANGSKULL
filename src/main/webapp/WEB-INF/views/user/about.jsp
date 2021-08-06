<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> hello : <spring:message code="hello" text="default text" /></h1>
Current Locale : ${pageContext.response.locale}
	<div class="container">
		<div class="row">
			<div class="col-sm-4" style="margin-top: 20px; margin-bottom: 20px;">
				<img src="<c:url value="/assets/user/images/goatskull.jpg" />"
					alt="Denim Jeans"
					style="width: 100%; border-radius: 25px; padding-bottom: 10px">
				<img src="<c:url value="/assets/user/images/goatskull.jpg" />"
					alt="Denim Jeans" style="width: 100%; border-radius: 25px;">
			</div>
			<div class="col-sm-8">
				<div style="background-color: gray; radius: 50%; width: 100%">
					<div id="infoProject">
						<h1>PROJECT INFORMATION</h1>
						<h4>Start: 01-06-2021</h4> <h4>Technology: </h4>
						<ul>
							<li>XAMPP(PHPAdmin) - MySQl</li>
							<li>Spring MVC</li>
						</ul>
					</div>
					<div id="infoAuthor">
						<h1>AUTHOR</h1>
						<h4><i class="glyphicon glyphicon-name"></i>Name: DUONG GIA TIEN</h4>
						<h4><i class="glyphicon glyphicon-phone"></i>Phone : 0908163083</h4>
						<h4><i class="glyphicon glyphicon-envelope"></i> Email : Howl1542@gmail.com</h4>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>