<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<s:div class="account-outer">
    <s:div class="account-header-tab">
        <s:div class="account-headers">
            <s:if test="'cms_admin'.equals(#session.cms_user.cmsUserType.cmsUserTypeCode)">
                <%--admin--%>
                <s:div class="account-header">
                    <s:a href="SiteList">
                        Site List
                    </s:a>
                </s:div>
                <s:div class="account-header">
                    &nbsp;|&nbsp;
                </s:div>
                <s:div class="account-header">
                    <s:a href="UserList">
                        User List
                    </s:a>
                </s:div>
            </s:if>
            <s:else>
                <%--user--%>
                <s:div class="account-header">
                    <s:a href="UserSites">
                        My Sites
                    </s:a>
                </s:div>
                <s:div class="account-header">
                    &nbsp;|&nbsp;
                </s:div>
                <s:div class="account-header">
                    <s:a href="UserInfo">
                        My Info
                    </s:a>
                </s:div>
            </s:else>
        </s:div>
    </s:div>
    <s:div class="account-content">
        <s:div class="account-content-inner">
            <form id="siteListForm" method="POST">
                <s:hidden id="cmsUserSiteId" name="cmsUserSiteId" value="" />
                <table style="width : 100%; text-align: center;">
                    <tr>
                        <th>
                            Site Name
                        </th>
                        <th>
                            Site Owner
                        </th>
                        <th colspan="3">
                            Action
                        </th>
                    </tr>
                    <s:iterator value="cmsUserSiteList">
                        <tr>
                            <td>
                                <s:property value="blogUrl"/>
                            </td>
                            <td>
                                <s:property value="cmsUser.cmsUsername"/>
                            </td>
                            <td>
                                <s:submit class="CMS" hidden-data="%{cmsUserSiteId}" type="button" theme="simple" value="CMS"/>
                            </td>
                            <td>
                                <s:submit type="button" theme="simple" value="Preview"/>
                            </td>
                            <td>
                                <s:submit type="button" theme="simple" value="Publish"/>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </form>
        </s:div>
    </s:div>
</s:div>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
    $(document).ready(function () {
        $(".CMS").click(function () {
            var hiddenField = $("#cmsUserSiteId");
            var form = $("#siteListForm");
            var id = $(this).attr('hidden-data');
            hiddenField.val(id);
            form.attr('action','CMS');
            form.submit();
        });
    });
</script>