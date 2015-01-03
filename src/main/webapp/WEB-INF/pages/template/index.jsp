<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>OnlineMart - Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <base href="<c:url value="/" />"/>
        <link href="resources/css/style.css" rel="stylesheet">

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
                <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        

    </head>

    <body>

        <%@include file="../includes/header.jsp" %>
        <div class="container">
            <div class="pull-right">
                <a href="<c:url value='/vendor/form'/>" class="btn btn-success btn-small">Sign Up as Vendor</a>
                <a href="<c:url value='/customer/addCustomer'/>" class="btn btn-success btn-small">Sign Up as Customer</a>
                <a href="<c:url value='/vendor/productform'/>" class="btn btn-success btn-small">Add a Product</a>
                <a href="<c:url value='/login'/>" class="btn btn-success btn-small">Login</a>
                
            </div>
        </div>
        <div id="main-carousel">
            <div class="slides_container container">
                <div class="span8columns">
                    <div id="myCarousel" class="carousel slide">
                        <!-- Carousel items -->
                        <div class="carousel-inner">
                            <div class="active item">
                                <img src="resources/img/main-carousel/women1.jpg" alt="" class="pull-left" />
                                <div class="shading-left">
                                    <h2>Find Yourself in Fashion</h2>
                                    <p>Use a different overlay depending on what best meets your needs. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In laoreet sodales velit id interdum. Aliquam mattis dui quis nibh commodo vel pretium leo condimentum. Nam sit amet est leo, sed consequat augue.</p>
                                    <a class="btn btn-large btn-danger" href="listwomen.html">Find it Now</a>
                                </div>
                                <div class="numberslide">1/3</div>
                            </div>
                            <div class="item">
                                <img src="resources/img/main-carousel/women2.jpg" alt="" class="pull-left" />
                                <div class="shading-left">
                                    <h2>The New Face of Beauty</h2>
                                    <p>Use a different overlay depending on what best meets your needs. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In laoreet sodales velit id interdum. Aliquam mattis dui quis nibh commodo vel pretium leo condimentum. Nam sit amet est leo, sed consequat augue.</p>
                                    <a class="btn btn-large btn-danger" href="listwomen.html">Discover Now</a>
                                </div>
                                <div class="numberslide">2/3</div>
                            </div>
                            <div class="item">
                                <img src="resources/img/main-carousel/men1.jpg" alt="" class="pull-left" />
                                <div class="shading-left">
                                    <h2>Discover Top Fashion</h2>
                                    <p>Use a different overlay depending on what best meets your needs. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In laoreet sodales velit id interdum. Aliquam mattis dui quis nibh commodo vel pretium leo condimentum. Nam sit amet est leo, sed consequat augue.</p>
                                    <a class="btn btn-large btn-danger" href="listmen.html">Shop Now</a>
                                </div>
                                <div class="numberslide">3/3</div>
                            </div>
                        </div>
                        <!-- Carousel nav -->
                        <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
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
                                <a href="listwomen.html"><img src="resources/img/sample/sale.jpg" alt="" />
                                    <p class="sale1">Purse Sale </p></a>
                            </div>
                        </div>
                    </div>

                    <div class="span6">
                        <div class="sale2">
                            <a href="product.html"><img src="resources/img/sample/sale2.jpg" alt=""/>
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


                <div class="headtitle">
                    <h4>FEATURED MENS</h4>	
                </div>

                <ul class="product">

                    <li>
                        <a href="product.html">
                            <img src="resources/img/sample/men1.jpg" alt="" />	
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
                            <img src="resources/img/sample/men2.jpg" alt="" />	
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
                            <img src="resources/img/sample/men3.jpg" alt="" />	
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
                            <img src="resources/img/sample/kids1.jpg" alt="" />	
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

        <%@include file="../includes/footer.jsp" %> %>
    </body>

</html>