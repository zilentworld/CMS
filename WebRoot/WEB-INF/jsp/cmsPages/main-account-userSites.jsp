<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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
                <table width="100%">
                    <tr>
                        <th>
                            Site Name
                        </th>
                        <th>
                            Status
                        </th>
                        <th colspan="2">
                            Action
                        </th>
                    </tr>
                <s:iterator value="cmsUserSiteList">
                    <tr align="center">
                        <td>
                            <s:property value="blogUrl" />
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
                            <s:submit type="button" value="Preview" theme="simple"/>
                            <s:submit type="button" value="CMS" theme="simple"/>
                        </td>
                    </tr>
                </s:iterator>
                </table>
            </s:div>
    </s:div>
</s:div>