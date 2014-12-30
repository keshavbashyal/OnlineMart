<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
	<h1>Something</h1>

<p>
	The message is ${message}</p>
	<form id="myform" action="/welcome" method="POST" >
            <p>GuestName</p> <input type="text" name="userName" path="userName"/><br/>
	    <p>Description</p><input type="text" name="description" path="description"/> <br/>
            <input type="submit" value="submit">
	</form>


</body>
</html>
