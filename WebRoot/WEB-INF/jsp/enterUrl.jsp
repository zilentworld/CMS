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
	        <div style="margin: 5%;">
		    	<h2>
		    		Enter your URL
		    	</h2>
		    	<s:form method="post">
		    		<s:textfield placeholder="Your URL here" name="siteUrl" />
		    	</s:form>
	    	</div>
		</s:div>
	</s:div>
	<s:form id="idxForm" action="showTemplate">
	</s:form>
	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script>
		$(document).ready(function() {
		});
	</script>
</body>
</html>
