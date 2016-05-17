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
            <s:if test="errorMsg != null && errorMsg.length() > 0">
                <s:property value="errorMsg"/>
            </s:if>
            <s:if test="cmsUser.cmsUserId > 0">
                <s:form id="editUserForm" method="POST">
                    <s:hidden name="cmsUserId" value="%{cmsUser.cmsUserId}" />
                    <s:hidden name="sourcePage" value="%{sourcePage}" />
                    <table style="width: 100%">
                        <tr>
                            <td width="10%" align="right">
                                Username:
                            </td>
                            <td align="left">
                                <s:label value="%{cmsUser.cmsUsername}" theme="simple" />
                            </td>
                        </tr>
                        <tr>
                            <td width="10%" align="right">
                                First Name:
                            </td>
                            <td align="left">
                                <s:textfield value="%{cmsUser.firstName}" name="cmsUser.firstName" theme="simple" />
                            </td>
                        </tr>
                        <tr>
                            <td width="10%" align="right">
                                Middle Name:
                            </td>
                            <td align="left">
                                <s:textfield value="%{cmsUser.middleName}" name="cmsUser.middleName" theme="simple" />
                            </td>
                        </tr>
                        <tr>
                            <td width="10%" align="right">
                                Last Name:
                            </td>
                            <td align="left">
                                <s:textfield value="%{cmsUser.lastName}" name="cmsUser.lastName" theme="simple" />
                            </td>
                        </tr>
                        <tr>
                            <td width="10%" align="right">
                                Age:
                            </td>
                            <td align="left">
                                <s:textfield value="%{cmsUser.age}" name="age" theme="simple" />
                            </td>
                        </tr>
                        <tr>
                            <td width="10%" align="right">
                                Gender:
                            </td>
                            <td align="left">
                                <s:textfield value="%{cmsUser.gender}" name="cmsUser.gender" theme="simple" />
                            </td>
                        </tr>
                    </table>
                    <s:div>
                        &nbsp;
                    </s:div>
                    <s:div style="float: right;">
                        <s:submit id="cancel" type="button" value="Cancel" theme="simple"/>
                        <s:submit id="save" type="submit" value="Save" theme="simple"/>
                    </s:div>
                </s:form>
            </s:if>
        </s:div>
    </s:div>
</s:div>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
    $(document).ready(function () {
        $('#cancel').click(function () {
            var form = $("#editUserForm");
            form.attr('action','UserList');
            form.submit();
        });
        $('#save').click(function () {
            if (confirm('Do you want to save?')) {
                alert("User info saved.");
                var form = $("#editUserForm");
                form.attr('action', 'SaveEditUser');
                form.submit();
            }
        });
    });
</script>