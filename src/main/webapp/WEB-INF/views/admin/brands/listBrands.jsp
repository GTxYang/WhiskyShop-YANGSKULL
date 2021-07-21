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
		<div class="alert alert-success">
			<strong>${status}</strong>
		</div>
	</c:if>
	<c:if test="${not empty error}">
		<div class="alert alert-danger">
			<strong>${error}</strong>
		</div>
	</c:if>



	<div class="table-agile-info">
		<div class="panel panel-default">
			<div class="panel-heading">List Brands</div>
			<div class="row w3-res-tb">

				<div class="col-sm-5 m-b-xs"></div>
				<div class="col-sm-4"></div>
				<div class="col-sm-3">
					<div class="input-group">
						<input type="text" class="input-sm form-control"
							placeholder="Search"> <span class="input-group-btn">
							<button class="btn btn-sm btn-default" type="button">Go!</button>
						</span>
					</div>
				</div>

			</div>
			<div class="table-responsive">
				<table class="table table-striped b-t b-light">
					<thead>
						<tr>

							<th>ID</th>
							<th>Brand Name</th>
							<!-- <th>id_category</th> -->
							<th>Description</th>
							<th>Type of Wine</th>

						</tr>
					</thead>
					<tbody>


						<c:forEach var="item" items="${listBrandsDTO}">
							<tr>
								<td>${item.idbrand }</td>
								<td><span class="text-ellipsis">${item.namebrand }</span></td>
								<%-- <td>${item.id_category }</td> --%>
								<td>${item.description }</td>
								<td>${item.namecate }</td>
								<td style="padding-left: 20px !important;"><a
									href="editBrand?id=${item.idbrand }"> <i
										style="padding-right: 7px"
										class="fa  fa-edit fa-lg text-success text-active"></i>
								</a> 
								
									
								
								<a onclick="return confirm('Bạn có thực sự muốn xóa không?');"
									href="deleteBrand?idBrand=${item.idbrand }"> <i
										style="font-size: 25px;"
										class="fa fa-times fa-lg text-danger text"> </i>
								</a>
								</td> 

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
			<footer class="panel-footer">
				<div class="row">

					<div class="col-sm-5 text-center">
						<small class="text-muted inline m-t-sm m-b-sm">showing
							20-30 of 50 items</small>
					</div>
					<div class="col-sm-7 text-right text-center-xs">
						<ul class="pagination pagination-sm m-t-none m-b-none">
							<li><a href=""><i class="fa fa-chevron-left"></i></a></li>
							<li><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">4</a></li>
							<li><a href=""><i class="fa fa-chevron-right"></i></a></li>
						</ul>
					</div>
				</div>
			</footer>
		</div>
	</div>
</body>
</html>