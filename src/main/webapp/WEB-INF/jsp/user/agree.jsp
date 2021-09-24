<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Script-Type" content="text/javascript">
	<meta http-equiv="Content-Style-Type" content="text/css">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Total Eyes</title>
	
	<link rel="stylesheet" href="../../../resources/css/style.css" />

	<script src="../../../resources/js/lib/jquery-3.5.1.min.js"></script>
	<script src="../../../resources/js/lib/jquery-ui.js"></script>
	<script src="../../../resources/js/common.ui.js"></script>

<script>

$(document).ready(function(){
// ready function -->


// 동의 전체 체크
$(function(){	
	$(document).on('click','.agree__chkall',function(){
		var target = $(this).attr('name');
		
		if($(this).prop('checked')){
			$('.'+target).prop('checked',true);
		} else {
			$('.'+target).prop('checked',false);
		}
	});	
	
	$(document).on('click','.agree__chksub',function(){
		var targetSub = $(this).attr('name');
		var targetNum = $(this).parents('.join__form').find('.agree__chksub').length;
		var targetChkNum = $(this).parents('.join__form').find('.agree__chksub:checked').length;
		
		if(targetChkNum == targetNum){
			$('.'+targetSub).prop('checked',true);
		} else {
			$('.'+targetSub).prop('checked',false);
		}
	});	
});


// 동의 체크 여부
$(function(){
	$(document).on('click','.btn__required__input',function() {
		var inputObjs1 = $('.required__input__chk1');
		var inputObjs2 = $('.required__input__chk2');
		var bEmpty = true;
		
		inputObjs2.each(function(index){
			if($(this).is(':checked') == false){
				bEmpty = false;

				$('.pop__msg, .pop--overlay').fadeIn('fast');
				$('body').css('overflow','hidden');
				$('.pop__msg .btn__pop--cancel').hide();
				$('.pop__msg .wrap__pop__msg').html('개인정보 수집, 이용에<br/>동의해 주시길 바랍니다.');

				return false;
			}
		});
		
		inputObjs1.each(function(index){
			if($(this).is(':checked') == false){
				bEmpty = false;

				$('.pop__msg, .pop--overlay').fadeIn('fast');
				$('body').css('overflow','hidden');
				$('.pop__msg .btn__pop--cancel').hide();
				$('.pop__msg .wrap__pop__msg').html('이용약관에<br/>동의해 주시길 바랍니다.');

				return false;
			}
		});

		if(!bEmpty) return;

		// 동의
	});
});


// <-- ready function
});

</script>

</head>


<body>

<div id="wrap"> 


	<!-- header -->
	<header id="header">
		<div class="header">
			<h1 class="sta"></h1>
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
	<!--// 공통 메세지 레이어 -->
	<div class="pop--overlay"></div>
	<!--// header -->


	<div class="wrap__join">
		
		<div class="tit__section">
			<ul class="tit__section__info">
				<li>홈</li>
				<li>회원가입</li>
				<li>약관동의</li>
			</ul>
		</div>
		
		<div class="join__form join__form__step1">
			<div class="tit__section">
				<h2>약관동의</h2>
			</div>
			
			<div class="wrap__agree__all">
				<label class="checkbox__wrap">
					<input type="checkbox" class="agree__chkall" name="agreeAll" /><span class="ico"></span>
					<span class="for">이용약관 · 개인정보 수집 및 이용에 <span class="font--color2">모두</span> 동의합니다.</span>
				</label>
			</div>
			
			<dl>
				<dt>
					<label class="checkbox__wrap">
						<input type="checkbox" class="required__input__chk1 agree__chksub agreeAll" name="agree__chkall" /><span class="ico"></span>
						<span class="for">이용약관 <span class="font--color2">(필수)</span></span>
					</label>
				</dt>				
				<dd class="join__agree__box1">
					서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 주의 깊게 살펴봐 주시기 바랍니다.
				</dd>
			</dl>
			
			<dl>
				<dt>
					<label class="checkbox__wrap">
						<input type="checkbox" class="required__input__chk2 agree__chksub agreeAll" name="agree__chkall" /><span class="ico"></span>
						<span class="for">개인정보 수집 및 이용 <span class="font--color2">(필수)</span></span>
					</label>
				</dt>				
				<dd class="join__agree__box2">
					개인정보보호법에 따라 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 동의하여 주시기 바랍니다.
				</dd>
			</dl>
			
			<div class="wrap__page__btn">
				<div><button type="button" class="btn__base btn__base--color3">취소</button></div>
				<div><button type="button" class="btn__base btn__base--color1 btn__required__input">확인</button></div>
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

</body>
</html>