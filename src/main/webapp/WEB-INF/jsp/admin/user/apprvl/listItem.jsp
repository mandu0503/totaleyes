<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp"%>
	<table>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>연락처</th>
		<th>요청일자</th>
	</tr>
	<c:forEach var="item" items="${users}" varStatus="status">
		<tr>
			<td>${searchVo.totCnt - ((searchVo.page-1) * searchVo.listSize)  - status.index}</td>
			<td>${item.userId}</td>
			<td>${item.userNm}</td>
			<td>${item.userEmail}</td>
			<td>${item.userCntctNo}</td>
			<td>${item.createdTm}</td>		
		</tr>
	</c:forEach>
	</table>
	<c:if test="${searchVo.prev}">
		<a href="#" onClick="fn_pageGo('${searchVo.prevPage}')">Previous</a>
	</c:if>
		
	<c:forEach begin="${searchVo.startPage}" end="${searchVo.endPage}" var="idx">
		<a href="#" onClick="fn_pageGo('${idx}')"> ${idx} </a>
	</c:forEach>
		
	<c:if test="${searchVo.next}">
		<a href="#" onClick="fn_pageGo('${searchVo.nextPage}')" >Next</a>
	</c:if>