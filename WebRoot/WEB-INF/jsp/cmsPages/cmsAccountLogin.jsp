<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<s:div>
		<s:div
			style="border:1px solid black;
                    height:600px;
                    width:1000px;
                    position:absolute;
	                top:0;
	                bottom: 0;
	                left: 0;
	                right: 0;
	                margin: auto;">
			<s:div style="margin: auto;">
				<s:div style="margin:4%;">
            	Enter your account details
	            	<s:div style="margin: 2%;">
						<s:form action="doCmsLogin" method="post">
							<s:hidden name="cmsTemplateId" value="%{cmsTemplateId}" />
							<s:textfield label="Username" name="cmsUser.cmsUsername" placeholder="Username" />
							<s:textfield label="Password" name="cmsUser.cmsPassword" placeholder="Password" type="password" />
							<s:submit value="Login" />
						</s:form>
					</s:div>
            	</s:div>
			</s:div>
		</s:div>
	</s:div>
	<s:form id="idxForm" action="showTemplate">
	</s:form>
	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#createBlogSite").click(function() {
				var frm = $("#idxForm");
   				frm.attr('action', 'showTemplate');
				frm.submit();
			});
			$("#loginCMS").click(function() {
				alert("LOGIN CMS");
			});
		});
	</script>
</body>
</html>
