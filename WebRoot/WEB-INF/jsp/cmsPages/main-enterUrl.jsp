<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div style="margin: 5%;">
    <h2>
        Enter your URL
    </h2>
    <s:form method="post" action="ConfirmUrl">
        <s:if test="msgError != null && msgError.length() > 0">
            <h2>
                <s:property value="msgError" />
            </h2>
        </s:if>
        <s:hidden name="cmsTemplateId" value="%{cmsTemplateId}" />
        <s:textfield placeholder="Your URL here" name="urlName" />
        <s:submit />
    </s:form>
</s:div>