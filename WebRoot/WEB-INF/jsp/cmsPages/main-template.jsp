<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<s:div>
    <s:div style="top: 20;">
        <s:if test="errMsg !=null && errMsg.length() > 0">
            <h3 class="h3-mainTemplate">
                <s:property value="errMsg"/>
            </h3>
        </s:if>
    </s:div>
    <s:div class="template-outer">
        <h2 class="h2-mainTemplate">
            Pick a template
        </h2>
        <s:div style="margin: 3%;">
            <s:div class="template right-open border">
                <img src="<s:url value="/images/template1.png"/>" style="height: 100%; width: 100%"/>
                <h3 class="h3-mainTemplate">
                    Template1
                </h3>
            </s:div>
            <s:div class="template right-open border">
                <img src="<s:url value="/images/template2.png"/>" style="height: 100%; width: 100%"/>
                <h3 class="h3-mainTemplate">
                    Template2
                </h3>
            </s:div>
            <s:div class="template border">
                <img src="<s:url value="/images/template3.png"/>" style="height: 100%; width: 100%"/>
                <h3 class="h3-mainTemplate">
                    Template3
                </h3>
            </s:div>
            <s:div style="clear:both;" />
        </s:div>
    </s:div>
</s:div>
<s:form id="templateFrm">
    <s:hidden id="imgSrc" name="imgSrc"/>
</s:form>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
    $(document).ready(function () {
        $("img").click(function () {
            $("#templateFrm #imgSrc").val($(this).attr('src'));
            $("#templateFrm").attr('action', 'PickTemplate');
            $("#templateFrm").submit();
        });
    });
</script>