<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Rượu nhập khẩu - YANGSKULL</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<link href="<c:url value="/assets/user/css/bootstrap.css"/>"
	rel="stylesheet" />
<!-- Customize styles -->
<link href="<c:url value="/assets/user/css/style.css"/>"
	rel="stylesheet" />
<!-- Custom Theme files -->
<!--webfont-->
<link href='//fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700'
	rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Dorsa' rel='stylesheet'
	type='text/css'>
<script type="text/javascript"
	src=<c:url value="/assets/user/js/jquery-1.11.1.min.js"/>></script>
<!-- start menu -->
<link href=<c:url value="/assets/user/css/megamenu.css"/>
	rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript"
	src=<c:url value="/assets/user/js/megamenu.js "/>></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="shortcut icon"
	href="<c:url value="/assets/user/images/favicon.ico" />">



<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<script src=<c:url value="/assets/user/js/jquery.easydropdown.js "/>></script>
<script src=<c:url value="/assets/user/js/easyResponsiveTabs.js "/>
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#horizontalTab').easyResponsiveTabs({
			type : 'default', //Types: default, vertical, accordion           
			width : 'auto', //auto or any width like 600px
			fit : true
		// 100% fit in a container
		});
	});
</script>
<script src=<c:url value="/assets/user/js/simpleCart.min.js "/>>
	
</script>


<style>



.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	max-width: 900px;
	margin: auto;
	text-align: center;
	font-family: arial;
}

.price {
	color: grey;
	font-size: 22px;
}

.card h4 {
	font-weight: bold;
}

.card button {
	border: none;
	outline: 0;
	padding: 12px;
	color: white;
	background-color: #F9D9BE;
	text-align: center;
	cursor: pointer;
	width: 100%;
	font-size: 18px;
}

.card button:hover {
	background: black
}

hr {
	width: 30%;
	background: url('assets/user/images/goatskull.jpg') no-repeat top center;
	background-size: contain;
	display: block;
	height: 18px;
	border: 0;
	position: relative;
}

hr:before, hr:after {
	content: '';
	display: block;
	position: absolute;
	background: #d7d7d7;
	height: 2px;
	top: 8px;
}

hr:before {
	left: 0;
	right: 50%;
	margin-right: 10px;
}

hr:after {
	right: 0;
	left: 50%;
	margin-left: 10px;
}
</style>
<decorator:head />
</head>

<body>


	<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>




	<decorator:body />


	</div>


	<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>






</body>


<decorator:getProperty property="page.script"></decorator:getProperty>

</html>


