<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp"%>
<sec:authentication property="principal" var="auth" />
<header id="header">
	<div class="header">
		<h1 class="sta"></h1>

		<div class="header__util">
			<div class="header__member__info">
				${auth.username}
				<span class="header__member__credit">1,000 Credit</span>
				<a class="header__member__alert badge">알람표시</a><!-- 있을시 클래스 badge -->
			</div>
			<a class="btn__logout">Logout</a>
		</div>
	</div>
</header>

<!-- 공통 메세지 레이어 -->
<div class="pop--fixed pop__msg pop400">
	<div class="content__pop">
		<div class="wrap__pop__msg"></div>
		<div class="wrap__pop__btn center">
			<button type="button" class="btn__base btn__base--color1 btn__pop--close btn__pop--confirm">확인</button>
			<button type="button" class="btn__base btn__base--line btn__pop--close btn__pop--cancel">취소</button>
		</div>
	</div>
</div>


</body>
</html>