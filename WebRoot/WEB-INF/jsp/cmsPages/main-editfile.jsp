<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
<s:div>
    <s:form id="editForm" method="POST" theme="simple">
        <s:hidden value="%{cmsUserSiteId}" name="cmsUserSiteId"/>
        <s:hidden value="%{fileName}" name="fileName"/>
        <s:div>
            <s:textarea name="fileContent" value="%{fileContent}" style="heigth: 75vh"/>
        </s:div>
        <s:div>
            <s:div style="float: right;">
                <s:submit id="cancelButton" type="button" value="Cancel" theme="simple" />
                <s:submit id="saveButton" type="button" value="Save" theme="simple" />
            </s:div>
        </s:div>
    </s:form>
</s:div>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
    $(document).ready(function () {
        $("#cancelButton").click(function () {
            var form = $("#editForm");
            form.attr('action', 'CMS');
            form.submit();
        });
        $("#saveButton").click(function () {
            if (confirm('Do you want to save?')) {
                var form = $("#editForm");
                form.attr('action', 'saveCMS');
                form.submit();
            }
        });
    });

    tinymce.init({
        selector: 'textarea',
        plugins: ["preview", "code", "fullpage"],
        height: "600",
        width: "99%",
        valid_elements : '*[*]'
    });
</script>