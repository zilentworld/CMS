<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Template</title>
</head>
<style>
    .border {
        border: 1px solid black;
    }
    .template {
        height: 50vh;
        width: 50vh;
        float: left;
        margin: 1%;
        cursor: pointer;
    }
    .right-open {
        margin-right: 5px;
    }
    .ov-hidden {
        overflow: hidden;
    }
    h2, h3{
        text-align: center;
    }
</style>
<body>
    <div>
        <div style="height: 75vh;
                    width: 90vw;
                    position:absolute;
	                top:0;
	                bottom: 0;
	                left: 0;
	                right: 0;
	                margin: auto;"
            class="border">
            <s:property value="imgSrc"/>
            <div style="margin: 3%;">
            </div>
        </div>
    </div>
    <s:form id="templateFrm">
    	<s:hidden id="imgSrc"/>
    </s:form>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
    $(document).ready(function(){
    });
</script>
</body>
</html>