<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div class="main-cms">
    <s:div id="main-cms-inner" class="margin3">
        <s:div id="cms-title-div" class="cms-title-div">
            <h1>
                <s:property value="cmsUserSite.blogUrl"/>
            </h1>
        </s:div>
        <s:div id="cms-search-div" class="cms-search-div">
            <s:div class="cms-search-div-inner">
                <form id="searchForm" method="post" action="FilterCMS">
                    <s:hidden value="%{cmsUserSite.cmsUserSiteId}" name="cmsUserSiteId"/>
                    <s:textfield id="searchParameter" name="searchFile"/>
                    <s:submit type="button" theme="simple" value="Go"/>
                    <s:div style="text-align:center;">
                        Search
                    </s:div>
                </form>
            </s:div>
        </s:div>
        <s:div id="cms-files-div" class="cms-files-div border">
            <form id="filesForm" method="post">
                <s:hidden value="" id="fileName" name="fileName"/>
                <s:hidden value="%{cmsUserSite.cmsUserSiteId}" name="cmsUserSiteId"/>
                <table width="100%">
                    <tr>
                        <th>
                            File Name
                        </th>
                        <th>
                            Path
                        </th>
                        <th colspan="2">
                            Action
                        </th>
                    </tr>
                    <s:iterator value="fileList">
                        <tr>
                            <td>
                                <s:set var="filename" value="%{getName()}"/>
                                <s:property value="#filename"/>
                            </td>
                            <td>
                                <s:set var="parent" value="%{getParent()}"/>
                                <s:set var="parentFolder" value="parent.substring(parent.lastIndexOf('/'))"/>
                                <s:property value="#parentFolder"/>
                                <s:property value="%{getPath()}"/>
                            </td>
                            <td>
                                <s:submit class="Edit" hidden-data="%{#filename}" type="button" value="Edit" theme="simple"/>
                            </td>
                            <td>
                                <s:submit class="Preview" hidden-data="%{#filename}" type="button" value="Preview" theme="simple"/>
                            </td>
                            <td>
                                <s:submit class="Delete" hidden-data="%{#filename}" type="button" value="Delete" theme="simple"/>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </form>
        </s:div>
        <s:div class="cms-buttons">
            <s:submit type="button" id="addFile" value="Add File" theme="simple"/>
        </s:div>
    </s:div>
</s:div>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
    $(document).ready(function () {
        $('.Edit').click(function () {
            var id = $(this).attr('hidden-data');
            var hiddenField = $("#fileName");
            var form = $("#filesForm")
            hiddenField.val(id);
            form.attr('action', 'EditFile');
            form.submit();
        });
        $(".Preview").click(function () {
            var hiddenField = $("#fileName");
            var form = $("#filesForm");
            var id = $(this).attr('hidden-data');
            hiddenField.val(id);
            form.attr('action', 'Preview');
            form.submit();
        });
        $(".Delete").click(function () {
            var hiddenField = $("#fileName");
            var form = $("#filesForm");
            var id = $(this).attr('hidden-data');
            hiddenField.val(id);
            form.attr('action', 'DeleteFile');
            form.submit();
        });
        $("#addFile").click(function () {
            var form = $("#filesForm");
            form.attr('action', 'AddNewFile');
            form.submit();
        });
    });
</script>