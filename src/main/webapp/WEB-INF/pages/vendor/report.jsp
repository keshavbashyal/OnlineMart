<%-- 
    Document   : dashboard
    Created on : Jan 3, 2015, 10:45:44 AM
    Author     : PTamang
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>OnlineMart - Vendor - Ad-hoc Report</title>
        <base href="<c:url value="/" />"/>
        <link rel="stylesheet" href="resources/css/style.css"/>

    </head>
    <body>

        <%@include file="../includes/header.jsp" %>

        <div class="container min-height-4">
            <div class="content">
                <div class="row">
                    <div class="span3">
                        <div class="thumbnail">
                            <img src="resources/img/vendor.jpg" alt="Vendor Avatar" height="50"/>
                        </div>
                        <br/>
                        <div class="">
                            <%@include file="vendor_left_nav.jsp" %>
                        </div>
                    </div>

                    <div class="span9 pull-right">
                        <h5>Vendor &rsaquo; Ad-hoc Report</h5>
                        <br>
                        <div class="span9">
                            <spring:form id="reportFrm"  method="get" action="${reportURL}" class="pull-right">
                                
                                <input type="hidden" value="${sessionScope.user.id}" name="vendorID"/>
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
                    </div>
                </div>
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
