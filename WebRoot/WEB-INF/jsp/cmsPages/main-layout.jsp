<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
</head>

<style>
    .outside {
        border:1px solid black;
        height:90vh;
        width:150vh;
        position:absolute;
        top:0;
        bottom: 0;
        left: 0;
        right: 0;
        margin: auto;
        min-height: 800px;
        min-width: 800px;
    }
    .inner {
        border-top: solid black 1px;
        height: 83vh;
        width: 100%;
    }
    .header {
        height: 7vh;
        width: 100%;
    }
    .header-buttons {
        float: right;
        margin-top: 2.5vh;
        margin-right: 5vh;
    }
    .header-name {
        float: left;
        margin-top: 2.5vh;
        margin-left: 5vh;
    }
    .header-button {
        float: left;
    }
</style>
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
            <tiles:insertAttribute name="content" ignore="true" />
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