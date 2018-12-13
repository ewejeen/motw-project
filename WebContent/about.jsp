<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: About</title>
<link rel="stylesheet" href="css/about.css" media="all" />
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />

		<div class="about">
			<div class="container">
				<div class="top">
					<div class="l2">
						<h1>About</h1>
						<span>About the developer</span>
					</div>
				</div>

				<div class="con">
					<div class="info">
						<div class="name">
							<h1>김유진</h1>
							<span>YOOJIN KIM</span>
						</div>
						<ul>
							<li>
								<img src="img/email.png" alt="email" />
								<span>yoojinkim24@gmail.com</span>
							</li>
							<li>
								<img src="img/phone.png" alt="phone" />
								<span>+82 10-6660-7934</span>
							</li>
							<li>
								<img src="img/website.png" alt="website" />
								<a href="http://cestyoojin.cafe24.com">http://cestyoojin.cafe24.com</a>
							</li>
							<li>
								<img src="img/github.png" alt="github" />
								<a href="https://github.com/ewejeen">https://github.com/ewejeen</a>
							</li>
						</ul>
					</div>
					<div class="skill">
						<h2>SKILLS</h2>
						<ul>
							<li>Java</li>
							<li>JSP</li>
							<li>MySQL</li>
						</ul>
						<ul>
							<li>AJAX</li>
							<li>JavaScript</li>
							<li>jQuery</li>
						</ul>
						<ul>
							<li>HTML5</li>
							<li>CSS</li>
							<li>Spring Framework</li>
						</ul>
					</div>
					<span id="moreBtn">MORE</span>
					<div class="more">
						<div class="degree">
							<h2>DEGREE</h2>
							<ul>
								<li>
									<div class="licon">
										<span class="n">세종대학교</span>
										<span>영어영문학과</span>
										<span>글로벌미디어 소프트웨어 융합전공 (복수전공)</span>
									</div>
									<div class="date">
										<span>2013.03. - 2018.08.</span>
									</div>
								</li>
							</ul>
						</div>
						<div class="education">
							<h2>EDUCATION</h2>
							<ul>
								<li>
									<div class="licon">
										<span class="n">그린컴퓨터아카데미 강남</span>
										<span>오라클 기반 스프링 프레임워크 개발자(자바) - 디지털 컨버전스 (960h)</span>
									</div>
									<div class="date">
										<span>2018.06. - 2019.01.</span>
									</div>
								</li>
							</ul>
						</div>
						<div class="awards">
							<h2>AWARDS</h2>
							<ul>
								<li>
									<div class="licon">
										<span class="n">제4회 세종 코딩챌린지위크</span>
										<span>장려상</span>
									</div>
									<div class="date">
										<span>2017.10.</span>
									</div>
								</li>
							</ul>
						</div>
						<div class="qualification">
							<div class="certificate">
								<h2>CERTIFICATE</h2>
								<ul>
									<li>
										<div class="licon">
											<span class="n">정보처리기사</span>
										</div>
										<div class="date">
											<span>2018.11.</span>
										</div>
									</li>
									<li>
										<div class="licon">
											<span class="n">GTQ 그래픽기술자격</span>
											<span>1급</span>
										</div>
										<div class="date">
											<span>2018.08.</span>
										</div>
									</li>
									<li>
										<div class="licon">
											<span class="n">컴퓨터활용능력</span>
											<span>2급</span>
										</div>
										<div class="date">
											<span>2017.10.</span>
										</div>
									</li>
								</ul>							
							</div>
							<div class="english">
								<h2>ENGLISH</h2>
								<ul>
									<li>
										<div class="licon">
											<span class="n">TOEIC</span>
											<span>990</span>
										</div>
										<div class="date">
											<span>2018.11.</span>
										</div>
									</li>
									<li>
										<div class="licon">
											<span class="n">OPIc</span>
											<span>AL(Advanced Low)</span>
										</div>
										<div class="date">
											<span>2017.10.</span>
										</div>
									</li>
									
								</ul>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
	
	<script>
		$('.header li.menu:nth-child(5)').css({
	    	'border-bottom':'3px solid #d10000'});
		
		$('#moreBtn').click(function() {
			$('.more').toggleClass('open'); /*visibility:visible, opacity:1, display:block*/
		});
		
	</script>
</body>
</html>