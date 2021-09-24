// input maxlength
function maxLengthCheck(object){
	if (object.value.length > object.maxLength){
		object.value = object.value.slice(0, object.maxLength);
	}   
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

$(document).ready(function(){
// ready function -->


// left
$(function () {
	$('.wrap__gnb .gnb').hover(function () {
		$(this).parents('.wrap__gnb').addClass('on');
	}, function(){
		$(this).parents('.wrap__gnb').removeClass('on');
		$('.gnb > ul > li > ul').slideUp(350);
	});
	
	$('.gnb > ul > li > a').hover(function () {
		$('.gnb > ul > li > ul').slideUp(350);
		$(this).next('ul').stop(true,false).slideDown(300);
	}, function(){
	});
});


// 파일 업로드
var uploadFile = $('.file__wrap .upload__btn');
uploadFile.on('change', function(){
	if(window.FileReader){
		var filename = $(this)[0].files[0].name;
	} else {
		var filename = $(this).val().split('/').pop().split('\\').pop();
	}
	$(this).parents('.file__wrap').find('.file__name').val(filename);
	
	var fileNameInput = $(this).parents('.file__wrap').find('.file__name').val();	
	$(this).parents('.file__wrap').find('.file__name__text').html(fileNameInput);
});


// totop
$(".totop").hide();
$(function () {                 
	$('.content').scroll(function () {
		if ($(this).scrollTop() > 100) {
			$('.totop').fadeIn();
		} else {
			$('.totop').fadeOut('fast');
		}
	});
			
	$('.totop').click(function () {
		$('.content').animate({
			scrollTop: 0
		}, 400);
		return false;
	});
});


// 달력 from
$(function() {
	$( ".cal-from" ).datepicker({
		//showOn: "both", 
		//buttonImage: "../../../resources/img/btn-calendar.png", 
		//buttonImageOnly: true,
		dateFormat: 'yy-mm-dd',
		monthNames: ['.1월','.2월','.3월','.4월','.5월','.6월','.7월','.8월','.9월','.10월','.11월','.12월'],
		dayNamesMin: ['S','M','T','W','T','F','S'],
		changeMonth: true,
		changeYear: true,
		nextText: '다음 달',
		prevText: '이전 달',
		showMonthAfterYear: true,
	});
});

// 달력 to
$(function() {
	$( ".cal-to" ).datepicker({
		//showOn: "both", 
		//buttonImage: "../../../resources/img/btn-calendar.png", 
		//buttonImageOnly: true,
		dateFormat: 'yy-mm-dd',
		monthNames: ['.1월','.2월','.3월','.4월','.5월','.6월','.7월','.8월','.9월','.10월','.11월','.12월'],
		dayNamesMin: ['S','M','T','W','T','F','S'],
		changeMonth: true,
		changeYear: true,
		nextText: '다음 달',
		prevText: '이전 달',
		showMonthAfterYear: true,
	});
});


// tab on/off
$('.tab--common_ns li a').click(function(){
	$(this).parents('.tab--control').find('.common--tabview').not($('.cont__'+$(this).attr('data-target'))).hide();
	$(this).parents('.tab--control').find('.cont__'+$(this).attr('data-target')).show();

	$('.tab--common_ns li').not($(this).parents('li')).removeClass('active');
	$(this).parents('li').addClass('active');
});


// 레이어
$(function() { 
	$(document).on('click','.btn__pop--open',function(){		
		var popTarget = $(this).attr('data-target');
		$('#' + popTarget).fadeIn('fast');
		$('.pop--overlay').fadeIn('fast');
		$('body').css('overflow','hidden')
	});
	$('.btn__pop--close').click(function(){
		$(this).parents('.pop--fixed').fadeOut('fast');
		$('.pop--overlay').fadeOut('fast');
		$('body').css('overflow','auto')
	});
	$('.btn__pop--close--over').click(function(){
		$(this).parents('.pop--fixed').fadeOut('fast');
	});
});


// 테이블 체크박스
$(function(){	
	$(document).on('click','.chkall',function(){
		var target = $(this).attr('name');
		
		if($(this).prop('checked')){
			$('.'+target).prop('checked',true);
		} else {
			$('.'+target).prop('checked',false);
		}
	});	
	
	$(document).on('click','.chksub',function(){
		var targetSub = $(this).attr('name');
		var targetNum = $(this).parents('table').find('.chksub').length;
		var targetChkNum = $(this).parents('table').find('.chksub:checked').length;
		
		if(targetChkNum == targetNum){
			$('.'+targetSub).prop('checked',true);
		} else {
			$('.'+targetSub).prop('checked',false);
		}
	});	
});


// 경고창
$(document).on('click','.btn__pop__alert',function() {
	$('.pop__msg, .pop--overlay').fadeIn('fast');
	$('body').css('overflow','hidden');
});



// <-- ready function
});