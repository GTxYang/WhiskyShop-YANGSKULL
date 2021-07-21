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
		<div class="alert alert-success">
			<strong>${status}</strong>
		</div>
	</c:if>

	<div class="table-agile-info">
		<div class="panel panel-default">
			<div class="panel-heading">List Users</div>
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
							<th>User name</th>
							<th>Email</th>
							<th>First name</th>
							<th>Last name</th>
							<th>Phone</th>
							<th>Address</th>
							<th>Role</th>
							<th>Enabled (w/POST)</th>
							<th>Enabled (w/GET)</th>
							<th>Action</th>
							
							

							<!-- <th style="width: 30px;"></th> -->
						</tr>
					</thead>
					<tbody>
						<%-- <c:forEach var="item" items="${listUsers}">
							<h3>${item.username }</h3>
						</c:forEach> --%>

						<c:forEach var="item" items="${listUsers}">
							<tr>
								<td>${item.id }</td>
								<td><span class="text-ellipsis">${item.username }</span></td>
								<td><span class="text-ellipsis">${item.email }</span></td>
								<td>${item.first_name }</td>
								<td>${item.last_name }</td>
								<td>${item.phone }</td>
								<td>${item.address }</td>
								<td>
									
									<a class="fa fa-eye" href="user-role/${item.id}"></a>
								</td>
								<!-- <!-- - - - - - - - - - - - - - - - - - - - - -  -->  
								
								<td>
								
								<c:set var="bl"
										value="${item.enabled}" /> <c:choose>
										<c:when test="${bl == '0'}">
											<form action="Users" method="post">
												<input type="hidden" name="id" value="${item.id }"/>
												<button name="btnUnBlockUser" type="submit" class=" btn btn-success"  >UnBlock</button>
											</form>
										</c:when>

										<c:otherwise>
										<form action="Users" method="post">
												<input type="hidden" name="id" value="${item.id }"/>
												<button name="btnBlockUser" type="submit" class="btn btn-danger" >Block</button>
										</form>
										</c:otherwise>

									</c:choose>
								
								</td>
								
								<!-- <!-- - - - - - - - - - - - - - - - - - - - - - - - - - - -  --> 
								
								<td>
									<%--  ${item.enabled }--%> <c:set var="bl"
										value="${item.enabled}" /> <c:choose>
										<c:when test="${bl == '0'}">
											<a class=" btn btn-success" href="unblockuser/${item.id}"
												role="button">UnBlock</a>

										</c:when>

										<c:otherwise>
											<a class="btn btn-danger" href="blockuser/${item.id}"
												role="button">Block</a>
										</c:otherwise>

									</c:choose>
								</td>


								<td style="padding-left: 20px !important;"><a
									href="editUser?id=${item.id}" ui-toggle-class=""> <i
										style="padding-right: 7px"
										class="fa  fa-edit fa-lg text-success text-active"></i>
								</a> <a onclick="return confirm('Bạn có thực sự muốn xóa không?');"
									href="deleteUser?id=${item.id}" ui-toggle-class=""> <i
										style="font-size: 25px;"
										class="fa fa-times fa-lg text-danger text"> </i>
								</a></td>

							</tr>
						</c:forEach>

						<!-- <tr>
							<td>25</td>
							<td><span class="text-ellipsis">yang0310</span></td>
							<td><span class="text-ellipsis">howl1542@gmail.com</span></td>
							<td>Dương</td>
							<td>Gia Tiến</td>
							<td>0908163083</td>
							<td>Hòa bình tân phú</td>
							<td>1</td>
							<td style="padding-left: 20px !important;"><a href=""
								ui-toggle-class=""><i style="padding-right: 7px"
									class="fa  fa-edit fa-lg text-success text-active"
									style="padding-bottom: 6px"></i></a> <a href="" ui-toggle-class="">
									<i style="font-size: 25px;"
									class="fa fa-times fa-lg text-danger text"> </i>
							</a></td>
							 <td><a href="" class="active" ui-toggle-class=""><i
									class="fa fa-check text-success text-active"></i><i
									class="fa fa-times text-danger text"></i></a></td> 
						</tr> -->

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