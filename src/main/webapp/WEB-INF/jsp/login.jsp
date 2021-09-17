<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인

<form action="/authenticate" method="POST">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="text" name="userId" placeholder="Username">
<input type="password" name="password" placeholder="Password">
<button type="submit">Login</button>
<c:if test = "${not empty msg }">
	${msg}
</c:if>
</form>
</body>
</html>