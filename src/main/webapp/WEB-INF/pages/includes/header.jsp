<%-- 
    Document   : header
    Created on : Dec 31, 2014, 3:25:20 PM
    Author     : PTamang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="container">
        <div class="row">
            <h2 id="logo" class="span4"><a href="<c:url value='/'/>" title="Fashion Store">OnlineMart</a></h2>
            <nav class="span8" id="navigation">
                <div class="accountbox">
                    <div class="span4">
                        <div class="navbar navbar-static navlist">
                            <ul class="nav">                                
                                <li>
                                    <c:if test="${not empty sessionScope.user}">
                                        <c:if test="${not empty sessionScope.userType}">
                                             <c:if test="${ sessionScope.userType eq 'vendor' }">
                                            
                                                 <style>
                                                     .shopping_cart_link{
                                                         display:none !important;
                                                     }
                                                 </style>
                                            
                                        </c:if>
                                            
                                        </c:if>
                                        
                                        
                                    </c:if>                                    
                                    
                                    
                                    <a href="<c:url value='/shoppingcart/productlist'/>" class="shopping_cart_link"><i class="icon-shopping-cart"></i> Shopping Cart
                                        <c:if test="${(totalquantity > 0)  }">
                                            ${totalquantity}
                                        </c:if>
                                    </a>
                                    
                                </li>
                                <li class="divider-vertical"></li>
                                    <c:if test= "${not empty sessionScope.user}" >
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                <i class="icon-user"></i> My Account
                                            </a>
                                            <ul class="dropdown-menu anchor-dark">
                                                <li>
                                                    <a href="<c:url value='/${sessionScope.userType}/dashboard' />">Basic Info</a>
                                                </li>
                                                <li class="divider"></li>
                                                <li>
                                                    <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
                                                </li>
                                            </ul>
                                        </li>
                                    </c:if>
                                    <c:if test= "${empty sessionScope.user}">
                                        <li>
                                            <a href="<c:url value="/customer/addCustomer" />">Sign Up</a>
                                        </li>
                                        <li class="divider-vertical"></li>
                                        <li>
                                            <a href="<c:url value='/login'/>">
                                                Login
                                            </a>
                                        </li>
                                    </c:if>        
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
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">CATEGORIES <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="<c:url value='/template/product'/>">Watches</a></li>
                                        <li class="divider"></li>
                                        <li><a href="listwomen.jsp">Shoes</a></li>
                                        <li class="divider"></li>
                                        <li><a href="listwomen.jsp">Shirts</a></li>
                                        <li class="divider"></li>
                                        <li><a href="listwomen.jsp">Ties</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="searchbox">       
                <div class="input-prepend">
                    
                    <form method="POST" action="<c:url value='product/search'/>"/>
                        <span class="add-on">
                            <i class="icon-search"></i>
                        </span>
                    <input name="search" class="span3" data-provide="typeahead" placeholder="Search product" id="prependedInput" size="16" type="text" data-source='["Womens Dresses", "Womens Tops", "Womens Suites", "Womens Jeans", "Womens Swim", "Womens Jewelry", "Womens Beauty", "Mens Shirts", "Mens Jeans", "Mens Suits", "Mens Shoes", "Mens Swim", "Mens Active", "Mens polos", "Kids Shirts", "Kids Jeans", "Kids Dresses", "Kids Shoes", "Kids Swim", "Kids Active", "Kids Polos"]'/>
                        <input type="submit" value=" Go " class="btn-search" id="prependedInput"/>
                    </form>
                </div>
            </div>	
        </div>
    </div>
</div>
