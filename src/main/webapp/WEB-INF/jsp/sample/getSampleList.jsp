<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>     
<div>
	<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성일</th>
		<th>작성자</th>
	</tr>
	<c:forEach var="item" items="${sampleVoList}" varStatus="status">
		<tr>
			<td>${item.seq }</td>
			<td>${item.subject }</td>
			<td>${item.createDt }</td>
			<td>${item.createId }</td>		
		</tr>
	</c:forEach>
	</table>
</div>
<div>
	<c:if test="${searchVo.prev}">
		<a href="#" onClick="fn_pageGo('${searchVo.prevPage}')">Previous</a>
	</c:if>
		
	<c:forEach begin="${searchVo.startPage}" end="${searchVo.endPage}" var="idx">
		<a href="#" onClick="fn_pageGo('${idx}')"> ${idx} </a>
	</c:forEach>
		
	<c:if test="${searchVo.next}">
		<a href="#" onClick="fn_pageGo('${searchVo.nextPage}')" >Next</a>
	</c:if>
</div>
