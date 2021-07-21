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
		<c:if test="${not empty status}">
		<div class="alert alert-danger">
			<strong>${status}</strong>
		</div>
	</c:if>

	<div class="form-w3layouts">
		<div class="row">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> Add Brand <span class="tools pull-right"> <a
							class="fa fa-chevron-down" href="javascript:;"></a> <a
							class="fa fa-cog" href="javascript:;"></a> <a class="fa fa-times"
							href="javascript:;"></a>
						</span>
					</header>
					<div class="panel-body">
						<div class="position-center ">
							<form:form class="cmxform form-horizontal" modelAttribute="brand"  method="post" action="" novalidate="novalidate">
								<form:input path="id" value="${item.id }"/>
								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Brand name</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span> 
												<form:input path="name" type="text" class="form-control" />
											    <form:errors path="name" style="color:red !important" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Type</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i class="fa fa-key"></i></span> 
											
											<form:select class="form-control m-bot15"  path="id_category" >
													<form:options items="${listCate}" itemLabel="name" itemValue="id"/>
													
											</form:select>
											
										
										
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Description</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i class="fa fa-key"></i></span> 
											<form:input path="description" type="text" class="form-control"  />
											 <form:errors path="description" style="color:red !important" />
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