<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form id="form1" method="POST">
    <s:hidden value="%{cmsUserSiteId}" name="cmsUserSiteId" />
    <s:submit type="button" id="backButton" value="Back" />
</s:form>
<s:property value="fileContent" escape="false" />
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
    $(document).ready(function () {
        $('#backButton').click(function () {
            var form = $("#form1")
            form.attr('action', 'CMS');
            form.submit();
        });
    });
</script>