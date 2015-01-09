<%-- 
    Document   : dashboard
    Created on : Jan 3, 2015, 10:45:44 AM
    Author     : PTamang
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>OnlineMart - Vendor - Dashboard</title>
        <base href="<c:url value="/" />"/>
        <link rel="stylesheet" href="resources/css/style.css"/>
    </head>
    <body>

        <%@include file="../includes/header.jsp" %>

        <div class="container min-height-4">
            <div class="content">
                <fieldset>
                    <legend>Admin &rsaquo; Dashboard</legend>
                    <div class="pull-left">
                        <table class="table table-condensed table-head"> 
                            <tr>
                                <td><label>Total Customers</label></td>
                                <td><a href="customer/list"><label> ${customersize}</label></a></td>
                                <td><spring:errors path="customersize" element="div" cssClass="error" /></td>
                            <td><label>Total Vendor </label></td>
                            <td><label><a href="vendor/list"> ${vendorsize}</label></a></td>
                            <td><spring:errors path="vendorsize" element="div" cssClass="error" /></td>
                            </tr>
                        </table>
                    </div>
                    <div class="span12 thumbnail">
                        <div class="breadcrumb">Report</div>
                        <spring:form id="reportFrm"  method="get" action="http://10.10.14.51:8080/CRviewer/ra.jsp" class="pull-right">

                            <spring:errors element="div" cssClass="errors" path="*"/>
                            <input type="hidden" value="1" name="productID"/>
                            <table class="table table-striped">
                                <tr class='pull-left'>
                                    <td><label>From Date</label></td>
                                    <td><input type="text" id="from" name="fromDate"/></td>
                                    <td><label>To Date</label></td>
                                    <td><input type="text" id="to" name="toDate"/></td>
                                </tr>
                                
                            </table>
                            <input type="submit" value="Get Report" class="btn btn-success pull-right"/>
                        </spring:form>
                    </div>
                    <div class="span12 thumbnail">
                        <div class="breadcrumb"><h5>Vendor Information</h5></div>
                        <table id="" class="table table-condensed table-striped">
                            <tr class="">
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th> Status</th>
                                <th>Actions</th>
                            </tr>
                            <c:forEach items="${allvendors}" var="vendor">
                                <tr>
                                    <td>${vendor.id}</td>
                                    <td>${vendor.vendorName}</td>
                                    <td>${vendor.email}</td>
                                    <td> 
                                        <%--
                                        <c:set var="color" scope="session" value="green"/>
                                        <c:if test="${vendor.status}='APPROVED'"> 
                                           <p>My salary is: <c:out value='color'/></p>  
                                        </c:if>
                                        --%>
                                        <a href="admin/vendorVarification/${vendor.id}">${vendor.status}</a></td>
                                    <td>
                                        <a href="vendor/edit/${vendor.id}" class="btn btn-primary btn-mini">Edit</a>
                                        <a href="vendor/delete/${vendor.id}" onclick="return confirm(' Delete Record ')" class="btn btn-danger btn-mini">Delete</a>

                                        <c:if test="${vendor.status == 'PENDING'}">
                                            <a href="admin/vendor/status/${vendor.id}" onclick="return confirm(' Change status ')" class="btn btn-primary btn-mini">Approve</a>
                                        </c:if>



                                        <c:if test="${vendor.status == 'APPROVED'}">
                                            <a href="admin/vendor/status/${vendor.id}" onclick="return confirm(' Change status ')" class="btn btn-danger btn-mini">Disable</a>
                                        </c:if>


                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>  
                    <div class="span12 thumbnail">
                        <div class="breadcrumb"><h5> Customer List</h5></div>

                        <table class="table table-condensed table-striped">
                            <tr>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Operations</th>
                            </tr>
                            <c:forEach items="${allcustomers}" var="customers">
                                <tr>
                                    <td>${customers.fname}</td>
                                    <td>${customers.lname}</td>
                                    <td>${customers.email}</td>
                                    <td>${customers.phone}</td>
                                    <td>
                                        <a href="customer/edit/${customers.id}" class="btn btn-primary btn-mini">Edit</a>
                                        <a href="customer/delete/${customers.id}" class="btn btn-danger btn-mini">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="span12 thumbnail">
                        <div class="breadcrumb"><h5> Category List</h5></div>
                        <div class="span12">
                            <a href="category/addCategory" class="btn btn-success pull-right">Add New Category</a>
                        </div>
                        <table class="table table-condensed table-striped">
                            <tr>
                                <th>id</th>
                                <th>Category Description</th>
                                <th>Category Name</th>
                                <th>Options</th>
                            </tr>
                            <c:forEach items="${allCategories}" var="category">
                                <tr>
                                    <td>${category.id}</td>
                                    <td>${category.categoryDescription}</td>
                                    <td>${category.categoryName}</td>

                                    <td>
                                        <a href="category/edit/${category.id}" class="btn btn-primary btn-mini">Edit</a>
                                        <a href="category/delete/${category.id}" class="btn btn-danger btn-mini">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </fieldset>
            </div>
        </div>

        <%@include file="../includes/footer.jsp" %>
        <link rel="stylesheet" href="resources/css/jquery-ui.css">
        <script src="resources/js/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#from").datepicker({dateFormat: 'yy-mm-dd'});
                $("#to").datepicker({dateFormat: 'yy-mm-dd'});
                $("#reportFrm").validate();
            });
        </script>
    </body>
</html>
