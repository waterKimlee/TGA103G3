<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.administrator.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<% 
 AdministratorService adminSvc = new AdministratorService();
 List<AdministratorVO> list = adminSvc.getAll();
 pageContext.setAttribute("list", list);
 
 //把新增有錯誤的物件再傳回來，自動填入新增的輸入框
 AdministratorVO administratorVO = (AdministratorVO) request.getAttribute("administratorVO");

 %>

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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
<style>
* {
	display: absolute;
	border-collapse: collapse;
	/* 	box-sizing: border-box; */
	/* font-family: 微軟正黑體 !important; */
}

p {
	font-size: 60px;
	Font-family: "微軟正黑體";
	font-weight: bold;
	text-shadow: 2px 3px 5px #4d4d4d;
}

header {
	border: 3px solid red;
	height: 100px;
	text-align: center;
}

footer {
	border: 3px solid red;
	display: block;
	margin: 50px 0px 0px 0px;
}

form {
	text-align: center;
	align-items: center;
}

input {
	border-radius: 5px;
	margin: 10px;
	width: 60px;
	text-align: center;
	display: inline-block;
}

table {
	margin-top: 10px;
	border: 5px solid black;
}

th {
	font-size: 30px;
	background-color: lightblue;
}

tr {
	border: 4px solid black;
}

td {
	border: 2px solid black;
	height: 56px;
}

a {
	display: block;
	text-decoration: none;
	color: black;
	background-color: rgb(154, 190, 232);
	border-radius: 5px;
	margin-top: 5px;
	text-align: center;
	box-shadow: 2px 3px 2px #4d4d4d;
}

a.admin {
	border: 2px solid red;
}

h2 {
	display: inline-block;
	/* text-align: center; */
}

h1 {
	margin-top: 10px;
}

img.logo {
	display: none;
}

img.-on {
	position: absolute;
	width: 250px;
	left: 100px;
	background-position: top;
	top: 15px;
	left: 15px;
	display: flex;
}

#logout {
	position: absolute;
	right: 0;
	top: 30px;
}

.form-control {
	margin-left: 0;
}

#addBtn {
	display: inline-block;
	width: 100px;
	background-color: rgb(154, 190, 232);
	line-height: 55px;
	margin-bottom: 20px;
	box-shadow: 2px 3px 5px #4d4d4d;
	text-shadow: 1px 1px 1px #4d4d4d;
}
</style>
</head>

