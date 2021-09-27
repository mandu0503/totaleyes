<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
main

<form action="/logout.do" method="POST">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<button type="submit">Logout</button>
</form>
</body>
</html>