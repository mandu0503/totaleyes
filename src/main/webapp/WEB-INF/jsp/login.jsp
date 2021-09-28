<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Script-Type" content="text/javascript">
	<meta http-equiv="Content-Style-Type" content="text/css">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Total Eyes</title>
	<link rel="stylesheet" href="../../resources/css/style.css" />

	<script src="../../resources/js/lib/jquery-3.6.0.min.js"></script>
	<script src="../../resources/js/lib/jquery-ui.js"></script>
	<script src="../../resources/js/common.ui.js"></script>
<script>
var type = '${type}';

if(type == 'error'){
	alert('${msg}');
}

function fn_login(){
	if($("#userId").val() == ''){
		alert('ID를 입력해주세요.');
		return;
	}
	if($("#password").val() == ''){
		alert('PASSWORD 를 입력해주세요.');
		return;
	}
	$("#form_login").submit();
}
</script>	
</head>
<body>
<div id="wrap"> 
	<div class="wrap__login">			
		<div class="wrap__login__ci"></div>
		<div class="box__login">
			<header>
				<h1>Total Eyes</h1>
				<h2>Integrated software security consulting platform </h2>
			</header>
			
			<div class="box__login__content">
				<form id="form_login" action="/authenticate" method="POST">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div class="input__login">
						<label>ID</label>
						<input type="text" name="userId" id="userId"/>
					</div>
					<div class="input__login">
						<label>PASSWORD</label>
						<input type="Password" name="password" id="password"/>
					</div>
					<input type="button"  class="btn__login" value="로그인" onclick = "fn_login()"/>
				</form>
				
				<div class="login__util">
					<a>아이디찾기</a>
					<a>비밀번호분실</a>
					<a href="/user/agree.do">회원가입</a>
				</div>
			</div>
		</div>
	</div>

	<!-- 공통 footer -->
	<footer>
		<div class="footer">
			<div class="copy">
				(06707) 서울 서초구 효령로 176, 02-523-7029<br/>
				COPYRIGHT 2021 kt ds ALL RIGHT RESERVED
			</div>
			
			<ul class="menu">
				<li><a href="#">개인정보처리방침</a></li>
				<li><a href="#">이용약관</a></li>
				<li><a href="#">FAQ</a></li>
			</ul>
		</div>
	</footer>
	<!--// 공통 footer -->
</div>
<!-- 
<form action="/authenticate" method="POST">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="text" name="userId" placeholder="Username">
<input type="password" name="password" placeholder="Password">
<button type="submit">Login</button>
<c:if test = "${not empty msg }">
	${msg}
</c:if>
</form>
 -->
</body>
</html>