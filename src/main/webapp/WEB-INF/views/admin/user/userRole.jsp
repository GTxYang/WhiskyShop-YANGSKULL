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






	<div class="row">

		<div class="col-lg-6">

			<div class="row">
				<div class="col-lg-12">
					<div class="table-agile-info">
						<section class="panel">
							<header class="panel-heading"> ADD ROLE </header>
							<section class="panel">
								<div class="panel-body">
								
									<c:if test="${ empty ro  }">
													<div class="alert alert-warning">
														<i class="fa fa-warning"></i><strong>     Warning!</strong> Bạn đã sở hữu tất cả các quyền rồi !!!
													</div>
									</c:if>
								
									<c:if test="${   not empty ro  }">
										<form:form modelAttribute="tt"  action="user-role/${id}" class="form-horizontal bucket-form" method="post">
											
											<div class="form-group">
												<label class="col-sm-3 control-label col-lg-3"
													for="inputSuccess">Role: </label>
												<div class="col-lg-6">
												
													<form:select class="form-control m-bot15"  path="id" >
															<form:options items="${ro}" itemLabel="name" itemValue="id"/>
													
													</form:select>
		
													<button name ="buttonAddRole" id="buttonAddRole" class="btn btn-success" type="submit">Add</button>
												</div>
											</div>
										</form:form>

									</c:if>
									
								</div>
							</section>

						</section>
					</div>
				</div>
			</div>


		</div>
		<div class="col-lg-6">
			<div class="table-agile-info">
				<div class="panel panel-default">
					<div class="panel-heading">Các Role của yang0310</div>
					<div>
						<table class="table" ui-jq="footable"
							ui-options='{
						        "paging": {
						          "enabled": true
						        },
						        "filtering": {
						          "enabled": true
						        },
						        "sorting": {
						          "enabled": true
						        }}'>
							<thead>
								<tr>
									<th>Role name</th>
									<th>Action</th>
								</tr>

							</thead>
							<tbody>
								<c:forEach var="item" items="${role }">
									<tr data-expanded="true">
										<td>${item.name }</td>
										<td>
										<form action="user-role/${id}" method="post">
											<input  type="hidden" name="idRole" value="${item.id }" />
											<button onclick="return confirm('Bạn có thực sự muốn xóa không?');" name="buttonDeleteRole" class="btn btn-danger">Delete</button>
										</form>
										
										</td>
									</tr>

								</c:forEach>


							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>