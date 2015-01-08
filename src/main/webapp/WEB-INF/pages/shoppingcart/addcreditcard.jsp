<%-- 
    Document   : creditcard
    Created on : Jan 6, 2015, 4:33:17 PM
    Author     : psubedi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Customer Registration</title>
        <meta charset="utf-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <base href="<c:url value="/" />"/>
        <link href="resources/css/style.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="../includes/header.jsp" %>
        <div class="container min-height-4">
            <div class="content">
                <div class="row">
                    <div class="span3">
                        <div class="thumbnail">
                            <img src="resources/img/user-male.svg" alt="Customer Image" />
                        </div>
                        
                    </div>

                    <div class="span9 pull-right">
                        <div class="page-header">
                            <h3>Customer &rsaquo; Account &rsaquo; Add Credit Card</h3>
                        </div>
                        <form method="post" action="shoppingcart/checkoutGuest" >
                            
                            <spring:errors element="div" cssClass="errors" path="*"/>
                           

                            <table>
                                <tr>
                                    <td><label>Card Number </label></td>
                                    <td><input type="text" name="card.cardNo" /></td>
                                    <td><spring:errors path="cardNo" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>Expiry Date : Year </label></td>
                                    <td><input type="number" name="card.expYear" /></td>
                                    <td><spring:errors path="expYear" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>Expiry Date : Month </label></td>
                                    <td><input type="number" name="card.expMonth" /></td>
                                    <td><spring:errors path="expMonth" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>CCV Code </label></td>
                                    <td><input type="text" name="card.ccv" /></td>
                                    <td><spring:errors path="ccv" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>Credit Card Type </label></td>
                                    <td><input type="text" name="card.type" /></td>
                                    <td><spring:errors path="type" element="div" cssClass="error" /></td>
                                </tr>
                                
                                <tr>
                                    <td><label>&nbsp; </label></td>
                                    <td><input type="submit" value="Save" /></td>
                                    <td>&nbsp;</td>
                                </tr>

                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/footer.jsp" %>
    </body>
</html>
