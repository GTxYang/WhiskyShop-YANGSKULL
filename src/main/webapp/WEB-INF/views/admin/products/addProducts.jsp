<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
        $(document).ready(function() {
            $(".numbers").each(function() {
                $(this).format({format:"#,###", locale:"us"});
            });
        });
        </script>
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
					<header class="panel-heading">
						Add Product <span class="tools pull-right"> <a
							class="fa fa-chevron-down" href="javascript:;"></a> <a
							class="fa fa-cog" href="javascript:;"></a> <a class="fa fa-times"
							href="javascript:;"></a>
						</span>
					</header>
					<div class="panel-body">
						<div class="position-center ">
							<form:form modelAttribute="product" class="cmxform form-horizontal" method="post" action=""
								novalidate="novalidate" enctype="multipart/form-data">

								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Product Name</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
											<form:input path="name"  type="text" class="form-control"  />
											 <form:errors path="name" style="color:red !important" /> 
											
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Volumn</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
												
									 			<form:input path="volumn" type="text" class="form-control" value="${detailProductDTO.volumn }"/>
                                              <form:errors path="volumn" style="color:red !important" /> 
												
									
												
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Ml</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
												<form:input path="ml" type="text" class="form-control" value="${detailProductDTO.ml }" />
											   <form:errors path="ml" style="color:red !important" /> 
												<span style="color:red !important">${error }</span>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Title</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
								<form:input path="title" type="text"  class="form-control" value="${detailProductDTO.title }"/>
											<form:errors path="title" style="color:red !important" /> 
												<span style="color:red !important">${error }</span>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Origin</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
												<form:input path="origin" type="text"  class="form-control"  value="${detailProductDTO.origin }"/>
											<form:errors path="origin" style="color:red !important" /> 
												<span style="color:red !important">${error }</span>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Price</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15 " style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
												
								<form:input  path="price" type="text" class="form-control numbers" />
								
												
											<form:errors path="price" style="color:red !important" /> 
												<span style="color:red !important">${error }</span>
										</div>
									</div>
								</div>
	
									<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Detail</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
												 <form:input path="detail" type="text"  class="form-control" value="${detailProductDTO.detail }"/>
											<form:errors path="detail" style="color:red !important" /> 
												<span style="color:red !important">${error }</span>
										</div>
									</div>
								</div>


								
								
								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Sale</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
												  <form:input path="sale" type="number" class="form-control" value="${detailProductDTO.sale }"/>
												
										</div>
									</div>
								</div>
								
									<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Image</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
											 <input type="file" class="form-control" />
										
												<span style="color:red !important">${error }</span>
										</div>
									</div>
								</div>
								
									<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Brand</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
												
										<form:select class="form-control m-bot15"  path="id_brand" >
													<form:options items="${listBrand}" itemLabel="name" itemValue="id"/>
													
											</form:select>
										</div>
									</div>
								</div>
								
								
								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">Category</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
											<form:select class="form-control m-bot15"  path="id_category" >
													<form:options items="${listCate}" itemLabel="name" itemValue="id"/>
													
											</form:select>
										</div>
									</div>
								</div>

									<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">High light</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
												 <form:select class="form-control m-bot15"  path="highlight" >
													<form:options items="${listTrueFalse}" />
													
											</form:select>
												<span style="color:red !important">${error }</span>
										</div>
									</div>
								</div>
								
									<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">New Product</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
												  <form:select class="form-control m-bot15"  path="new_product" >
													<form:options items="${listTrueFalse}" />
													
											</form:select>
												<span style="color:red !important">${error }</span>
										</div>
									</div>
								</div>
								

								<div class="form-group">
									<div class="col-lg-offset-3 col-lg-6">
										<button  class="btn btn-primary" type="submit">Insert</button>
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