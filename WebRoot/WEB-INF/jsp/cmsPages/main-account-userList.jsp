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
            <form id="userListForm" method="post">
                <s:hidden id="userId" name="cmsUserId" value="" />
                <s:hidden id="sourcePage" name="sourcePage" value="UserList"/>
                <table style="width : 100%; text-align: center;" class="tableAlternate">
                    <tr>
                        <th>
                            Username
                        </th>
                        <th>
                            First name
                        </th>
                        <th>
                            Middle Name
                        </th>
                        <th>
                            Last Name
                        </th>
                        <th>
                            Age
                        </th>
                        <th>
                            Gender
                        </th>
                        <th>
                            Status
                        </th>
                        <th colspan="2">
                            Action
                        </th>
                    </tr>
                    <s:iterator value="cmsUserList">
                        <tr>
                            <td>
                                <s:property value="cmsUsername"/>
                            </td>
                            <td>
                                <s:property value="firstName"/>
                            </td>
                            <td>
                                <s:property value="middleName"/>
                            </td>
                            <td>
                                <s:property value="lastName"/>
                            </td>
                            <td>
                                <s:property value="age"/>
                            </td>
                            <td>
                                <s:property value="gender"/>
                            </td>
                            <td>
                                <s:if test="isEnabled > 0">
                                    Enabled
                                </s:if>
                                <s:else>
                                    Disabled
                                </s:else>
                            </td>
                            <td>
                                <s:submit class="editButton" hidden-data="%{cmsUserId}" type="button" theme="simple" value="Edit Info"/>
                            </td>
                            <td>
                                <s:if test="isEnabled > 0">
                                    <s:submit class="deactivateButton" hidden-data="%{cmsUserId}" type="button" theme="simple" value="Deactivate"/>
                                </s:if>
                                <s:else>
                                    <s:submit class="activateButton" hidden-data="%{cmsUserId}" type="button" theme="simple" value="Activate"/>
                                </s:else>
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
        $('.editButton').click(function () {
            var id = $(this).attr('hidden-data');
            var hiddenField = $("#userId");
            var form = $("#userListForm")
            hiddenField.val(id);
            form.attr('action','EditUser');
            form.submit();
        });
        $('.deactivateButton').click(function () {
            if(confirm("Are you sure you want to deactivate this account?")) {
                var id = $(this).attr('hidden-data');
                var hiddenField = $("#userId");
                var form = $("#userListForm")
                hiddenField.val(id);
                form.attr('action', 'deactivateUser');
                form.submit();
            }
        });
        $('.activateButton').click(function () {
            if(confirm("Are you sure you want to activate this account?")) {
                var id = $(this).attr('hidden-data');
                var hiddenField = $("#userId");
                var form = $("#userListForm")
                hiddenField.val(id);
                form.attr('action', 'activateUser');
                form.submit();
            }
        });
    });
</script>