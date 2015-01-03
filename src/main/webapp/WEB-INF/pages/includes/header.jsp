<%-- 
    Document   : header
    Created on : Dec 31, 2014, 3:25:20 PM
    Author     : PTamang
--%>

<header>
    <div class="container">
        <div class="row">
            <h2 id="logo" class="span4"><a href="<c:url value='/'/>" title="Fashion Store">OnlineMart</a></h2>
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
                                        <li><a href="<c:url value='/template/product'/>">Dresses</a></li>
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