<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div class="welcome-msg">
    <h1 style="text-align:center;">Welcome to MyCMS!</h1>
</s:div>
<s:div class="create-label" id="create-div">
    <h4>
        Create your site now!
    </h4>
</s:div>
<script>
    $(document).ready(function () {
        $("#create-div").click(function () {
            alert("haha");
        });
    });
</script>