<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Register to continue</title>
</head>
<style>
.border {
	border: 1px solid black;
}

.register {
	width: 55%;
	height: 80%;
	float: left;
	margin-top: 4vh;
	margin-bottom: 7vh;
	margin-left: 5vh;
}

.login {
	width: 35%;
	height: 80%;
	float: left;
	margin-top: 4vh;
	margin-bottom: 7vh;
	margin-left: 5vh;
	margin-right: 5vh;
}

.msg {
	margin-top: 3vh;
	margin-left: 3vh;
}
</style>
<body>
	<s:div>
		<s:div
			style="height: 75vh;
                    width: 90vw;
                    position:absolute;
	                top:0;
	                bottom: 0;
	                left: 0;
	                right: 0;
	                margin: auto;"
			class="border">
			<s:div class="msg">
            You have picked the template: <s:property
					value="#session.cms_template.templateName" />
			</s:div>
			<s:div class="register border">
				<s:div style="margin:2%; height: 94%; width: 96%;">
            	Kindly register to continue...
            	<s:div style="margin: 2%;">
						<s:form action="processRegister" method="post">
							<s:hidden name="nextAction" value="showTemplate.action" />
							<s:textfield label="Username" placeholder="Username" name="cmsUserRegister.cmsUsername" />
							<s:textfield label="Password" type="password" placeholder="Password" name="cmsUserRegister.cmsPassword" />
							<s:textfield label="Re-enter Password" type="password" placeholder="Re-Enter Password" name="repeatPassword" />
							<s:submit />
						</s:form>
					</s:div>
				</s:div>
			</s:div>
			<s:div class="login border">
				<s:div style="margin:3%; height: 94%; width: 94%;">
            	Or login in on your account
	            	<s:div style="margin: 2%;">
						<s:form action="processLogin" method="post">
							<s:textfield label="Username" name="cmsUser.cmsUsername" placeholder="Username" />
							<s:textfield label="Password" name="cmsUser.cmsPassword" placeholder="Password" type="password" />
							<s:submit value="Login" />
						</s:form>
					</s:div>
            	</s:div>
			</s:div>
		</s:div>
	</s:div>
	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script>
		$(document).ready(function() {
		});
	</script>
</body>
</html>