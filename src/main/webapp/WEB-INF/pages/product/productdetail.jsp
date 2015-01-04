<%-- 
    Document   : product
    Created on : Dec 30, 2014, 10:10:17 PM
    Author     : Keshav
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">

    <!-- Mirrored from wbpreview.com/previews/WB0096211/product.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 31 Dec 2014 03:24:10 GMT -->
    <head>
        <meta charset="utf-8">
        <title>OnlineMart - Product</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Le styles -->
        <base href="<c:url value="/" />"/>
        <link href="resources/css/style.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Arvo' rel='stylesheet' type='text/css'>

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
                <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="resources/js/jquery-1.7.2.min.js" ></script>

    </head>

    <body>		
        
        <%@include file="../includes/header.jsp" %>
        <div class="container" id="main-content">
            <div class="row">
                <div class="span12">

                    <div class="span6 columns">
                        <div id="myCarousel" class="carousel slide">

                            <!-- Carousel items -->
                            <div class="carousel-inner">

                                <div class="active item">
                                    <img src="resources/img/sample/dress.jpg" alt="" class="pull-left" />
                                </div>

                                <div class="item">
                                    <img src="resources/img/sample/dress2.jpg" alt="" class="pull-left" />
                                </div>

                                <div class="item">
                                    <img src="resources/img/sample/dress3.jpg" alt="" class="pull-left" />
                                </div>

                            </div>

                            <!-- Carousel nav -->
                            <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                            <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
                        </div>
                    </div>

                    <div class="span5">
                        <div class="productinfo">
                            <h2>${product.productName}</h2>
                            <h4>By: Brand Name</h4>

                            <div class="prices">
                                <div class="price">${product.unitPrice}</div>
                                <div class="retailprice">Retail Price: $79</div>
                            </div>


                            <form class="well form-inline">
                                <label class="control-label">Size</label>
                                <select class="span1">
                                    <option>S</option>
                                    <option>M</option>
                                    <option>L</option>
                                </select>

                                <label class="control-label">Quantity</label>
                                <select class="span1">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                </select>

                                <a href="<c:url value="/product/productlist" />"  class="btn btn-danger btn-large"><i class="icon-shopping-cart icon-white"></i>  Add to Cart</a>
                                
                                <script>
                                    $('#SmartCart').smartCart({productItemTemplate: productTemplateWithSKU});
                                </script>
                                
                                
                            </form>

                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut interdum placerat elementum. Pellentesque faucibus tristique lectus ut commodo. Vivamus at odio eu turpis aliquam pellentesque eu vel orci. Suspendisse ac sapien augue. Donec vitae ipsum ut nulla adipiscing laoreet. 
                            </p>	

                            <div class="social">
                                <img src="resources/img/sample/emailbutton.png" alt=""  /><img src="resources/img/sample/likebutton.png" alt="" /><img src="resources/img/sample/pinbutton.png" alt=""  /><img src="resources/img/sample/tweetbutton.png" alt="" />
                            </div>

                            <div class="producttabs"> 
                                <div class="tabbable"> 
                                    <ul class="nav nav-tabs">
                                        <li class="active"><a href="#tab1" data-toggle="tab">Description</a></li>
                                        <li><a href="#tab2" data-toggle="tab">Shipping</a></li>
                                        <li><a href="#tab3" data-toggle="tab">Reviews</a></li>
                                    </ul>

                                    <div class="tab-content">
                                        <div class="tab-pane active" id="tab1">
                                            <p>
                                                Vestibulum dapibus enim nunc. Nunc suscipit, turpis at condimentum rutrum, nisl nibh varius ligula, vitae aliquam orci lacus ut ligula. Nunc varius, mi vel lacinia elementum, odio magna euismod sapien, quis facilisis mauris mi a urna. Aenean purus lectus, semper eget laoreet eget, suscipit et nisi.
                                            </p>
                                        </div>
                                        <div class="tab-pane" id="tab2">
                                            <p>
                                                Proin commodo mi quis metus sodales luctus. Sed mattis vulputate sapien, sed bibendum odio luctus et. Maecenas eleifend, nulla vitae pharetra porttitor, elit purus pellentesque lectus, sit amet porttitor nibh nisl id lectus.
                                            </p>
                                        </div>
                                        <div class="tab-pane" id="tab3">
                                            <p>
                                                Duis faucibus facilisis dui sed volutpat. Nam id lorem at velit bibendum vulputate. Curabitur rhoncus adipiscing justo, nec porttitor nunc sagittis non. Nam pellentesque mi in mauris pulvinar volutpat sit amet ut enim. Integer neque orci, blandit eget luctus ac, vulputate at lectus.
                                            </p>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



                <div class="headtitle">
                    <h4>RELATED PRODUCTS</h4>	
                </div>

                <ul class="product">
                    <li>
                        <a href="product.html">
                            <img src="resources/img/sample/women1.jpg" alt="" />	
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
                            <img src="resources/img/sample/women2.jpeg" alt="" />	
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
                            <img src="resources/img/sample/women3.jpg" alt="" />	
                            <div class="producttitlebox"></div>
                            <div class="producttitle">Summer Dress</div>
                            <div class="brandtitle">By: Brand Name</div>
                            <div class="pricetag"></div>
                            <div class="saleprice">$59</div>
                            <div class="oldprice">$39</div>
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
                            <li><a href="http://www.facebook.com/"><img src="resources/img/icons/facebook.png"  width="30" height="30" alt="" /></a>  <a href="http://www.twitter.com/"><img src="resources/img/icons/twitter.png"  width="30" height="30" alt="" /></a>  <a href="http://www.pinterest.com/"><img src="resources/img/icons/pinterest.png"  width="30" height="30" alt="" /></a>  <a href="http://www.flickr.com/"><img src="resources/img/icons/flickr.png"  width="30" height="30" alt="" /></a>   <a href="http://www.google.com/"><img src="resources/img/icons/googleplus.png"  width="30" height="30" alt="" /></a></li>
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

    <!-- Mirrored from wbpreview.com/previews/WB0096211/product.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 31 Dec 2014 03:24:13 GMT -->
</html>
