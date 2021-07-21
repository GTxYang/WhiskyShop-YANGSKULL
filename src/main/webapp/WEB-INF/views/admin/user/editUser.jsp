<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty status}">
		<div class="alert alert-danger">
  				<strong>${status}</strong> 
			</div>
	</c:if>
<h1>${loi }</h1>
	<div class="form-w3layouts">
		<div class="row">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> Edit User <span class="tools pull-right"> <a
							class="fa fa-chevron-down" href="javascript:;"></a> <a
							class="fa fa-cog" href="javascript:;"></a> <a class="fa fa-times"
							href="javascript:;"></a>
						</span>
					</header>
					<div class="panel-body">
						<div class="position-center ">
							<form:form class="cmxform form-horizontal" modelAttribute="user"  method="post" action="editUser" novalidate="novalidate">
							<form:hidden path="id" />
							<form:hidden path="password" />
							
							
							
							
								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">User
										name</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span> 
												<form:input path="username" type="text" class="form-control" />
												 <form:errors path="username" style="color:red !important" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Email</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white">  <i class="fa fa-envelope"></i></span> 
											<form:input path="email" type="text" class="form-control" placeholder="Username" />
											 <form:errors path="email" style="color:red !important" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">First
										name</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-italic"></i></span> 
												<form:input path="first_name" type="text" class="form-control" placeholder="Username" />
												 <form:errors path="first_name" style="color:red !important" />
										</div>
									</div>
								</div>


								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Last
										name</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-italic"></i></span> 
												<form:input path="last_name" type="text" class="form-control" placeholder="Username" />
												 <form:errors path="last_name" style="color:red !important" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Phone</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"> <i class="fa fa-phone"></i></span> 
											<form:input path="phone" type="text" class="form-control" placeholder="Username" />
											 <form:errors path="phone" style="color:red !important" />
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Address</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i class="fa fa-map-marker"></i></span>
											<form:input path="address" type="text" class="form-control" placeholder="Username" />
											 <form:errors path="address" style="color:red !important" />
										</div>
									</div>
								</div>
								
								 <div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Enable</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-power-off"></i></span>
												<form:select path="enabled" items="${enable}" class="form-control" />
										</div>
									</div>
								</div> 
						
						 <div class="form-group">
                                    <div class="col-lg-offset-3 col-lg-6">
                                        <button class="btn btn-primary" type="submit">Submit</button>
                                    </div>
                                </div>
						
							</form:form>
						</div>
					</div>
				</section>
			</div>
		</div>


	</div>
</body>
</html>