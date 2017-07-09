<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html" isELIgnored="false"%>

<form method="POST" action="<c:out value='${requestScope.registerUserAction}'/>">
	
	<tr>
		<td>Name :</td>
		<td><input type="text" name="firstName"
			value="${requestScope.user.name}"> </input></td>
	</tr>
	<input type="submit" value="Submit"> &nbsp; <a href="<c:out value='${requestScope.resetUrl}'/>">Reset</a>
	
</form>