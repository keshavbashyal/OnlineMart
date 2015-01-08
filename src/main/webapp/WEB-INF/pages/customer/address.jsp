<%-- 
    Document   : address
    Created on : Jan 5, 2015, 1:55:57 PM
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
        <title>OnlineMart - Home</title>
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
                        <%@include file="customer_left_nav.jsp" %>
                    </div>

                    <div class="span9 pull-right">
                        <div class="page-header">
                            <h3>Customer &rsaquo; Account &rsaquo; Update Address</h3>
                        </div>
                        <spring:form method="post" action="customer/save" modelAttribute="customer">
                            <spring:errors element="div" cssClass="errors" path="*"/>
                            <spring:input type="hidden" path="id"/>
                            <table>
                                <tr>
                                    <td><label>Street Address </label></td>
                                    <td><spring:input path="address.street" /></td>
                                    <td><spring:errors path="address.street" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>City </label></td>
                                    <td><spring:input path="address.city" /></td>
                                    <td><spring:errors path="address.city" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>State </label></td>
                                    <td><spring:select path="address.state" >
                                            <spring:option value="AL">Alabama</spring:option>
                                            <spring:option value="AK">Alaska</spring:option>
                                            <spring:option value="AZ">Arizona</spring:option>
                                            <spring:option value="AR">Arkansas</spring:option>
                                            <spring:option value="CA">California</spring:option>
                                            <spring:option value="CO">Colorado</spring:option>
                                            <spring:option value="CT">Connecticut</spring:option>
                                            <spring:option value="DE">Delaware</spring:option>
                                            <spring:option value="DC">District Of Columbia</spring:option>
                                            <spring:option value="FL">Florida</spring:option>
                                            <spring:option value="GA">Georgia</spring:option>
                                            <spring:option value="HI">Hawaii</spring:option>
                                            <spring:option value="ID">Idaho</spring:option>
                                            <spring:option value="IL">Illinois</spring:option>
                                            <spring:option value="IN">Indiana</spring:option>
                                            <spring:option value="IA">Iowa</spring:option>
                                            <spring:option value="KS">Kansas</spring:option>
                                            <spring:option value="KY">Kentucky</spring:option>
                                            <spring:option value="LA">Louisiana</spring:option>
                                            <spring:option value="ME">Maine</spring:option>
                                            <spring:option value="MD">Maryland</spring:option>
                                            <spring:option value="MA">Massachusetts</spring:option>
                                            <spring:option value="MI">Michigan</spring:option>
                                            <spring:option value="MN">Minnesota</spring:option>
                                            <spring:option value="MS">Mississippi</spring:option>
                                            <spring:option value="MO">Missouri</spring:option>
                                            <spring:option value="MT">Montana</spring:option>
                                            <spring:option value="NE">Nebraska</spring:option>
                                            <spring:option value="NV">Nevada</spring:option>
                                            <spring:option value="NH">New Hampshire</spring:option>
                                            <spring:option value="NJ">New Jersey</spring:option>
                                            <spring:option value="NM">New Mexico</spring:option>
                                            <spring:option value="NY">New York</spring:option>
                                            <spring:option value="NC">North Carolina</spring:option>
                                            <spring:option value="ND">North Dakota</spring:option>
                                            <spring:option value="OH">Ohio</spring:option>
                                            <spring:option value="OK">Oklahoma</spring:option>
                                            <spring:option value="OR">Oregon</spring:option>
                                            <spring:option value="PA">Pennsylvania</spring:option>
                                            <spring:option value="RI">Rhode Island</spring:option>
                                            <spring:option value="SC">South Carolina</spring:option>
                                            <spring:option value="SD">South Dakota</spring:option>
                                            <spring:option value="TN">Tennessee</spring:option>
                                            <spring:option value="TX">Texas</spring:option>
                                            <spring:option value="UT">Utah</spring:option>
                                            <spring:option value="VT">Vermont</spring:option>
                                            <spring:option value="VA">Virginia</spring:option>
                                            <spring:option value="WA">Washington</spring:option>
                                            <spring:option value="WV">West Virginia</spring:option>
                                            <spring:option value="WI">Wisconsin</spring:option>
                                            <spring:option value="WY">Wyoming</spring:option>
                                        </spring:select>								</td>
                                    <td><spring:errors path="address.state" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>Zip </label></td>
                                    <td><spring:input path="address.zipCode" /></td>
                                    <td><spring:errors path="address.zipCode" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="submit" value="Submit" class="btn btn-primary pull-right"/>
                                    </td>
                                </tr>
                            </table>
                        </spring:form>
                    </div>
                </div>
            </div>
            <%@include file="../includes/footer.jsp" %>
    </body>
</html>