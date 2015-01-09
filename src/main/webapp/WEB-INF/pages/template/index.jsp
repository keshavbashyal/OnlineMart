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
        
        <div id="main-carousel">
            <div class="slides_container container">
                <div class="span8columns">
                    <div id="myCarousel" class="carousel slide">
                        <!-- Carousel items -->
                        <div class="carousel-inner">
                            <div class="active item">
                                <img src="resources/img/main-carousel/watch.jpg" alt="" class="pull-left" />
                                <div class="shading-left">
                                    <h2>The best quality watches in the planet</h2>
                                    <p>Online Mart provides you the best watches in the planet on a reasonable price. Brand watches include Omega, Bvlgari, Rolex, Taguer and Swiss</p>
                                    <a class="btn btn-large btn-danger" href="product/productlist">Find it Now</a>
                                </div>
                                <div class="numberslide">1/3</div>
                            </div>
                            <div class="item">
                                <img src="resources/img/main-carousel/tie.jpg" alt="" class="pull-left" />
                                <div class="shading-left">
                                    <h2>Designer Tie</h2>
                                    <p>Shop a variety of ties. Designer ties available in Online Mart are sure to satisfy your needs. And talk about the prices....cheapest on the planet</p>
                                    <a class="btn btn-large btn-danger" href="listwomen.html">Discover Now</a>
                                </div>
                                <div class="numberslide">2/3</div>
                            </div>
                            <div class="item">
                                <img src="resources/img/main-carousel/shoes.jpg" alt="" class="pull-left" />
                                <div class="shading-left">
                                    <h2>Your stop for shoes</h2>
                                    <p>Explore the feeling of that pricey shoes on your feet..for a low price. Get everything from adidas, Nike to Puma</p>
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
                <br/>				
                <div class="headtitle">
                    <h4>FEATURED ITEMS</h4>	
                </div>
  <ul class="product">
                    
                    <c:forEach items="${products}" var="product">
                    <li>
                        <a href="<c:url value="/product/${product.id}/productdetail"/>">
                            <img  width="300" height="200" src="productImage/${product.id}" alt="hi its me" />	
                            <div class="producttitlebox"></div>
                            <div class="producttitle">${product.productName}</div>
                            <div class="brandtitle">By: Brand Name</div>
                            <div class="pricetag"></div>
                            <div class="saleprice">${product.unitPrice}</div>
                            <div class="oldprice">${product.unitPrice}</div>
                        </a>
                    </li>
                    
                    </c:forEach>
                </ul>
            </div>
        </div>

        <%@include file="../includes/footer.jsp" %>
    </body>

</html>