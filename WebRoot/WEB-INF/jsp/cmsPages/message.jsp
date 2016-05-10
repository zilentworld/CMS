<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cms-global.css" />
<body>
<s:div>
    <s:div class="message-outer">
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
