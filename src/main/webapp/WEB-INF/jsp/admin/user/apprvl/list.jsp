<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp"%>
<!doctype html>
<html lang="ko">
<head>
	<%@include file="/WEB-INF/jsp/include/head.jsp"%>

<script>

$(document).ready(function() {
	fn_pageGo(1);
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

function fn_pageGo(page) {
	$.ajax({
	    url:'/admin/user/apprvl/listItem.do',
	    type:'post',
	    dataType: 'html',
	    data: {
	    	'${_csrf.parameterName}' : '${_csrf.token}',
	    	'page' : page
	    },
	    success:function(data){
	    	$("#list").html(data);
	    }
	});
}

</script>
</head>
<body>
<div id="wrap"> 
	<div id="list">
	
	</div>
	<button id="btn_apprvl">승인</button>
</div>
	
</body>