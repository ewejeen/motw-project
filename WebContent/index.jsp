<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<title>#MOTW :: Your Movies of the Week</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/index.css">
<script src="js/jquery-3.3.1.js"></script>
</head>
<body>
	<div id="wrap">
			<div class="main">
				<jsp:include page="header.jsp" />
				
				<div class="item">
					<ul>
						<li class="on" onclick="fnMove('0')"></li>
						<li onclick="fnMove('1')"><a href=""></a></li>
						<li onclick="fnMove('2')"></li>
						<li onclick="fnMove('3')"></li>
						<li onclick="fnMove('4')"></li>
					</ul>
				</div>
				
				<div class="section sec0" id="sec0">
					<div class="container">
						<img src="img/logo_v4.png" alt="logo">
						<h3><em>Your Movies of the Week!</em></h3>
						<a onclick="goClick(event)">What's #MOTW?</a>
					</div>
				</div>
				
				<div class="section sec1" id="sec1">
					<div class="container">
						<p>Ran out of movies to watch?</p>
						<p class="m"><span>#MOTW</span> is here to help you!</p>
						<p class="r">We recommend you <span>5 movies a week.</span></p>
					</div>
				</div>
				
				<div class="section sec2" id="sec2">
					<div class="container">
						<p>The movies have <span>one same theme.</span></p>
						<p>The theme changes <span>every week.</span></p>
						<p class="s"><span onclick="location.href='signInForm.mo'">Sign in</span> to make a list of movies you like.</p>
					</div>
				</div>
				
				<div class="section sec3" id="sec3">
					<div class="container">
						<p>You can also share your <span>stories</span> & <span>opinions</span></p>
						<p class="c">in <span onclick="location.href='cList.bo'">Community.</span></p>						</p>
					</div>
				</div>		
				
				<div class="section sec4" id="sec4">
					<div class="container">
						<p class="h">
							<span>Start</span> browsing <span>#MOTW</span> <span class="h" onclick="location.href='movieList.mv'">here!</span>
						</p>
						<p>
							Or before that, <span class="h" onclick="location.href='signUp.jsp'">sign up</span> or <span class="h" onclick="location.href='signInForm.mo'">sign in</span> :)
						</p>
					</div>
				</div>
			</div>
		<div class="footer"></div>
	</div>
	<script>
		var win_h = $(window).height();
		
		var $section = $('.main .section');
		var $secSize = $section.length;
		var $item = $('.item li');
		
		window.onload=function(){
			$section.each(function(index){
				$(this).attr('data-index',win_h*index);
			});
			
			$section.on('mousewheel',function(e){
				var sectionPos = parseInt($(this).attr('data-index'));
				
				if(e.originalEvent.wheelDelta>=0){
					$('html,body').stop().animate({scrollTop:sectionPos-win_h});
					return false;
				} else if(e.originalEvent.wheelDelta<0){
					$('html,body').stop().animate({scrollTop:sectionPos+win_h});
					return false;
				}
			});
			
		}

		function goClick(event){
			event.preventDefault();
			var offset=$('#sec1').offset();
			$('html, body').stop().animate({scrollTop:offset.top});
		}
		
		function fnMove(i){
			var offset=$('#sec'+i).offset();
			$('html, body').stop().animate({scrollTop:offset.top});
		}
		
		var $idx=$(this).index();
		
		$item.on('click',function(){
			var $idx=$(this).index();
			$item.eq($idx).addClass('on');
			$item.eq($idx).siblings().removeClass('on');
		});
		
		$(window).scroll(function(e){
			var windowTop=$(window).scrollTop();
			for(var i=0;i<$secSize;i++){
				var secTop=$section.eq(i).offset().top;
				if(windowTop>=secTop){
					//마우스 휠로 section이동 했을 때 오른쪽 버튼에 on 클래스 추가 / 삭제
					$item.eq(i).addClass('on');
					$item.eq(i).siblings().removeClass('on');
				}
			}
		});
		
	</script>
</body>
</html>