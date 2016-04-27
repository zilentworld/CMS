<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:div>
    <h2>Site Registration</h2>
    <s:form>
		<s:hidden name="blogSiteUrl" value="%{blogSiteUrl}" />
        <s:textfield label="Username" name="siteUser.siteUserUsername" />
        <s:password label="Password" name="siteUser.siteUserPassword" />
        <s:password label="Repeat Password" name="repeatPassword" />
        <s:submit type="button" onclick="form.action='doRegister'; form.submit();" value="Register"/>
    </s:form>
</s:div>