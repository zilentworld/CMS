<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div>
		<div
			style="border:1px solid black;
                    height:600px;
                    width:1000px;
                    position:absolute;
	                top:0;
	                bottom: 0;
	                left: 0;
	                right: 0;
	                margin: auto;">
			<div>
				<div
					style="width:400px;
                            height:30px;
                            position:absolute;
	                        top:0;
	                        bottom: 260px;
	                        left: 0;
	                        right: 0;
	                        margin: auto;">
					<h2 style="text-align:center;">Welcome to MyCMS!</h2>
				</div>
				<div id="createBlogSite"
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
					<div style="margin:2%;">
						<label style="margin:5%; cursor: pointer; text-align: center;">
							Create New Blog Site 
						</label>
					</div>
				</div>
				<div
					style="width:400px;
                            height:30px;
                            position:absolute;
	                        top:0;
	                        bottom: 40px;
	                        left: 0;
	                        right: 0;
	                        margin: auto;">
					<h4 style="text-align:center;">or</h4>
				</div>
				<div id="loginCMS"
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
					<div style="margin:5%;">
						<label style="margin:5%; cursor: pointer; text-align: center;">
							Login 
						</label>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form id="idxForm" action="showTemplate.action">
	</form>
	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#createBlogSite").click(function() {
				alert("WELCOME!");
				var frm = $("#idxForm");
   				frm.attr('action', 'showTemplate.action');
				frm.submit();
			});
			$("#loginCMS").click(function() {
				alert("LOGIN CMS");
			});
		});
	</script>
</body>
</html>