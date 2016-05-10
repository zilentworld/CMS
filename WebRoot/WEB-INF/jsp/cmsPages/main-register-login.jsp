<%@ taglib prefix="s" uri="/struts-tags" %>
<style>
</style>
<s:div>
    <s:div class="register border">
        <s:div style="margin:2%; height: 94%; width: 96%;">
            Kindly register to continue...
            <s:div style="margin: 2%;">
                <s:form action="processRegister" method="post">
                    <s:textfield label="Username" placeholder="Username" name="cmsUserRegister.cmsUsername"/>
                    <s:textfield label="Password" type="password" placeholder="Password"
                                 name="cmsUserRegister.cmsPassword"/>
                    <s:textfield label="Re-enter Password" type="password" placeholder="Re-Enter Password"
                                 name="repeatPassword"/>
                    <s:submit/>
                </s:form>
            </s:div>
        </s:div>
    </s:div>
    <s:div class="login border">
        <s:div style="margin:3%; height: 94%; width: 94%;">
            Or login in on your account
            <s:div style="margin: 2%;">
                <s:form action="processLogin" method="post">
                    <s:textfield label="Username" name="cmsUser.cmsUsername" placeholder="Username"/>
                    <s:textfield label="Password" name="cmsUser.cmsPassword" placeholder="Password" type="password"/>
                    <s:submit value="Login"/>
                </s:form>
            </s:div>
        </s:div>
    </s:div>
</s:div>