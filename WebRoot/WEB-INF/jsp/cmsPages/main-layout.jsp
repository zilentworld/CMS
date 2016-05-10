<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cms-global.css" />
<body>
<s:div>
    <s:div class="outside">
        <s:div class="header">
            <s:if test="#session.cms_user.cmsUserId > 0">
                <s:div class="header-name">
                    Hi <s:property value="#session.cms_user.cmsUsername" />!
                </s:div>
            </s:if>
            <s:div class="header-buttons">
                <s:div class="header-button">
                    <s:a href="Home" >
                        Home
                    </s:a>
                </s:div>
                <s:div class="header-button">
                    &nbsp;|&nbsp;
                </s:div>
                <s:div class="header-button">
                    <s:a href="Account">
                        Account
                    </s:a>
                </s:div>
                <s:div class="header-button">
                    &nbsp;|&nbsp;
                </s:div>
                <s:div class="header-button">
                    <s:a href="About">
                        About
                    </s:a>
                </s:div>
                <s:div class="header-button">
                    &nbsp;|&nbsp;
                </s:div>
                <s:div class="header-button">
                    <s:a href="ContactUs">
                        Contact Us
                    </s:a>
                </s:div>
                <s:if test="#session.cms_user.cmsUserId > 0">
                    <s:div class="header-button">
                        &nbsp;|&nbsp;
                    </s:div>
                    <s:div class="header-button">
                        <s:a href="Logout">
                            Logout
                        </s:a>
                    </s:div>
                </s:if>
            </s:div>
        </s:div>
        <s:div class="inner">
            <tiles:insertAttribute name="content" ignore="true" >
                <tiles:insertAttribute name="accountContent" ignore="true" />
            </tiles:insertAttribute>
        </s:div>
    </s:div>
</s:div>
<s:form id="idxForm" action="showTemplate">
</s:form>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
    $(document).ready(function() {
//        $("a").click(function () {
//            window.location = $(this).attr('href');
//        })
    });
//    function callAction(action) {
//        window.location = action;
//    }
</script>
</body>
</html>