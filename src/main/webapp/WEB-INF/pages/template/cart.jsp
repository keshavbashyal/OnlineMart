<%-- 
    Document   : cart
    Created on : Dec 30, 2014, 10:07:40 PM
    Author     : Keshav
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">
	
<!-- Mirrored from wbpreview.com/previews/WB0096211/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 31 Dec 2014 03:23:52 GMT -->
<head>
		<meta charset="utf-8">
		<title>FASHION STORE</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">
                <base href="<c:url value="/" />"/>

		<!-- Le styles -->
		<link href="resources/css/style.css" rel="stylesheet">
		<script src="resources/js/bootstrap-carousel.js" ></script> 

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
					<h2>Your Shopping Cart</h2>
					</div>
					
		<div class="span11">			
	<table class="table">
  <thead>	
  </thead>
  <tbody>
    <tr>
      <td><img src="img/sample/dress.jpg" alt="" class="pull-leftcheckout" />
      <button type="submit" class="btn">Remove</button>
</td>
      <td><h3>Dior Home Pop-up Shop in Chelsea Market</h3></td>
      
      <td><label class="control-label">Size:</label>
<select class="span1">
<option>S</option>
<option>M</option>
<option>L</option>
</select></td>

<td>
<label class="control-label">Quantity:</label>
<select class="span1">
<option>1</option>
<option>2</option>
<option>3</option>
</select>
</td>
<td>Price:<br><div class="price">$49</div>
</td>
</tr>
</tbody>
</table>

<div class="totalprice">
<div class="price">Total Price: $49</div>
</div>

<div class="couponcode">
<div class="input-prepend">
<span class="add-on"><i class="icon-tag"></i></span><input class="span2" placeholder="Coupon Code" size="16" type="text">
</div>	
</div>

<button type="submit" class="btn btn-large btn-danger">Checkout</button>
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
							<li><a href="http://www.facebook.com/"><img src="resources/img/icons/facebook.png"  width="30" height="30" alt="" /></a>  
                                                            <a href="http://www.twitter.com/"><img src="resources/img/icons/twitter.png"  width="30" height="30" alt="" /></a>  
                                                            <a href="http://www.pinterest.com/"><img src="resources/img/icons/pinterest.png"  width="30" height="30" alt="" /></a> 
                                                            <a href="http://www.flickr.com/"><img src="resources/img/icons/flickr.png"  width="30" height="30" alt="" /></a>  
                                                            <a href="http://www.google.com/"><img src="resources/img/icons/googleplus.png"  width="30" height="30" alt="" /></a></li>
						</ul>
					</div>
					<div class="span4">
						<b>Learn more about us</b>
						<ul class="footer">
							<li><a href="about.jsp">About</a></li>
							<li><a href="contact.jsp">Contact Us</a></li>
							<li><a href="landing.jsp">Landing Page</a></li>
							<li><a href="account.jsp">My Account</a></li>
							<li><a href="product.jsp">Product Page</a></li>
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

<!-- Mirrored from wbpreview.com/previews/WB0096211/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 31 Dec 2014 03:23:53 GMT -->
</html>