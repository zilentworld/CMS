<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:div>
    <h2>Users Login</h2>
    <s:if test="msg != null && msg.length() > 0">
    	<s:label>
    		<s:property value="msg"/>
    	</s:label>
    </s:if>
    <s:form method="post">
		<s:hidden name="blogSiteUrl" value="%{blogSiteUrl}" />
        <s:textfield label="Username" name="siteUser.siteUserUsername" />
        <s:password label="Password" name="siteUser.siteUserPassword" />
        <s:submit type="button" onclick="form.action='doLogin'; form.submit();" value="Login"/>
        <s:submit type="button" onclick="form.action='showRegister'; form.submit();" value="Register"/>
    </s:form>
</s:div>