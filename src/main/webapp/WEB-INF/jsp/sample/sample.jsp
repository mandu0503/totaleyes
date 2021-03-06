<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample</title>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function(){
	$.ajax({
	    url:'/getSampleList.do',
	    type:'post',
	    dataType: 'html',
	    data: {
	    	'${_csrf.parameterName}' : '${_csrf.token}',	    	
	    },
	    success:function(data){
	    	$("#listDiv").html(data);
	    }
	});
	
	$('#btnSubmit').click(function (event) {
        event.preventDefault();
        
        var form = $('#fileUploadForm')[0];
        var data = new FormData(form);
        data.append('customField', '추가필드');
        data.append('${_csrf.parameterName}', '${_csrf.token}');
        $('#btnSubmit').prop('disabled', true);
		
        $.ajax({
            type: 'POST',
            enctype: 'multipart/form-data',
            url: '/rest/fileupload.do',
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
                $('#result').text(data);
                console.log('SUCCESS : ', data);
                $('#btnSubmit').prop('disabled', false);
            },
            error: function (e) {
                $('#result').text(e.responseText);
                console.log('ERROR : ', e);
                $('#btnSubmit').prop('disabled', false);
            }
        });
        
    });
});
//이전 버튼 이벤트
function fn_prev(page, startRange, rangeSize) {
	var page = ((startRange - 2) * rangeSize) + 1;
	var startRange = startRange - 1;	
	fn_search(page, startRange);
}

//페이지 번호 클릭
function fn_pagenation(page, startRange, rangeSize) {
	fn_search(page, startRange);
}

//다음 버튼 이벤트
function fn_next(page, startRange, rangeSize) {
	var page = parseInt((startRange * rangeSize)) + 1;
	var startRange = parseInt(startRange) + 1;
	fn_search(page, startRange);
}
function fn_search(page, startRange){
	var searchType = $("#searchType").val();
	var searchNm = $("#searchNm").val();
	$.ajax({
	    url:'/getSampleList.do',
	    type:'post',
	    dataType: 'html',
	    data: {
	    	'${_csrf.parameterName}' : '${_csrf.token}',
	    	'page' : page,
	    	'startRange' : startRange,
	    	'searchType' : searchType,
	    	'searchNm' : searchNm
	    },
	    success:function(data){
	    	$("#listDiv").html(data);
	    }
	});
}
function fn_pageGo(page){
	var searchType = $("#searchType").val();
	var searchNm = $("#searchNm").val();
	$.ajax({
	    url:'/getSampleList.do',
	    type:'post',
	    dataType: 'html',
	    data: {
	    	'${_csrf.parameterName}' : '${_csrf.token}',
	    	'page' : page,
	    	'searchType' : searchType,
	    	'searchNm' : searchNm
	    },
	    success:function(data){
	    	$("#listDiv").html(data);
	    }
	});
}
function fn_restSample(){
	$.ajax({
	    url:'/rest/sample.do',
	    type:'post',
	    dataType: 'json',
	    data: {
	    	'${_csrf.parameterName}' : '${_csrf.token}',
	    	'type' : 'type'
	    },
	    success:function(data){
	    	if(data.returnCode == '9000'){
	    		alert(data.message);	
	    	}
	    }	    
	});
}
</script>
</head>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
  }
</style>
<body>
	<div>
		<select id="searchType">
			<option value="subject">제목</option>
		</select>
		<input type="text" id="searchNm"/>
		<button onclick="fn_search()">검색</button>
	</div>
	<div id="listDiv" style="text-align: -webkit-center;">
		
	</div>
	
	<div> 
		<button onclick="fn_restSample()">rest sample</button>
	</div>
	<div>
		<form method="POST" enctype="multipart/form-data" id="fileUploadForm">
	        <input type="text" name="extraField"/><br/><br/>
	        <input type="file" name="uploadfiles"/><br/><br/>
	        <input type="file" name="uploadfiles"/><br/><br/>
	        <input type="submit" value="Submit" id="btnSubmit"/>
	    </form>
	</div>
</body>
</html>