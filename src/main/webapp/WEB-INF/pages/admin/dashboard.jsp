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
                    <legend><h3>Admin Form</h3></legend>
                    <div class="span4 pull-left">
                        <spring:form method="post" action="/admin/dashboard" >
                            <spring:errors element="div" cssClass="errors" path="*"/>
                            <spring:input type="hidden" path="id"/>
                            <table> 
                                <tr>
                                    <td><label>Total Customers</label></td>
                                    <td><a href="customer/list"><label> ${customersize}</label></a></td>
                                    <td><spring:errors path="customersize" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>Total Vendor </label></td>
                                    <td><label><a href="vendor/list"> ${vendorsize}</label></a></td>
                                    <td><spring:errors path="vendorsize" element="div" cssClass="error" /></td>
                                </tr>


                                </td>
                                </tr>


                            </table>
                            <h3>Vendor Information</h3>
                            <table id="tablelist" class="span12 table-bordered table-striped">
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
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <h3> Customer List</h3>
                             <table id="tablelist" class="span12 table-bordered table-striped">
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
                                <a href="customer/edit/${customers.id}" class="btn btn-success">Edit</a>
                                <a href="customer/delete/${customers.id}" class="btn btn-success">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                            <h3> Category List</h3>
                              <div class="span12">
                    <a href="category/addCategory" class="btn btn-success pull-right">Add New Product</a>
                </div>
                            <table id="tablelist" class="span12 table-bordered table-striped">
                                <tr>
                                    <th>id</th>
                                    <th>Category Description</th>
                                    <th>Category Name</th>
                                </tr>
                                <c:forEach items="${allCategories}" var="category">
                                    <tr>
                                        <td>${category.id}</td>
                                        <td>${category.categoryDescription}</td>
                                        <td>${category.categoryName}</td>

                                        <td>
                                            <a href="category/edit/${category.id}" class="btn btn-success">Edit</a>
                                            <a href="category/delete/${category.id}" class="btn btn-success">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </spring:form>
                    </div>
                </fieldset>
            </div>
        </div>

        <%@include file="../includes/footer.jsp" %>

    </body>
</html>
