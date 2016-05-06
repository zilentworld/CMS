<%@ taglib prefix="s" uri="/struts-tags" %>
<style>
    .border {
        border: 1px solid black;
    }

    .register {
        width: 68vh;
        height: 28vh;
        float: left;
        margin-top: 4vh;
        margin-bottom: 7vh;
        margin-left: 5vh;
        min-height: 175px;
        min-width: 410px;
    }

    .login {
        width: 65vh;
        height: 28vh;
        float: left;
        margin-top: 4vh;
        margin-bottom: 7vh;
        margin-left: 5vh;
        margin-right: 5vh;
        min-height: 150px;
        min-width: 410px;
    }

    .msg {
        margin-top: 3vh;
        margin-left: 3vh;
    }
</style>
<s:div>
        <s:div class="register border">
            <s:div style="margin:2%; height: 94%; width: 96%;">
                Kindly register to continue...
                <s:div style="margin: 2%;">
                    <s:form action="processRegister" method="post">
                        <s:textfield label="Username" placeholder="Username" name="cmsUserRegister.cmsUsername" />
                        <s:textfield label="Password" type="password" placeholder="Password" name="cmsUserRegister.cmsPassword" />
                        <s:textfield label="Re-enter Password" type="password" placeholder="Re-Enter Password" name="repeatPassword" />
                        <s:submit />
                    </s:form>
                </s:div>
            </s:div>
        </s:div>
        <s:div class="login border">
            <s:div style="margin:3%; height: 94%; width: 94%;">
                Or login in on your account
                <s:div style="margin: 2%;">
                    <s:form action="processLogin" method="post">
                        <s:textfield label="Username" name="cmsUser.cmsUsername" placeholder="Username" />
                        <s:textfield label="Password" name="cmsUser.cmsPassword" placeholder="Password" type="password" />
                        <s:submit value="Login" />
                    </s:form>
                </s:div>
            </s:div>
        </s:div>
</s:div>