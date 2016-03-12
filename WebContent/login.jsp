<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Login</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/style.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>


<body>

	<%@include file="header.jsp"%>



	<!-- Put your page content here! -->




	<form action="LoginServlet" method="post">
		<div class="inputgroup1">
			<div id=submitUser>
				<div class="logForm">
					<div id="logText">
						<div id="inputText">
<%        session.removeAttribute("user");
 %>
							<%
								if (session.getAttribute("username") == null || session.getAttribute("username") == "") {
							%>
							Username: <br> <input type="text" name="username"
								id="usernameIn" aria-describedby="sizing-addon3"><br>

							Password: <br> <input type="password" name="password"
								id="passIn" aria-describedby="sizing-addon3"> <br>
						</div>
						<!-- 						password fail -->
						<%
							if (session.getAttribute("login") == "passFail") {
						%>
						<div id="fail">Incorrect Password</div>
						<!-- 							user not found -->
						<%
							} else if (session.getAttribute("login") == "noUser") {
						%>
						<div id="fail">User not Found</div>
						<a href="register.jsp"> Register New User </a> <br>
						<%
							}
						%>


						<p>You are logged In:</p>
						<button type="submit" class="logBtn" id="submit">Login</button>
						<br> <a href="register.jsp" id="reg">Register Here</a>
						<div id="fail">
							<a href="getpassword.jsp">Forgot password?</a>
						</div>
						<%
							} else {
						%>

						<p>You are logged In:</p>
						<%
							}
						%>
					</div>

				</div>
			</div>
		</div>

	</form>



	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>

</html>
