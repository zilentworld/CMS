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
            <form id="userSiteForm" method="POST">
                <s:hidden id="cmsUserSiteId" name="cmsUserSiteId" value=""/>
                <s:hidden value="" id="fileName" name="fileName" />
                <table width="100%">
                    <tr>
                        <th>
                            Site Name
                        </th>
                        <th>
                            Template
                        </th>
                        <th>
                            Status
                        </th>
                        <th>
                            Action
                        </th>
                    </tr>
                    <s:iterator value="cmsUserSiteList">
                        <tr align="center">
                            <td>
                                <s:property value="blogUrl"/>
                            </td>
                            <td>
                                <s:property value="cmsTemplates.templateName"/>
                            </td>
                            <td>
                                <s:if test="isPublished > 0">
                                    Published
                                </s:if>
                                <s:else>
                                    Not yet published
                                </s:else>
                            </td>
                            <td>
                                <%--<s:submit type="button" hidden-data="%{cmsUserSiteId}" class="previewCMS" value="Preview" theme="simple"/>--%>
                                <s:submit type="button" hidden-data="%{cmsUserSiteId}" class="editCMS" value="CMS"
                                          theme="simple"/>
                                <s:if test="isPublished == 1" >
                                    <s:submit type="button" hidden-data="%{blogUrl}" class="goToSite" value="Go to Site" theme="simple"/>
                                </s:if>
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
        $(".editCMS").click(function () {
            var hiddenField = $("#cmsUserSiteId");
            var form = $("#userSiteForm");
            var id = $(this).attr('hidden-data');
            hiddenField.val(id);
            form.attr('action', 'CMS');
            form.submit();
        });
        $(".previewCMS").click(function () {
            var hiddenField = $("#cmsUserSiteId");
            var form = $("#userSiteForm");
            var id = $(this).attr('hidden-data');
            hiddenField.val(id);
            form.attr('action', 'Preview');
            form.submit();
        });
        $(".goToSite").click(function () {
//            alert("goToSite");
            var form = $("#userSiteForm");
            var siteUrl = $(this).attr('hidden-data');
//            alert(siteUrl);
            form.attr('action', siteUrl);
            form.submit();
        });
    });
</script>