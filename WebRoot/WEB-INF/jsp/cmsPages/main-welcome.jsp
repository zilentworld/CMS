<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div class="welcome-msg">
    <h1 style="text-align:center;">Welcome to MyCMS!</h1>
</s:div>
<s:if test="'cms_admin'.equals(#session.cms_user.cmsUserType.cmsUserTypeCode)">
    <%--<h1>--%>
        <%--ADMIN--%>
    <%--</h1>--%>
</s:if>
<s:else>
    <s:div class="create-label" id="create-div">
        <h4>
            Create your site now!
        </h4>
    </s:div>
</s:else>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
    $(document).ready(function () {
        $("#create-div").click(function () {
            window.location = 'TemplateList';
        });
    });
</script>