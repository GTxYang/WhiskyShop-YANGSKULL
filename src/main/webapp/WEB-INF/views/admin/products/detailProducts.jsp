<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<header class="panel-heading">
						Add User <span class="tools pull-right"> <a
							class="fa fa-chevron-down" href="javascript:;"></a> <a
							class="fa fa-cog" href="javascript:;"></a> <a class="fa fa-times"
							href="javascript:;"></a>
						</span>
					</header>
					<div class="panel-body">
						<div class="position-center ">
							<form class="cmxform form-horizontal" method="post" action=""
								novalidate="novalidate">

								<div class="form-group">
									<label class="col-sm-3 control-label col-lg-3">NAME</label>
									<div class="col-lg-6">
										<div class="input-group m-bot15" style="margin-bottom: 7px;">
											<span class="input-group-addon btn-white"><i
												class="fa fa-user"></i></span>
												 <input type="text" name="name" class="form-control" />
											<%-- <form:errors path="username" style="color:red !important" /> --%>
												<span style="color:red !important">${error }</span>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="col-lg-offset-3 col-lg-6">
										<button  class="btn btn-primary" type="submit">Insert</button>
									</div>
								</div>

							</form>
							
							
						</div>
					</div>
				</section>
			</div>
		</div>


	</div>
</body>
</html>