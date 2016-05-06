<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style>
    .welcome-msg {
        top: 0;
        bottom: 260px;
        left: 0;
        right: 0;
        margin-right: auto;
        margin-left: auto;
        margin-top: 10vh;
    }
    .create-label {
        border: 1px solid black;
        height: 75px;
        width: 270px;
        text-align: center;
        margin-right: auto;
        margin-left: auto;
        margin-top: 10vh;
        cursor: pointer;
    }
</style>
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