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
        <s:div style="text-align:center; margin-top: 10%;">
            <h1>
                <s:property value="msg" />
            </h1>
        </s:div>
    </s:div>
</s:div>
<form id="idxForm" action="showTemplate">
</form>
<script src="http//code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
    $(document).ready(function() {
    });
</script>
</body>
</html>
