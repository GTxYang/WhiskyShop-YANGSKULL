<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
 <div  style="background:black">
   	 <div class="container">
   	 	<div class="newsletter">
			<h3 style="color:white">Newsletter</h3>
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard</p>
			<form>
			  <input type="text" value="" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
			  <input type="submit" value="SUBSCRIBE">
			</form>
		</div>
   		<div class="cssmenu" style="color:#F9D9BE">
		   <ul>
			<li class="active"><a style="color:#F9D9BE" href="#">Privacy</a></li>
			<li><a style="color:#F9D9BE" href="#">Terms</a></li>
			<li><a style="color:#F9D9BE" href="#">Shop</a></li>
			<li><a style="color:#F9D9BE" href="#">About</a></li>
			<li><a style="color:#F9D9BE" href="contact.html">Contact</a></li>
		  </ul>
		</div>
		<ul class="social">
			<li><a style="color:#F9D9BE" href=""> <i class="fa fa-facebook-square" style="font-size:48px;color:red"></i> </a></li>
			<li><a style="color:#F9D9BE" href=""><i class="fb"> </i> </a></li>
			<li><a style="color:#F9D9BE" href=""><i class="tw"> </i> </a></li>
	    </ul>
	    <div class="clearfix"></div>
	    <div class="copy">
           <p> &copy; 2015 Watches. All Rights Reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>
	 
	    </div>
   	</div>
   </div>
   
   
 



<script defer src=<c:url value="/assets/user/js/jquery.flexslider.js "/>></script>
<link rel="stylesheet" href=<c:url value="/assets/user/css/flexslider.css "/> type="text/css" media="screen" />
<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>



