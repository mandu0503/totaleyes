<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp"%>
<!doctype html>
<html lang="ko">
<head>
	<%@include file="/WEB-INF/jsp/include/head.jsp"%>

<script>

$(document).ready(function(){
// ready function -->

	// 회원유형 선택
	$('.join__select').click(function(){
		var target = $(this).attr('data-target');
		
		$('.wrap__member__content').hide();
		$('.'+target).show();
	});


	// 회원가입완료
	$(.btn__join__complete).on('click',function(){
		$('.container__join__complete, .pop--overlay').fadeIn('fast');
		$('body').css('overflow','hidden')
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
				<li>가입정보 입력</li>
			</ul>
		</div>
		
		<div class="join__form join__form__step2">
			<div class="tit__section">
				<h2>가입정보 입력</h2>
			</div>
			
			<div class="tit__sub">
				<h3 class="fl">로그인 계정정보</h3>
				<div class="fr font--color2">필수항목</div>
			</div>
			<table>
				<caption></caption>			
				<col />
				
				<tr>
					<td>
						<input type="text" placeholder="아이디" class="w100 join__id" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" placeholder="비밀번호" class="w100 join__pw" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" placeholder="비밀번호 확인" class="w100 join__chk" />
					</td>
				</tr>
			</table>
			
			<div class="tit__sub">
				<h3 class="fl">회원정보</h3>
				<div class="fr font--color2">필수항목</div>
			</div>
			<table>
				<caption></caption>			
				<col />
				
				<tr>
					<td>
						<input type="text" placeholder="이름" class="w100" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" placeholder="이메일 주소" class="w100" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" placeholder="연락처" class="w100" />
					</td>
				</tr>
			</table>
			
			<div class="tit__sub">
				<h3 class="fl">회원유형</h3>
				<div class="fr font--color2">필수항목</div>
			</div>
			<ul class="wrap__member__type">
				<li>
					<label class="radio__wrap">
						<input type="radio" name="join-select1" class="join__select" checked data-target="type1" /><span class="ico"></span>
						<span class="for">회사 대표회원으로 가입합니다.(회사 관리자)</span>
					</label>
				</li>
				<li>
					<label class="radio__wrap">
						<input type="radio" name="join-select1" class="join__select" data-target="type2" /><span class="ico"></span>
						<span class="for">회사 대표회원이 이미 가입하였으며, 구성원으로 가입합니다.</span>
					</label>
				</li>
				<li>
					<label class="radio__wrap">
						<input type="radio" name="join-select1" class="join__select" data-target="type3" /><span class="ico"></span>
						<span class="for">회사에 소속되지 않았습니다.</span>
					</label>
				</li>
			</ul>
			
			<div class="wrap__member__content type1">
				<div class="tit__sub">
					<h3 class="fl">회사정보</h3>
					<div class="fr font--color2">필수항목</div>
				</div>
				<table>
					<caption></caption>
					<col style="width: 150px;" />			
					<col />
					
					<tr>
						<th>회사명</th>
						<td>
							<input type="text" placeholder="최대 50자" class="w100" maxlength="50" oninput="maxLengthCheck(this)"  />
						</td>
					</tr>
					<tr>
						<th>사업자 등록번호</th>
						<td>
							<div class="wrap__input--part company">
								<div class="line">
									<input type="number" placeholder="3자리" class="w100" max="999" maxlength="3" oninput="maxLengthCheck(this)" />
								</div>
								<div class="line">
									<input type="number" placeholder="2자리" class="w100" max="99" maxlength="2" oninput="maxLengthCheck(this)" />
								</div>
								<div>
									<input type="number" placeholder="5자리" class="w100" max="99999" maxlength="5" oninput="maxLengthCheck(this)" />
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<th>대표자이름</th>
						<td>
							<input type="text" placeholder="최대 50자" class="w100" maxlength="20" oninput="maxLengthCheck(this)"  />
						</td>
					</tr>
					<tr>
						<th>업태</th>
						<td>
							<input type="text" placeholder="최대 30자" class="w100" maxlength="30" oninput="maxLengthCheck(this)"  />
						</td>
					</tr>
					<tr>
						<th>업종</th>
						<td>
							<input type="text" placeholder="최대 30자" class="w100" maxlength="30" oninput="maxLengthCheck(this)"  />
						</td>
					</tr>
				</table>
				
				<div class="tit__sub">
					<div class="fl">
						<h3 class="fl">담당자 정보</h3>
						<label class="checkbox__wrap">
							<input type="checkbox" /><span class="ico"></span>
							<span class="for">회원정보와 동일</span>
						</label>
					</div>
					<div class="fr font--color2">필수항목</div>
				</div>
				<table>
					<caption></caption>			
					<col />
					
					<tr>
						<td>
							<input type="text" placeholder="이름" class="w100" />
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" placeholder="이메일 주소" class="w100" />
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" placeholder="연락처" class="w100" />
						</td>
					</tr>
				</table>
				
				<div class="wrap__member__info">
					<span class="font--color2">※ 입력하신 이메일 주소로 계정활성화 메일이 발송됩니다.</span><br/>
					수신한 이메일에서 계정활성화 시 회원가입 절차가 완료됩니다.
				</div>
			</div>
			
			<div class="wrap__member__content type2 display--n">
				<div class="tit__sub">
					<h3 class="fl">소속 회사 확인</h3>
					<div class="fr font--color2">필수항목</div>
				</div>
				<table>
					<caption></caption>
					<col style="width: 150px;" />			
					<col />
					
					<tr>
						<th>회사명</th>
						<td>
							<input type="text" placeholder="최대 50자" class="w100" maxlength="50" oninput="maxLengthCheck(this)"  />
						</td>
					</tr>
					<tr>
						<th>사업자 등록번호</th>
						<td>
							<div class="fl w80">
								<div class="wrap__input--part company">
									<div class="line">
										<input type="number" placeholder="3자리" class="w100" max="999" maxlength="3" oninput="maxLengthCheck(this)" />
									</div>
									<div class="line">
										<input type="number" placeholder="2자리" class="w100" max="99" maxlength="2" oninput="maxLengthCheck(this)" />
									</div>
									<div>
										<input type="number" placeholder="5자리" class="w100" max="99999" maxlength="5" oninput="maxLengthCheck(this)" />
									</div>
								</div>
							</div>
							<button type="button" class="btn__base btn__base--line fr">확인</button>
						</td>
					</tr>				
				</table>
				
				<div class="wrap__member__info">
					<span class="font--color2">※ 회원가입 신청 시 회사 대표회원(회사 관리자)에게 승인요청이 진행되며,</span><br/>
					승인 후 회원가입이 완료됩니다.
				</div>
			</div>
			
			<div class="wrap__member__content type3 display--n">
				<div class="wrap__member__info">
					<span class="font--color2">※ 입력하신 이메일 주소로 계정활성화 메일이 발송됩니다.</span><br/>
					수신한 이메일에서 계정활성화 시 회원가입 절차가 완료됩니다.
				</div>
			</div>
			
			<div class="wrap__page__btn">
				<div><button type="button" class="btn__base btn__base--color3">취소</button></div>
				<div><button type="button" class="btn__base btn__base--color1 btn__join__complete">회원가입</button></div>
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


<div class="container__join__complete">
	<div class="wrap__join__complete">
				
		<h3>회원가입(신청)이 완료되었습니다.</h3>
		
		<div class="wrap__member__info">
			등록하신 이메일로 회원가입 확인 메일을 발송하였습니다.<br/>
			활성화 후 정상적으로 로그인하실 수 있습니다.
		</div>
		
		<!--
		<div class="wrap__member__info">
			회사 대표회원(회사관리자)에게 승인요청을 전송하였습니다.<br/>
			회사 관리자 승인 후 서비스를 이용하실 수 있습니다.
		</div>
		-->
		
		<div class="wrap__page__btn center">
			<button type="button" class="btn__base btn__base--color1">로그인</button>
		</div>
		
	</div>
</div>
			
			
</body>
</html>