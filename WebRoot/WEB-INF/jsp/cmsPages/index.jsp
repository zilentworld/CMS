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
			<s:div>
				<s:div
					style="width:400px;
                            height:30px;
                            position:absolute;
	                        top:0;
	                        bottom: 260px;
	                        left: 0;
	                        right: 0;
	                        margin: auto;">
					<h2 style="text-align:center;">Welcome to MyCMS!</h2>
				</s:div>
				<s:div id="createBlogSite"
					style="border:1px solid black;
                            height: 30px;
                            width: 200px;
                            position:absolute;
	                        top:0;
	                        bottom: 100px;
	                        left: 0;
	                        right: 0;
	                        margin: auto;
	                        cursor: pointer;
	                        ">
					<s:div style="margin:2%;">
						<label style="margin:5%; cursor: pointer; text-align: center;">
							Create New Blog Site 
						</label>
					</s:div>
				</s:div>
				<s:div
					style="width:400px;
                            height:30px;
                            position:absolute;
	                        top:0;
	                        bottom: 40px;
	                        left: 0;
	                        right: 0;
	                        margin: auto;">
					<h4 style="text-align:center;">or</h4>
				</s:div>
				<s:div id="loginCMS"
					style="border:1px solid black;
                            height: 30px;
                            width: 70px;
                            position:absolute;
	                        top:0;
	                        bottom: -80px;
	                        left: 0;
	                        right: 0;
	                        margin: auto;
	                        cursor: pointer;">
					<s:div style="margin:5%;">
						<label style="margin:5%; cursor: pointer; text-align: center;">
							Login 
						</label>
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
				var frm = $("#idxForm");
   				frm.attr('action', 'showCmsLogin');
				frm.submit();
			});
		});
	</script>
</body>
</html>
