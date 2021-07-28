<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="market-updates">
			<div class="col-md-3 market-update-gd">
				<div class="market-update-block clr-block-2">
					<div class="col-md-4 market-update-right">
						<i class="fa fa-eye"> </i>
					</div>
					 <div class="col-md-8 market-update-left">
					 <h4>Visitors</h4>
					<h3>${viewer}</h3>
					<p>Other hand, we denounce</p>
				  </div>
				  <div class="clearfix"> </div>
				</div>
			</div>
			<div class="col-md-3 market-update-gd">
				<div class="market-update-block clr-block-1">
					<div class="col-md-4 market-update-right">
						<i class="fa fa-users" ></i>
					</div>
					<div class="col-md-8 market-update-left">
					<h4>Users</h4>
						<h3>${quantyUser}</h3>
						<p>Other hand, we denounce</p>
					</div>
				  <div class="clearfix"> </div>
				</div>
			</div>
			<div class="col-md-3 market-update-gd">
				<div class="market-update-block clr-block-3">
					<div class="col-md-4 market-update-right">
						<i class="fa fa-usd"></i>
					</div>
					<div class="col-md-8 market-update-left">
						<h4>Sales</h4>
						<h3>  <fmt:formatNumber type="number" maxFractionDigits="6"
												value="${totalBill}" /> </h3>
						<p>Other hand, we denounce</p>
					</div>
				  <div class="clearfix"> </div>
				</div>
			</div>
			<div class="col-md-3 market-update-gd">
				<div class="market-update-block clr-block-4">
					<div class="col-md-4 market-update-right">
						<i class="fa fa-shopping-cart" aria-hidden="true"></i>
					</div>
					<div class="col-md-8 market-update-left">
						<h4>Orders</h4>
						<h3>${countBill }</h3>
						<p>Other hand, we denounce</p>
					</div>
				  <div class="clearfix"> </div>
				</div>
			</div>
		   <div class="clearfix"> </div>
		</div>	
		
		
		
<section class="wrapper">
<div class="agileits-w3layouts-stats">
					<div class="col-md-4 stats-info widget">
						<div class="calendar-widget">
                <div class="panel-heading ui-sortable-handle">
					<span class="panel-icon">
                      <i class="fa fa-calendar-o"></i>
                    </span>
                    <span class="panel-title"> Calendar </span>
                </div>
				<!-- grids -->
					<div class="agile-calendar-grid">
						<div class="page">
							
							<div class="w3l-calendar-left">
								<div class="calendar-heading">
									
								</div>
								<div class="monthly" id="mycalendar"></div>
							</div>
							
							<div class="clearfix"> </div>
						</div>
					</div>
			</div>
					</div>
					<div class="col-md-8 stats-info stats-last widget-shadow">
						<div class="stats-last-agile">
			
				<div class="table-wrapper-scroll-y my-custom-scrollbar">
							<header class="panel-heading">
								Danh sách sản phẩm sắp hết !!
								
					</header>
						<table class="table stats-table ">
							
										<thead>
											<tr>
												<th>S.NO</th>
												<th>PRODUCT</th>
												<th>STATUS</th>
												<th>In Inventory</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listWarningQuanty }" var="item" varStatus="loop">
												<tr>
													<th scope="row">${loop.index +1}</th>
													<td>${item.name }</td>
													<td>
														<c:if test="${item.quanty > 0}">
														<span class="label label-warning">Warning</span>
														</c:if>
														<c:if test="${item.quanty == 0}">
													<span class="label label-danger">Out of stock</span>
														</c:if>
							
													</td>
													<td><h4>${item.quanty} </h4></td>
												</tr>
											</c:forEach>
											
											
										</tbody>
									</table>
									</div>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
</section>
</body>
