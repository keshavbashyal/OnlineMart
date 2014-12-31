<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
	<h1>Something</h1>

<p>
	The message is ${message}</p>
	<form id="myform" action="/springdemo2/welcome" method="POST" >
		<input type="text" name="firstName" path="firstName"/>
		<input type="text" name="lastName" path="lastName"/>
		<input type="text" name="email" path="email"/>
		<input type="submit" value="submit">
	</form>


</body>
</html>
