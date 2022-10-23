<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.fastero.vo.*"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>管理者頁面</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<style>
* {
	display: absolute;
	box-sizing: border-box;
	font-family: 微軟正黑體 !important;
	/* background: rgb(147, 162, 171); */
}

footer {
	/* border: 1px solid red; */
	display: block;
	margin: 50px 0px 0px 0px;
}

label {
	display: inline-block;
	width: 100px;
}

input {
	border-radius: 15px;
	margin: 10px;
	width: 250px;
}

.submit {
	width: 100%;
	margin: 10px 0 0 0;
}

form {
	padding: 50px;
}

h2 {
	text-align: center;
	/* margin: 20px 0 0 0; */
}

h1 {
	text-align: center;
	font-size: 80px;
}

.row {
	background: rgb(208, 127, 127);
	width: 100%;
}

.logo {
	position: absolute;
	width: 250px;
	left: 100px;
	background-position: top;
	top: -55px;
	left: 15px;
	display: flex;
}

#header {
	background: rgb(255, 255, 255);
}

li {
	text-align: center;
	list-style: none;
}

.footer {
	width: 100%;
	margin-bottom: 20px;
}
</style>
</head>

<body>
	<header>
		<div id="header" class="row">
			<img class="logo" src="./administrator/images/logo_navy.png"
				alt="logo" />

			<h1>管理者頁面</h1>
		</div>


	</header>
	<div class="container">
		<div class="row">
			<div
				class="col-12 d-flex justify-content-center align-content-center">

				<form action="<%=request.getContextPath()%>/adminLogin"
					method="post">

					<h2>管理者登入</h2>

					<label for="administratorAccount">管理者帳號：</label> <input
						type="email" id="administratorAccount" name="administratorAccount"
						placeholder="請輸入帳號" required>
					<div class="tab"></div>

					<label for="administratorPassword">密碼：</label> <input
						type="password" id="administratorPassword"
						name="administratorPassword" placeholder="請輸入密碼" required>
					<div class="tab"></div>
					<br> <input type="submit" value="確認登錄" class="submit">
					<input type="hidden" name="action" value="login">

					<!-- <input type="submit" value="確認登錄" class="submit" > -->
				</form>
			</div>
		</div>
		<c:if test="${not empty errorMsgs}">

			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

	</div>
	<footer>
		<img class="footer" src="./administrator/images/footer.png" alt="" />
	</footer>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		
	</script>
</body>

</html>