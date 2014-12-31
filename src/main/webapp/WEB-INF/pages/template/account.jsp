<%-- 
    Document   : account.jsp
    Created on : Dec 30, 2014, 10:06:53 PM
    Author     : Keshav
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>

<html lang="en">
	
<!-- Mirrored from wbpreview.com/previews/WB0096211/account.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 31 Dec 2014 03:23:53 GMT -->
<head>
		<meta charset="utf-8">
		<title>FASHION STORE</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- Le styles -->
		<link href="css/style.css" rel="stylesheet">
		<script src="js/bootstrap-carousel.js" ></script> 

		<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<script src="js/jquery-1.7.2.min.js" ></script>
		
</head>

	<body>
		
			<header>
			<div class="container">
				<div class="row">
					<h1 id="logo" class="span4"><a href="index.html" title="Fashion Store">FASHION STORE</a></h1>
					
										
					<nav class="span8" id="navigation">
					
					<div class="accountbox">
					
					<div class="span4">
		<div class="navbar navbar-static">
		<ul class="nav">
		<li><a href="cart.html"><i class="icon-shopping-cart"></i> Shopping Cart</a></li>
		<li class="divider-vertical"></li>
		<li><a href="account.html"><i class="icon-user"></i> My Account</a></li>
		</ul>
		</div>
		</div>
					
					
								
              		</div>
					</nav>
				</div>
			</div>
			</header>
			
			<div class="row">
			<div class="subnav">	
			<div class="container">
			<div class="navlist">
			<nav class="span8">	
			 <div id="navbar" class="navbar navbar-static">
              <div class="span8">
                <ul class="nav">
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">WOMENS <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="listwomen.html">Dresses</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.html">Tops</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.html">Suits</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.html">Jeans</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.html">Swim</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.html">Jewelry</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.html">Beauty</a></li>
                    </ul>
                  </li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">MENS <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="listmen.html">Shirts</a></li>
                      <li class="divider"></li>
                      <li><a href="listmen.html">Jeans</a></li>
                      <li class="divider"></li>
                      <li><a href="listmen.html">Suits</a></li>
                      <li class="divider"></li>
                      <li><a href="listmen.html">Shoes</a></li>
                      <li class="divider"></li>
                      <li><a href="listmen.html">Swim</a></li>
                      <li class="divider"></li>
                      <li><a href="listmen.html">Active</a></li>
                      <li class="divider"></li>
                      <li><a href="listmen.html">Polos</a></li>
                    </ul>
                  </li>
                   <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">KIDS <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="listwomen.html">Shirts</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.html">Jeans</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.html">Dresses</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.html">Shoes</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.html">Swim</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.html">Active</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.html">Polos</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
            </div>
            </nav>
		</div>
		       
		<div class="searchbox">       
		<div class="input-prepend">
		<span class="add-on"><i class="icon-search"></i></span><input class="span3" data-provide="typeahead" placeholder="Search" id="prependedInput" size="16" type="text" data-source='["Womens Dresses", "Womens Tops", "Womens Suites", "Womens Jeans", "Womens Swim", "Womens Jewelry", "Womens Beauty", "Mens Shirts", "Mens Jeans", "Mens Suits", "Mens Shoes", "Mens Swim", "Mens Active", "Mens polos", "Kids Shirts", "Kids Jeans", "Kids Dresses", "Kids Shoes", "Kids Swim", "Kids Active", "Kids Polos"]'>
        </div>	
        </div>	
		</div>
		</div>
		</div>
		
		
		<div class="container" id="main-content">

			<div class="row">


				<div class="span12">
				<div class="categorybox">
				<div class="headtitle">
					<h2>My Account</h2>
					</div>
					
<div class="span6">			
<div class="logininfo">		
</div>
	<b>Sign into your account</b>
<div class="input-prepend">
<span class="add-on"><i class="icon-envelope"></i></span><input class="span3" placeholder="Your Email" size="16" type="text">
</div>	
<div class="input-prepend">
<span class="add-on"><i class="icon-lock"></i></span><input class="span3" placeholder="Your Password" size="16" type="text">
</div>	
<button type="submit" class="btn">Sign in</button>
</div>
			
					<div class="span5">	
					<b>Create your account</b>
<div class="input-prepend">
<span class="add-on"><i class="icon-user"></i></span><input class="span3" placeholder="Your Name" size="16" type="text">
</div>	
<div class="input-prepend">
<span class="add-on"><i class="icon-envelope"></i></span><input class="span3" placeholder="Your Email" size="16" type="text">
</div>	
<div class="input-prepend">
<span class="add-on"><i class="icon-lock"></i></span><input class="span3" placeholder="Your Password" size="16" type="text">
</div>	
<div class="input-prepend">
<span class="add-on"><i class="icon-lock"></i></span><input class="span3" placeholder="Confirm Password" size="16" type="text">
</div>	
     			<button type="submit" class="btn">Create Account</button>
			</div>
			
					
		
			
				</div>
				</div>
			</div>
		</div>
		
	<footer>
			<div class="container">
				<div class="row">
				<div class="span4">
						<b>Socialize with us</b>
						<ul class="footer">
							<li><a href="http://www.facebook.com/"><img src="img/icons/facebook.png"  width="30" height="30" alt="" /></a>  <a href="http://www.twitter.com/"><img src="img/icons/twitter.png"  width="30" height="30" alt="" /></a>  <a href="http://www.pinterest.com/"><img src="img/icons/pinterest.png"  width="30" height="30" alt="" /></a>  <a href="http://www.flickr.com/"><img src="img/icons/flickr.png"  width="30" height="30" alt="" /></a>   <a href="http://www.google.com/"><img src="img/icons/googleplus.png"  width="30" height="30" alt="" /></a></li>
						</ul>
					</div>
					<div class="span4">
						<b>Learn more about us</b>
						<ul class="footer">
							<li><a href="about.html">About</a></li>
							<li><a href="contact.html">Contact Us</a></li>
							<li><a href="landing.html">Landing Page</a></li>
							<li><a href="account.html">My Account</a></li>
							<li><a href="product.html">Product Page</a></li>
						</ul>
					</div>
					
					<div class="span4">
						<b>Newsletter</b>
						<p>Sign up for our newsletter and receive exclusive offers</p>
						<form class="wellclear form-inline">
  						<input type="text" class="input-large" placeholder="Email">
  						<button type="submit" class="btn btn-danger">Sign up</button>
                 </form>
					</div>
				</div>
			</div>
		</footer>
		
   <script src="js/bootstrap-transition.js"></script>
    <script src="js/bootstrap-alert.js"></script>
    <script src="js/bootstrap-modal.js"></script>
    <script src="js/bootstrap-dropdown.js"></script>
    <script src="js/bootstrap-scrollspy.js"></script>
    <script src="js/bootstrap-tab.js"></script>
    <script src="js/bootstrap-tooltip.js"></script>
    <script src="js/bootstrap-popover.js"></script>
    <script src="js/bootstrap-button.js"></script>
    <script src="js/bootstrap-collapse.js"></script>
    <script src="js/bootstrap-carousel.js"></script>
    <script src="js/bootstrap-typeahead.js"></script>
	</body>

</html>
