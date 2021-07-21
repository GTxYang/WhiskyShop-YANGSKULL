<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<html>
<head>

<base href="${pageContext.servletContext.contextPath}/">
<style>
.errors {
    color: red;
  }
</style>

</head>

<body>


	 <div class="account-in">
   	  <div class="container">
   	     <form:form action="Register" modelAttribute="user" method="post">
   	     	
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
				 <span>User Name<label>*</label></span>
				 <form:input type="text" path="username"></form:input> 
				  <form:errors path="username" style="color:red !important" />
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
			 <div class="clearfix"> </div>
			   <a class="news-letter" href="#">
				 <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>Sign Up for Newsletter</label>
			   </a>
			 </div>
		     <div class="register-bottom-grid">
				    <h2>Thông tin đăng nhập</h2>
					 <div>
						<span>Mật khẩu<label>*</label></span>
						<form:input type="password" path="password"></form:input> 
						  <form:errors path="password" style="color:red !important" />
						  <span style="color:red !important" >${status}</span>
					 </div>
					 <div>
						<span>Nhập lại mật khẩu<label>*</label></span>
						<input id="nhaplaimatkhau" name="nhaplaimatkhau" type="password">
							<span style="color:red !important" >${errorMK}</span>
						
					 </div>
					 <div class="clearfix"> </div>
			 </div>
			 
			 <div class="clearfix"> </div>
		<div class="register-but">
		   
			   <input type="submit" value="Đăng ký"></input>
			   <div class="clearfix"> </div>
		  
		</div>
			 
		  </form:form>
		
	   </div>
   </div>
</body>

</html>

