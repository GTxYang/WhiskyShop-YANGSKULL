


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
   	   <h3><spring:message code="Login" text="default text" /></h3>
   	   
		<div class="col-md-7 account-top">
			<span style="color:red"><h2>${message}</h2></span>
			<span style="color:red"><h2>${status}</h2></span>
		  <form:form name='loginForm'  action="${pageContext.request.contextPath}/j_spring_security_check"  method='POST' modelAttribute="user">
			<div> 	
				<span><spring:message code="UserName" text="default text" /></span>
				<form:input type='text' name='username' path="username" />
			</div>
			<div> 
				<span class="pass"><spring:message code="Password" text="default text" /></span>
				<form:input type='password' name='password' path="password" />
			</div>				
				<input type="submit" name="submit" value="<spring:message code="Login" text="default text" />" /> 
				 
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		   </form:form>
		</div>
		<div class="col-md-5 left-account ">
			<a href="/Register" class="create"><spring:message code="CreateAccount" text="default text" /></a>
			<div class="clearfix"> </div>
		</div>
	    <div class="clearfix"> </div>
	  </div>
   </div>

</body>