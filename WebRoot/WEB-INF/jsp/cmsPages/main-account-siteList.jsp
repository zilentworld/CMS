<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<style>
    .account-header-tab {
        height: 5vh;
        min-height: 35px;
    }

    .account-headers {
        float: right;
        margin-top: 2.5vh;
        margin-right: 5vh;
    }

    .account-header {
        float: left;
    }

    .account-content {
        border-top: 1px solid black;
    }

    .account-outer {
        height: 100%;
    }
</style>
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
                            <s:submit type="button" theme="simple" value="CMS"/>
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
        </s:div>
    </s:div>
</s:div>