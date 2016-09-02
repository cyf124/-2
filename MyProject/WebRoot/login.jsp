<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	onload = function() {
		showTime();
		if ("${message}" == -2) {
			document.getElementById("span1").innerHTML = 'The account<br>does not exist! ';
			document.getElementById("username1").value = "${username}";
			document.getElementById("password1").value = "${password}";
		}
		if ("${message}" == -1) {
			document.getElementById("span1").innerHTML = 'The password<br>is not correct! ';
			document.getElementById("username1").value = "${username}";
			document.getElementById("password1").type = "password";
			document.getElementById("password1").value = "${password}";
		}
		if ("${message}" == 1) {
			document.getElementById("span2").innerHTML = 'The password<br>is not correct! ';
			document.getElementById("username2").value = "${use}";
			document.getElementById("password2").type = "password";
			document.getElementById("password3").type = "password";
			document.getElementById("password2").value = "${pass}";
			document.getElementById("password3").value = "${pass}";
		}
		if ("${message}" == 1) {
			document.getElementById("span2").innerHTML = 'This account<br>has been<br>registered!';
			document.getElementById("boy").style.width = '0px';
			document.getElementById("girl").style.width = '300px';
			document.getElementById("women").style.display = '';
		    document.getElementById("span2").style.display = '';
		     document.getElementById("span1").style.display = 'none';
		}
		if ("${message}" == 2) {
			document.getElementById("span2").innerHTML = 'Registered<br>successfully !';
			document.getElementById("boy").style.width = '0px';
			document.getElementById("girl").style.width = '300px';
			document.getElementById("women").style.display = '';
		    document.getElementById("span2").style.display = '';
		     document.getElementById("span1").style.display = 'none';
		}
	}
	function showTime(){
	    var now = (new Date()).getHours();
		if (now >= 5 && now < 11) {
			document.getElementById("span1").innerHTML = 'Good morning!<br>Come on,fighting,<br>fighting,fighting!';
			document.getElementById("span2").innerHTML = 'Good morning!<br>Look in the<br>mirror and I<br>still so<br>beautiful';
		}
		if (now >= 11 && now < 13) {
			document.getElementById("span1").innerHTML = 'Good noon!<br>Stomach is<br>growling again,<br>eat only<br>effort work';
			document.getElementById("span2").innerHTML = 'Good noon!<br>Lunch did not<br>eat, weight<br>loss';
		}
		if (now >= 13 && now < 19) {
			document.getElementById("span1").innerHTML = 'Good afternoon!<br>To adhere to<br>the people,<br>success is just<br>a matter of time!';
			document.getElementById("span2").innerHTML = 'Good afternoon!<br>I am so<br>beautiful why<br>nobody like<br>me!';
		}
		if (now >= 19 || now < 5) {
			document.getElementById("span1").innerHTML = 'Good evening!<br>The night sky<br>is beautiful!';
			document.getElementById("span2").innerHTML = 'Good evening!<br>Each to this<br>time I will<br>think of you!';
		}
		
	}
	function misBoy() {
		document.getElementById("man").style.display = 'none';
		document.getElementById("span1").style.display = 'none';
		setTimeout("show()", 500);
	}
	function misGirl() {
		document.getElementById("women").style.display = 'none';
		document.getElementById("span2").style.display = 'none';
		setTimeout("back()", 500);
	}
	function show() {
		if (document.getElementById("boy").style.width != '0px') {
			document.getElementById("boy").style.width = (document
					.getElementById("boy").style.width.replace('px', ''))
					* 1 - 5 + 'px';
			setTimeout("show()", 1);
		} else {
			showGirl();
		}
	}
	function showGirl() {
		if (document.getElementById("girl").style.width != '300px') {
			document.getElementById("girl").style.width = (document
					.getElementById("girl").style.width.replace('px', ''))
					* 1 + 5 + 'px';
			setTimeout("showGirl()", 1);
		} else {
			setTimeout("showWomen()", 1);
		}
	}
	function showWomen() {
		document.getElementById("women").style.display = '';
		document.getElementById("span2").style.display = '';
		document.getElementById("username1").value = "username";
		document.getElementById("password1").type = "text";
		document.getElementById("password1").value = "password";
		showTime();
	}
	function back() {
		if (document.getElementById("girl").style.width != '0px') {
			document.getElementById("girl").style.width = (document
					.getElementById("girl").style.width.replace('px', ''))
					* 1 - 5 + 'px';
			setTimeout("back()", 1);
		} else {
			backBoy();
		}
	}
	function backBoy() {
		if (document.getElementById("boy").style.width != '300px') {
			document.getElementById("boy").style.width = (document
					.getElementById("boy").style.width.replace('px', ''))
					* 1 + 5 + 'px';
			setTimeout("backBoy()", 1);
		} else {
			setTimeout("showMan()", 1);
		}
	}
	function showMan() {
		document.getElementById("man").style.display = "";
		document.getElementById("span1").style.display = '';
		document.getElementById("username2").value = "username";
		document.getElementById("password2").type = "text";
		document.getElementById("password3").type = "text";
		document.getElementById("password2").value = "password";
		document.getElementById("password3").value = "password again";
		showTime();
	}
	function reset1(id) {

		if (document.getElementById("username1").value == '') {
			document.getElementById("username1").value = 'username';
		}
		if (document.getElementById("username2").value == '') {
			document.getElementById("username2").value = 'username';
		}
		if (document.getElementById("password1").value == '') {
			document.getElementById("password1").value = 'password';
		}
		if (document.getElementById("password2").value == '') {
			document.getElementById("password2").value = 'password';
		}
		if (document.getElementById("password3").value == '') {
			document.getElementById("password3").value = 'password again';
		}
		if (document.getElementById(id).value == 'username') {
			document.getElementById(id).value = '';
		}
		if(document.getElementById(id).value =='password'|| document.getElementById(id).value == 'password again'){
		   document.getElementById(id).type = 'password';
		   document.getElementById(id).value = '';
		}
	}
	function checkLgn() {
	   
		if (document.getElementById("username1").value == '') {
			document.getElementById("span1").innerHTML = "The user name<br>is not complete";
			return false;
		}
		if (document.getElementById("password1").value == '') {
			document.getElementById("span1").innerHTML = "The password<br>is not complete";
			return false;
		}
		return true;
	}
	function checkRgt() {
	    var username=/^[0-9a-zA-Z]{5,9}$/;
		if (document.getElementById("username2").value == '') {
			document.getElementById("span2").innerHTML = "The user name<br>is not<br>complete";
			return false;
		}
		if (document.getElementById("password2").value == '') {
			document.getElementById("span2").innerHTML = "The password<br>is not<br>complete";
			return false;
		}
		if (document.getElementById("password3").value == '') {
			document.getElementById("span2").innerHTML = "The password<br>again is<br>not complete";
			return false;
		}
		if (!username.test(document.getElementById("username2").value)) {
			document.getElementById("span2").innerHTML = "The account is<br>composed of<br>5 to 9 digits<br>or letters";
			return false;
		}
		if (!username.test(document.getElementById("password2").value)) {
			document.getElementById("span2").innerHTML = "The password is<br>composed of<br>5 to 9 digits<br>or letters";
			return false;
		}
		if (document.getElementById("password3").value != document
				.getElementById("password2").value) {
			document.getElementById("span2").innerHTML = "The two<br>passwords you<br>entered do<br>not match";
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<div
		style="position:absolute; left: 0;top: 0;height: 100%;width:100%;background: url('img/bg.jpg');background-size: 100% 100%">
		<div
				style="position:absolute;left:390px;top:130px;font-size: 40;font-family: '楷体';width: 600px">Keywords Visualization System</div>
		<div id="register"
			style="position:absolute;background: #0066FF;left:680px;top:200px;width: 300px;height:300px;border-radius: 20PX;">
			<div
				style="position:absolute;left:15px;top:12px;font-size: 30;font-family: '楷体';">Register</div>
			<form action="<%=path%>/RegisterServlet" method="post">
				<div
					style="position:absolute;left:60px;top:65px;width: 150;height:16px;">
					<input type="text" id="username2" name="username" value="username"
						onclick="reset1('username2')"
						style="padding: 2px 2px 2px 28px;border-radius: 20PX;height: 25px;font-family: '楷体';font-size: 15">
				</div>
				<div
					style="position:absolute;background: #FF88C2;left:68px;top:69px;width: 16px;height:16px;background: url('img/username.png');background-size:100% 100% "></div>
				<div
					style="position:absolute;left:60px;top:105px;width: 150px;height:16px;">
					<input type="text" id="password2" name="password" value="password"
						onclick="reset1('password2')"
						style="padding: 2px 2px 2px 28px;border-radius: 20PX;height: 25px;font-family: '楷体';font-size: 15">
				</div>
				<div
					style="position:absolute;left:68px;top:109px;width: 16px;height:16px;background: url('img/password.png');background-size:100% 100% "></div>
				<div
					style="position:absolute;left:60px;top:145px;width: 150px;height:16px;">
					<input type="text" id="password3" value="password again"
						onclick="reset1('password3')"
						style="padding: 2px 2px 2px 28px;border-radius: 20PX;height: 28px;font-family: '楷体';font-size: 15">
				</div>
				<div
					style="position:absolute;left:68px;top:154px;width: 16px;height:16px;background: url('img/password.png');background-size:100% 100% "></div>
				<div
					style="position:absolute;left:60px;top:185px;width: 150px;height:16px;">
					<input type="submit" value="OK" onclick="checkRgt()"
						style="background:#FF88C2;padding: 2px 2px 2px 2px;border-radius: 20PX;width: 195px;height: 28px;text-align:center;font-family: '楷体';font-size: 15">
				</div>
				<div
					style="position:absolute;left:60px;top:225px;width: 150px;height:16px;">
					<input type="button" value="Cancel"
						style="background:#FF88C2;padding: 2px 2px 2px 2px;border-radius: 20PX;width: 195px;height: 28px;text-align:center;font-family: '楷体';font-size: 15"
						onclick="misGirl()">
				</div>
			</form>
			<div id="boy"
				style="position: absolute;left: 0;top: 0;width: 300px;height: 100%;border-radius: 20PX;background: #FF88C2">
				<span id="span1" style="position: absolute;left: 42px;top: 120px"></span>
				<div id="man"
					style="background:url('img/boy.png');position: absolute;right: 10px;top: 80px;height: 50%;width: 50%;background-size:100% 100% ;"></div>
			</div>
		</div>
		<div id="login"
			style="position:absolute;background: #FF88C2;left:380px;top:200px;width: 300px;height:300px;border-radius: 20PX;">
			<div
				style="position:absolute;left:15px;top:12px;font-size: 30;font-family: '楷体'">Login</div>
			<form action="<%=path%>/LoginServlet" method="post">
				<div
					style="position:absolute;left:60px;top:65px;width: 150;height:16px;">
					<input type="text" id="username1" name="username" value="username"
						onclick="reset1('username1')"
						style="padding: 2px 2px 2px 28px;border-radius: 20PX;height: 25px;font-family: '楷体';font-size: 15;">
				</div>
				<div
					style="position:absolute;left:68px;top:69px;width: 16px;height:16px;background: url('img/username.png');background-size:100% 100% "></div>
				<div
					style="position:absolute;left:60px;top:105px;width: 150px;height:16px;">
					<input type="text" id="password1" name="password" value="password"
						onclick="reset1('password1')"
						style="padding: 2px 2px 2px 28px;border-radius: 20PX;height: 25px;font-family: '楷体';font-size: 15">
				</div>
				<div
					style="position:absolute;left:68px;top:109px;width: 16px;height:16px;background: url('img/password.png');background-size:100% 100% "></div>
				<div
					style="position:absolute;left:60px;top:145px;width: 150px;height:16px;">
					<input type="reset" value="Reset"
						style="background:#0066FF;padding: 2px 2px 2px 2px;border-radius: 20PX;width: 195px;height: 28px;text-align:center;font-family: '楷体';font-size: 15;">
				</div>
				<div
					style="position:absolute;left:60px;top:185px;width: 150px;height:16px;">
					<input type="button" value="Register" onclick="misBoy()"
						style="background:#0066FF;padding: 2px 2px 2px 2px;border-radius: 20PX;width: 195px;height: 28px;text-align:center;font-family: '楷体';font-size: 15;">
				</div>
				<div
					style="position:absolute;left:60px;top:225px;width: 150px;height:16px;"><input type="submit" value="Sign in" onclick="checkLgn()"
						style="background:#0066FF;padding: 2px 2px 2px 2px;border-radius: 20PX;width: 195px;height: 28px;text-align:center;font-family: '楷体';font-size: 15;">
				</div>
			</form>
			<div id="girl"
				style="position: absolute;right:0;top: 0;width: 0px;height: 100%;border-radius: 20PX;background: #0066FF">
				
				<span id="span2"
					style="position: absolute;right: 42px;top: 120px;display: none"></span>
				<div id="women"
					style="background:url('img/girl.png');position: absolute;left: 10px;top: 80px;height: 50%;width: 50%;background-size:100% 100%;display:none"></div>
			</div>
		</div>
	</div>
</body>
</html>
