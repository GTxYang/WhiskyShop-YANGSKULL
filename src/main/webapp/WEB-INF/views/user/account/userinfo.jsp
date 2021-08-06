<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${status}</h1>
	<div class="account-in">
		<div class="container">
			<div>
				<span>User Name<label>*</label></span> <input type="text"
					value="${userinfo.username }"></input>

			</div>
			<form:form modelAttribute="userinfo" method="post" action="">
					<form:input type="hidden" path="id" />
					<form:input type="hidden" path="password" />
					<form:input type="hidden" path="username" />
					<form:input type="hidden" path="enabled" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<div class="register-top-grid">
					<h2>Thông tin cá nhân</h2>
					<div>
						<span>Họ<label>*</label></span>
						<form:input type="text" path="first_name"></form:input>
						<form:errors path="first_name" style="color:red !important" />
					</div>
					<div>
						<span>Tên<label>*</label></span>
						<form:input type="text" path="last_name"></form:input>
						<form:errors path="last_name" style="color:red !important" />
					</div>
					<div>
						<span>Email<label>*</label></span>
						<form:input type="email" path="email"></form:input>
						<form:errors path="email" style="color:red !important" />
					</div>

					<div>
						<span>Số điện thoại<label>*</label></span>
						<form:input type="text" path="phone"></form:input>
						<form:errors path="phone" style="color:red !important" />
					</div>
					<div>
						<span>Địa chỉ<label>*</label></span>
						<form:input type="text" path="address"></form:input>
						<form:errors path="address" style="color:red !important" />
					</div>
					
					<div class="clearfix"></div>

				</div>
					<button value="submit">udpate</button>
			</form:form>
			
		</div>
	</div>
</body>
</html>