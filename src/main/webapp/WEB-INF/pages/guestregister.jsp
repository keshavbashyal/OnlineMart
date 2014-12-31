<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet"      href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Guest</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Guest</h1>
                    <p>Register Guest</p>
                </div>
            </div>
        </section>
        <section class="container">
            <form:form  modelAttribute="guest" commandName="add" class="form-horizontal">
                <fieldset>
                    <legend>Add new guest</legend>
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="productId">Guest Name</label>
                        <div class="col-lg-10">
                            <form:input id="guestName" path="guestName" type="text" class="form:input-large"/>
                        </div>
                    </div>
                   
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="description">Description</label>
                        <div class="col-lg-10">
                            <form:textarea id="description" path="description" rows = "2"/>
                        </div>
                    </div>
                    

                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
                        </div>
                    </div>
                    
                </fieldset>
            </form:form>
        </section>
    </body>
</html>