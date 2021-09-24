<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="crt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${searchVo.prev}">
	<a href="#" onClick="goPage('${searchVo.page}')">Previous</a>
</c:if>
	
<c:forEach begin="${searchVo.startPage}" end="${searchVo.endPage}" var="idx">
	<a href="#" onClick="goPage('${idx}')"> ${idx} </a>
</c:forEach>
	
<c:if test="${searchVo.next}">
	<a href="#" onClick="goPage('${searchVo.page}')" >Next</a>
</c:if>
