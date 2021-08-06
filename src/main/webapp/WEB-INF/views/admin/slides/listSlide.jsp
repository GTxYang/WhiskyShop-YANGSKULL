<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>c
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
			<div class="panel-heading">List Slide</div>
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
							<th>Caption</th>
							<th>Content</th>
							<th>Image</th>

						</tr>
					</thead>
					<tbody>


						<c:forEach var="item" items="${listSlide}">
							<tr>
								<td>${item.id }</td>
								<td><span class="text-ellipsis">${item.caption }</span></td>
								<td><span class="text-ellipsis">${item.content }</span></td>
								<td><span class="text-ellipsis"><img style="width: 100%; height: 400px"
							src=<c:url value="/assets/user/images/slide/${item.img}"/>
							alt="bootstrap ecommerce templates" /></span></td>

								<td style="padding-left: 20px !important;"><a
									href="editSlide?id=${item.id}"> <i
										style="padding-right: 7px"
										class="fa  fa-edit fa-lg text-success text-active"></i>
								</a>


									<form action="deleteSlide" method="post">
										<input id="id" name="id" value="${item.id}" type="hidden" />
										<button
											onclick="return confirm('Bạn có thực sự muốn xóa không?');"
											style="padding: 0; border: none; background: none;"
											class="fa fa-times fa-lg text-danger text"></button>
									</form></td>


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