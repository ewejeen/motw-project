<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/signIn.css" media="all" />
<title>#MOTW :: Sign In</title>
<script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
<script src="js/rsa/jsbn.js"></script>
<script src="js/rsa/rsa.js"></script>
<script src="js/rsa/prng4.js"></script>
<script src="js/rsa/rng.js"></script>
<script>
	if(${sessionId ne null }){
		alert('You are already signed in.');
		history.go(-1);	
	}

	function enterkey() {
		if (window.event.keyCode == 13) {
			signInFn();
		}
	}
</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		
		<div class="signIn">
			<div class="signInForm">
				<ul>
				    <li class="top">
                        <img src="img/logo_v3.png" alt="logo">
				        <h1>Sign In</h1>    
				    </li>
					
					<li>
                        <span>Username</span> 
                        <a class="fg" href="nameFind.jsp">Forgot username?</a>
                        <input type="text" name="username" id="username" onkeyup="enterkey()">
					</li>
					<li>
                        <span>Password</span> 
                        <a class="fg" href="pwFind.jsp">Forgot password?</a> 
				        <input type="password" name="userPw" id="userPw" onkeyup="enterkey()">
				        <input type="hidden" id="rsaPublicKeyModulus" value="<%=request.getAttribute("publicKeyModulus")%>" />
          				<input type="hidden" id="rsaPublicKeyExponent" value="<%=request.getAttribute("publicKeyExponent")%>" />
					</li>
					<li>
                        <input type="checkbox" name="autoIn" id="autoIn"/>
                        <p>Remember me</p>
                    </li>
                    <li>
                        <input type="button" value="Sign in" onclick="validateEncryptedForm()" />
                    </li>
					<span class="noacc">Don't have an account? <a class="noacc" href="signUp.jsp">Sign up now!</a></span>
				</ul>
			</div>
			
			<form id="signInFormRSA" name="signInFormRSA" action="signIn.mo" method="post" style="display: none;">
	            <input type="hidden" name="securedName" id="securedName" value="" />
	            <input type="hidden" name="securedPw" id="securedPw" value="" />
	        </form>
		</div>
	</div>
	<script>
	$('#username').val(Cookies.get('key'));      
	if($('#username').val() != ''){
		$('#autoIn').attr('checked', true);
	}
    
	$('#autoIn').change(function(){
	    if($('#autoIn').is(':checked')){
	        Cookies.set('key', $('#username').val(), { expires: 7 });
	    }else{
	        Cookies.remove('key');
	    }
	});
	     
	$('#username').keyup(function(){
	    if($('#autoIn').is(':checked')){
	        Cookies.set('key', $('#username').val(), { expires: 7 });
	    }
	});		
	</script>
	<script>
		function validateEncryptedForm() {
		    var username = document.getElementById("username");
		    var userPw = document.getElementById("userPw");
		   
			if (username.value == null || username.value == "") {
				alert('Enter username.');
				username.focus();
				return false;
			}
			if (userPw.value == null || userPw.value == "") {
				alert('Enter password.');
				userPw.focus();
				return false;
			}
	
		    try {
		        var rsaPublicKeyModulus = document.getElementById("rsaPublicKeyModulus").value;
		        var rsaPublicKeyExponent = document.getElementById("rsaPublicKeyExponent").value;
		        submitEncryptedForm(username.value, userPw.value, rsaPublicKeyModulus, rsaPublicKeyExponent);
		    } catch(err) {
		        alert(err);
		    }
		    return false;
		}
	
		function submitEncryptedForm(username, userPw, rsaPublicKeyModulus, rsaPpublicKeyExponent) {
		    var rsa = new RSAKey();
		    rsa.setPublic(rsaPublicKeyModulus, rsaPpublicKeyExponent);
	
		    // 사용자ID와 비밀번호를 RSA로 암호화한다.
		    var securedName = rsa.encrypt(username);
		    var securedPw = rsa.encrypt(userPw);
	
		    // POST 로그인 폼에 값을 설정하고 submit 한다.
		    var signInFormRSA = document.getElementById("signInFormRSA");
		    signInFormRSA.securedName.value = securedName;
		    signInFormRSA.securedPw.value = securedPw;
		    signInFormRSA.submit();
		}
	</script>
</body>
</html>
