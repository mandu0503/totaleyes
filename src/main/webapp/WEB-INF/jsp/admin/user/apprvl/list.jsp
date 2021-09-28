<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp"%>
<!doctype html>
<html lang="ko">
<head>
	<%@include file="/WEB-INF/jsp/include/head.jsp"%>

<script>

$(document).ready(function() {
	$('#btn_apprvl').on('click', function() {
		let userId = 'topeyes1';
		
		$.ajax({
			url: '/api/admin/user/apprvl.do',
			type: 'post',
			data: {userId: userId, '${_csrf.parameterName}': '${_csrf.token}'},
			dataType: 'json',
			async: false,
			// beforeSend: function(xhr, opts) {
			//	loading_start();
			// },
			success: function(res) {
			//	loading_finish();
				if (res.returnCode == '0000') {
					alert('승인이 되었습니다.');
				} else {
	 				alert(res.message);
				}
			},
			error: function(error) {
	//			loading_finish();
				alert('서비스가 원활하지 않습니다. 잠시 후 다시 시도하세요.');
			}
		});
	});
});


</script>
</head>
<body>
<div id="wrap"> 
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
		<a href="#" onClick="fn_prev('${searchVo.page}', '${searchVo.startRange}', '${searchVo.rangeSize}')">Previous</a>
	</c:if>
		
	<c:forEach begin="${searchVo.startPage}" end="${searchVo.endPage}" var="idx">
		<a href="#" onClick="fn_pagenation('${idx}', '${searchVo.startRange}', '${searchVo.rangeSize}')"> ${idx} </a>
	</c:forEach>
		
	<c:if test="${searchVo.next}">
		<a href="#" onClick="fn_next('${searchVo.page}', '${searchVo.startRange}', '${searchVo.rangeSize}')" >Next</a>
	</c:if>
	<button id="btn_apprvl">승인</button>
</div>
	
</body>