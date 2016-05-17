<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div class="main-cms">
    <s:div id="main-cms-inner" class="margin3">
        <s:div id="cms-title-div" class="cms-title-div">
            <h1>
                Add New File
            </h1>
        </s:div>
        <s:div id="cms-search-div" class="cms-search-div" style="margin-top: 5%;">
            <s:div class="cms-search-div-inner">
                <form id="searchForm" method="post">
                    <s:hidden value="%{cmsUserSiteId}" name="cmsUserSiteId"/>
                    <s:textfield id="newFileName" name="newFileName"/>
                    <s:submit type="button" theme="simple" value="Go" id="goButton"/>
                    <s:div style="text-align:center;">
                        File Name
                    </s:div>
                </form>
            </s:div>
        </s:div>
    </s:div>
</s:div>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
    $(document).ready(function () {
        $("#goButton").click(function () {
            var form = $("#searchForm");
            alert('Added new File');
            form.attr("action","doAddNewFile");
            form.submit();
        });
    });
</script>