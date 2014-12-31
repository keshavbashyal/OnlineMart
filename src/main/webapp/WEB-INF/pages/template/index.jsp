<%-- 
    Document   : index.jsp
    Created on : Dec 30, 2014, 9:48:25 PM
    Author     : Keshav
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>
<!DOCTYPE html>

<html lang="en">
	
<!-- Mirrored from wbpreview.com/previews/WB0096211/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 31 Dec 2014 03:22:43 GMT -->
<head>
		<meta charset="utf-8">
		<title>FASHION STORE YEs</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- Le styles -->
                <base href="<c:url value="/" />"/>
		<link href="css/style.css" rel="stylesheet">

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
					<h1 id="logo" class="span4"><a href="index.jsp" title="Fashion Store">FASHION STORE</a></h1>
					
										
					<nav class="span8" id="navigation">
					
					<div class="accountbox">
					
					<div class="span4">
		<div class="navbar navbar-static">
		<ul class="nav">
		<li><a href="cart.jsp"><i class="icon-shopping-cart"></i> Shopping Cart</a></li>
		<li class="divider-vertical"></li>
		<li><a href="account.jsp"><i class="icon-user"></i> My Account</a></li>
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
                      <li><a href="listwomen.jsp">Dresses</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.jsp">Tops</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.jsp">Suits</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.jsp">Jeans</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.jsp">Swim</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.jsp">Jewelry</a></li>
                      <li class="divider"></li>
                      <li><a href="listwomen.jsp">Beauty</a></li>
                    </ul>
                  </li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">MENS <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="listmen.jsp">Shirts</a></li>
                      <li class="divider"></li>
                      <li><a href="listmen.jsp">Jeans</a></li>
                      <li class="divider"></li>
                      <li><a href="listmen.jsp">Suits</a></li>
                      <li class="divider"></li>
                      <li><a href="listmen.jsp">Shoes</a></li>
                      <li class="divider"></li>
                      <li><a href="listmen.jsp">Swim</a></li>
                      <li class="divider"></li>
                      <li><a href="listmen.jsp">Active</a></li>
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
		
		
		
		
<div id="main-carousel">
		
<div class="slides_container container">

<div class="span8columns">
<div id="myCarousel" class="carousel slide">

<!-- Carousel items -->

<div class="carousel-inner">

<div class="active item">
<img src="img/main-carousel/women1.jpg" alt="" class="pull-left" />
<div class="shading-left">
<h2>Find Yourself in Fashion</h2>
<p>Use a different overlay depending on what best meets your needs. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In laoreet sodales velit id interdum. Aliquam mattis dui quis nibh commodo vel pretium leo condimentum. Nam sit amet est leo, sed consequat augue.</p>
<a class="btn btn-large btn-danger" href="listwomen.html">Find it Now</a>
</div>
<div class="numberslide">1/3</div>
</div>


<div class="item">
<img src="img/main-carousel/women2.jpg" alt="" class="pull-left" />
<div class="shading-left">
<h2>The New Face of Beauty</h2>
<p>Use a different overlay depending on what best meets your needs. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In laoreet sodales velit id interdum. Aliquam mattis dui quis nibh commodo vel pretium leo condimentum. Nam sit amet est leo, sed consequat augue.</p>
<a class="btn btn-large btn-danger" href="listwomen.html">Discover Now</a>
</div>
<div class="numberslide">2/3</div>
</div>

<div class="item">
<img src="img/main-carousel/men1.jpg" alt="" class="pull-left" />
<div class="shading-left">
<h2>Discover Top Fashion</h2>
<p>Use a different overlay depending on what best meets your needs. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In laoreet sodales velit id interdum. Aliquam mattis dui quis nibh commodo vel pretium leo condimentum. Nam sit amet est leo, sed consequat augue.</p>
<a class="btn btn-large btn-danger" href="listmen.html">Shop Now</a>
</div>
<div class="numberslide">3/3</div>
</div>

</div>
<!-- Carousel nav -->
<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
</div>
</div>
				
</div>
</div>
		

		
<div class="container" id="main-content">
<div class="row" id="featured">		

