<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
<s:div>
    <s:textarea name="fileContent" value="%{fileContent}"/>
</s:div>
<script>
    tinymce.init({
        selector: 'textarea',
        plugins: "preview"
    });
</script>