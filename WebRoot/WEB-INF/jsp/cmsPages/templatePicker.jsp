<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Template</title>
</head>
<body>
    <s:div>
    	<s:div style="top: 20;">
    		<s:if test="errMsg !=null && errMsg.length() > 0">
    			<h3 class="h3-templatePicker">
    				<s:property value="errMsg"/>
    			</h3>
    		</s:if>
    	</s:div>
        <s:div style="height: 75vh;
                    width: 90vw;
                    position:absolute;
	                top:0;
	                bottom: 0;
	                left: 0;
	                right: 0;
	                margin: auto;"
            class="border">
            <h2 class="h2-templatePicker">
                Pick a template
            </h2>
            <s:div style="margin: 3%;">
                <s:div class="template right-open border" id="ww">
                    <img src="<s:url value="/images/template1.png"/>" style="height: 100%; width: 100%"/>
                    <h3 class="h3-templatePicker">
                        Template1
                    </h3>
                </s:div>
                <s:div class="template right-open border">
                    <img src="<s:url value="/images/template2.png"/>" style="height: 100%; width: 100%" />
                    <h3 class="h3-templatePicker">
                        Template2
                    </h3>
                </s:div>
                <s:div class="template border">
                    <img src="<s:url value="/images/template3.png"/>" style="height: 100%; width: 100%" />
                    <h3 class="h3-templatePicker">
                        Template3
                    </h3>
                </s:div>
                <s:div style="clear:both;">

                </s:div>
            </s:div>
        </s:div>
    </s:div>
    <s:form id="templateFrm">
    	<s:hidden id="imgSrc" name="imgSrc" />
    </s:form>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
    $(document).ready(function(){
        $("img").click(function(){
        	$("#templateFrm #imgSrc").val($(this).attr('src'));
   			$("#templateFrm").attr('action', 'pickTemplate');
        	$("#templateFrm").submit();
        });
    });
</script>
</body>
</html>