<div class="sale">
<div class="span6">
<div class="sale1">
<div class="salebanner">
<a href="listwomen.html"><img src="img/sample/sale.jpg" alt="" />
<p class="sale1">Purse Sale </p></a>
</div>
</div>
</div>

<div class="span6">
<div class="sale2">
<a href="product.html"><img src="img/sample/sale2.jpg" alt=""/>
<p class="sale2">Fab heels </p></a>
</div>
</div>
</div>
				
<br/>				
<div class="headtitle">
<h4>FEATURED WOMENS</h4>	
</div>

<ul class="product">
<li>
<a href="product.html">
<img src="img/sample/women1.jpg" alt="" />	
<div class="producttitlebox"></div>
<div class="producttitle">Women's Dress</div>
<div class="brandtitle">By: Brand Name</div>
<div class="pricetag"></div>
<div class="saleprice">$80</div>
<div class="oldprice">$50</div>
</a>
</li>

<li>
<a href="product.html">
<img src="img/sample/women2.jpeg" alt="" />	
<div class="producttitlebox"></div>
<div class="producttitle">Bright Dress</div>
<div class="brandtitle">By: Brand Name</div>
<div class="pricetag"></div>
<div class="saleprice">$130</div>
<div class="oldprice">$89</div>
</a>
</li>

<li>
<a href="product.html">
<img src="img/sample/women3.jpg" alt="" />	
<div class="producttitlebox"></div>
<div class="producttitle">Summer Dress</div>
<div class="brandtitle">By: Brand Name</div>
<div class="pricetag"></div>
<div class="saleprice">$59</div>
<div class="oldprice">$39</div>
</a>
</li>
</ul>


<div class="headtitle">
<h4>FEATURED MENS</h4>	
</div>

<ul class="product">

<li>
<a href="product.html">
<img src="img/sample/men1.jpg" alt="" />	
<div class="producttitlebox"></div>
<div class="producttitle">Men's Suit</div>
<div class="brandtitle">By: Brand Name</div>
<div class="pricetag"></div>
<div class="saleprice">$430</div>
<div class="oldprice">$200</div>
</a>
</li>

<li>
<a href="product.html">
<img src="img/sample/men2.jpg" alt="" />	
<div class="producttitlebox"></div>
<div class="producttitle">Suit Jacket</div>
<div class="brandtitle">By: Brand Name</div>
<div class="pricetag"></div>
<div class="saleprice">$190</div>
<div class="oldprice">$140</div>
</a>
</li>

<li>
<a href="product.html">
<img src="img/sample/men3.jpg" alt="" />	
<div class="producttitlebox"></div>
<div class="producttitle">Army Jacket</div>
<div class="brandtitle">By: Brand Name</div>
<div class="pricetag"></div>
<div class="saleprice">$210</div>
<div class="oldprice">$170</div>
</a>
</li>

</ul>
					
<div class="headtitle">
<h4>FEATURED KIDS</h4>	
</div>

<ul class="product">

<li>
<a href="product.html">
<img src="img/sample/kids1.jpg" alt="" />	
<div class="producttitlebox"></div>
<div class="producttitle">Girls Summer Dress</div>
<div class="brandtitle">By: Brand Name</div>
<div class="pricetag"></div>
<div class="saleprice">$80</div>
<div class="oldprice">$40</div>
</a>
</li>

<li>
<a href="product.html">
<img src="img/sample/kids2.jpg" alt="" />	
<div class="producttitlebox"></div>
<div class="producttitle">Boys Sweater</div>
<div class="brandtitle">By: Brand Name</div>
<div class="pricetag"></div>
<div class="saleprice">$50</div>
<div class="oldprice">$35</div>
</a>
</li>

<li>
<a href="product.html">
<img src="img/sample/kids3.jpg" alt="" />	
<div class="producttitlebox"></div>
<div class="producttitle">Girls Summer Dress</div>
<div class="brandtitle">By: Brand Name</div>
<div class="pricetag"></div>
<div class="saleprice">$60</div>
<div class="oldprice">$30</div>
</a>
</li>

</ul>					

					
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