<body>
	<header>
		<div id="header" class="row">
			<img class="logo -on" src="./images/logo_navy2.png" alt="logo" />

			<p>管理者頁面${admin.administratorId}</p>

			<!-- <FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/administrator/admin.do"
				>
				<input id="logout" type="submit" value="登出"> <input type="hidden"
					name="administratorId" value="${administratorVO.administratorId}">
				<input type="hidden" name="action" value="delete">
			</FORM> -->

		</div>


	</header>
	<div class="container">
		<div class="row justify-content-center" style="width: 100%">
			<div class="col-1"></div>
			<div class="col-2">
				<a href="administrator.html" class="admin">管理者資料</a>
			</div>
			<div class="col-2">
				<a href="administrator_store.html">商家管理</a>
			</div>
			<div class="col-2">
				<a href="administrator_user.htmlhtml">會員管理</a>
			</div>
			<div class="col-2">
				<a href="administrator_history.html">歷史訂單</a>
			</div>
			<div class="col-2">
				<a href="administrator_report.html">檢舉信件</a>
			</div>
			<div class="col-1"></div>
		</div>
		<h1>管理者資料</h1>
		<br> <br> <input id="addBtn" type="submit" value="新增管理者"
			data-bs-toggle="modal" data-bs-target="#addAdmin">
		<!-- 		<a id="addBtn" href="#" type="button" -->
		<!-- 			data-bs-toggle="modal" data-bs-target="#addAdmin">新增管理者</a> -->

		<div class="modal fade" id="addAdmin">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<div>
							<c:if test="${not empty errorMsgs}">
								<ul>
									<c:forEach var="message" items="${errorMsgs}">
										<li style="color: red">${message}</li>
									</c:forEach>
								</ul>
							</c:if>

						</div>

						<h3>新增管理者</h3>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
						<div></div>
					</div>
					<div class="modal-body">
						<!-- 新增管理者 -->
						<form
							action="<%=request.getContextPath()%>/administrator/admin.do"
							method="post">
							<div class="form-group">
								帳號：<input type="email" class="account form-control"
									maxlength="40" placeholder="新增帳號" required
									value="<%=(administratorVO == null) ? "" : administratorVO.getAdministratorAccount()%>"
									name="administratorAccount">
							</div>
							<div class="form-group">
								密碼：<input type="password" id="addInputPassword" minlength="8"
									class="account form-control" placeholder="請輸入密碼" required
									value="<%=(administratorVO == null) ? "" : administratorVO.getAdministratorPassword()%>"
									maxlength="10" name="administratorPassword">
							</div>
							<div class="form-group">
								確認密碼：<input type="password" id="addConfirmPassword"
									minlength="8" class="account form-control" placeholder="再次輸入密碼"
									required
									value="<%=(administratorVO == null) ? "" : administratorVO.getAdministratorPassword()%>"
									required maxlength="10">
								<!-- 									onchange="if(document.getElementById('addInputPassword').value != document.getElementById('addConfirmPassword').value){setCustomValidity('密碼不吻合');}"> -->
							</div>
							<div class="form-group">
								名稱：<input type="text" class="account form-control"
									maxlength="10" placeholder="請輸入名稱" required
									value="<%=(administratorVO == null) ? "" : administratorVO.getAdministratorName()%>"
									name="administratorName">
							</div>
							<div class="form-group">
								電話：<input type="number" class="account form-control"
									maxlength="10" placeholder="請輸入電話" required minlength="8"
									value="<%=(administratorVO == null) ? "" : administratorVO.getAdministratorPhone()%>"
									name="administratorPhone">
							</div>
							<input type="hidden" name="administratorRight" value="1">
							<input type="hidden" name="administratorId"
								value="${admin.administratorId}">

							<button id="addAdminBtn" type="submit" name="action"
								value="insert">確認新增</button>
						</form>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="updateAdmin">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<div>
							<c:if test="${not empty errorMsgs}">
								<ul>
									<c:forEach var="message" items="${errorMsgs}">
										<li style="color: red">${message}</li>
									</c:forEach>
								</ul>
							</c:if>
						</div>
						<hr>
						<h3>修改資料</h3>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>
					<div class="modal-body">
						<!-- 修改資料 -->
						<form
							action="<%=request.getContextPath()%>/administrator/admin.do"
							method="post">
							<div class="form-group">
								<input type="hidden" class="account form-control" name="adminId"
									value="${admin.administratorId}">
							</div>
							<div class="form-group">
								<input type="hidden" class="account form-control" id="id"
									name="administratorId" value="${admin.administratorId}">
							</div>
							<div class="form-group">
								帳號：<input type="text" class="account form-control" readonly
									name="administratorAccount" id="account"
									value="${admin.administratorAccount}">
							</div>
							<div class="form-group">
								名稱：<input type="text" class="account form-control"
									maxlength="10" placeholder="請輸入名稱" required id="name"
									name="administratorName" value="${admin.administratorName}">
							</div>
							<div class="form-group">
								密碼：<input type="password" id="updateInputPassword" required
									maxlength="10" minlength="8" class="account form-control"
									placeholder="請輸入新密碼" value="${admin.administratorPassword}"
									required name="administratorPassword">
							</div>
							<div class="form-group">
								確認密碼：<input type="password" id="updateConfirmPassword" required
									maxlength="10" minlength="8" class="account form-control"
									placeholder="再次輸入密碼" required
									value="${admin.administratorPassword}"
									onchange="if(document.getElementById('updateInputPassword').value != document.getElementById('updateConfirmPassword').value){setCustomValidity('密碼不吻合');}">
							</div>
							<div class="form-group">
								電話：<input type="number" class="account form-control"
									minlength="8" maxlength="10" placeholder="請輸入電話" required
									id="phone" name="administratorPhone"
									value="${admin.administratorPhone}">
							</div>
							<input type="hidden" name="administratorRight" value="1">
							<button type="submit" name="action" value="update">確認修改</button>

						</form>
						<div class="modal-footer"></div>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>



		<h2>目前登入人員：${admin.administratorName}</h2>
		<div class="row d-flex justify-content-center align-content-center"
			style="text-align: center" style="height: 600px;">
			<table>
				<tr>
					<th>編號</th>
					<th>帳號</th>
					<!-- 					<th>密碼</th> -->
					<th>名稱</th>
					<th>電話</th>
					<th>建立時間</th>
					<th>修改</th>
					<th>刪除</th>
				</tr>

				<c:forEach var="administratorVO" items="${list}" begin="0" end="10"
					varStatus="s">

					<tr>
						<td>${administratorVO.administratorId}</td>
						<td>${administratorVO.administratorAccount}</td>
						<%-- 						<td>${administratorVO.administratorPassword}</td> --%>
						<td>${administratorVO.administratorName}</td>
						<td>${administratorVO.administratorPhone}</td>
						<td>${administratorVO.administratorAccountBuildTime}</td>

						<!-- 	修改按鈕-->
						<c:if test="${admin.administratorRight == 0 }">
							<td><input id="inputUpdate" type="submit" value="修改"
								class="updateBtn" data-bs-toggle="modal"
								data-bs-target="#updateAdmin"> <input type="hidden"
								name="administratorId" value="${admin.administratorId}">
							</td>
						</c:if>
						<c:if test="${admin.administratorRight == 1 }">
							<c:if
								test="${admin.administratorAccount == administratorVO.administratorAccount }">
								<td><input id="inputUpdate" type="submit" value="修改"
									class="updateBtn" data-bs-toggle="modal"
									data-bs-target="#updateAdmin"> <input type="hidden"
									name="administratorId" value="${admin.administratorId}">
								</td>
							</c:if>
						</c:if>
						<!-- 刪除按鈕  -->
						<td>
							<!-- 權限為0者才能使用刪除按鈕  --> <c:if
								test="${admin.administratorRight == 0 }">
								<FORM METHOD="post"
									ACTION="<%=request.getContextPath()%>/administrator/admin.do"
									style="margin-bottom: 0px;">
									<input type="submit"
										onclick="onRemoveClick(${administratorVO.administratorId})"
										value="刪除" class="deleteBtn"> 
										<input type="hidden" name="action" value="delete"> 
										<input type="hidden" name="administratorId"
										value="${administratorVO.administratorId}"> 
										<input	type="hidden" class="account form-control" 
										name="adminId" value="${admin.administratorId}">
								</FORM>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
	<footer>footer</footer>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		
		
	
		//選擊列表刪除時，記下當行列表中的個人資訊
		let deleId, id, account, name, phone;
		$(document).on("mouseover", ".deleteBtn", function(){
			
			 deleId = $(this).closest("tr").find("td").eq(0).text();
// 			 $(".deleteBtn").val(deleId);
			console.log(deleId)
		});

		//選擊列表修改時，記下當行列表中的個人資訊
		$(document).on("mouseover", "#inputUpdate", function(){
			  id = $(this).closest("tr").find("td").eq(0).text();
	    	  account = $(this).closest("tr").find("td").eq(1).text();
// 	    	  password = $(this).closest("tr").find("td").eq(2).text();
	    	  name = $(this).closest("tr").find("td").eq(2).text();
	    	  phone = $(this).closest("tr").find("td").eq(3).text();
	    	  $("#id").val(id);
	    	  $("#account").val(account);
// 	    	  $("#updateInputPassword").val(password);
// 	    	  $("#updateConfirmPassword").val(password);
	    	  $("#name").val(name);
	    	  $("#phone").val(phone);
	    	  
	    	  
	    	  console.log(id, account, name, phone);
	      });
		
		window.addEventListener("load", () => {
			//有輸入錯誤訊號則跳回到當時視窗
//				var v = ${errorMsgs};
 		      if (${errorMsgs} != "" ){
 		    	var x = ${errorMsgs}.pop();
 		    	if (x.length == 3){
		    		$("#inputUpdate").trigger("click");
		    	}else{
		    		$("#addBtn").trigger("click");
 		    	}
 		      };
// 		      var save = $(document).on("click", ".deleteBtn",function() {
// 			        var f = eval(this.getAttribute("form"));
// 			        if (confirm('确定修改？')) {
// 			            // TODO
// 			            f.submit();
// 			        } else {
// 			            f.onsubmit = new Function("return false");
// 			        }
			    
// 	    	});
		});
// 		function onRemoveClick(id) {
// 		    if (!confirm('確定刪除?')) {
// 		        return;
// 		    }
// 		    let form_data = new FormData();
// 		    form_data.append("action", "delete");
// 		    form_data.append("administratorId", id);
// 		    form_data.append("adminId", "${admin.administratorId}");
<%-- 		    fetch("<%=request.getContextPath()%>/administrator/admin.do", { --%>
// 		        method: 'POST',
// 		        body: form_data
// 		    });
		    
// 		}
// 		        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
	</script>

</body>

</html>