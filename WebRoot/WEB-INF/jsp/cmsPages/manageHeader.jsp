<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div style="margin: 2.5%; width: 95%; height: 95%; overflow:auto; " class="border">
    <table style="width : 100%; text-align: center;">
        <tr>
            <th rowspan=2>
                Site Name
            </th>
            <th rowspan=2>
                Cms User
            </th>
            <th colspan=
                    <s:property value="siteHeaders.size()"/>>
                Headers
            </th>
            <th rowspan=2>
                Action
            </th>
        </tr>
        <tr>
            <s:iterator value="siteHeaders">
                <th>
                    <s:property/>
                </th>
            </s:iterator>
        </tr>
        <s:iterator value="cmsUserSiteLists">
            <s:form theme="simple">
                <s:hidden name="cmsUserSiteId" value="%{cmsUserSiteId}" />
                <tr>
                    <td>
                        <s:property value="blogUrl"/>
                    </td>
                    <td>
                        <s:property value="cmsUser.cmsUsername"/>
                    </td>
                    <s:iterator value="siteLinksPermissions">
                        <td>
                            <s:checkbox theme="simple" fieldValue="%{siteLinks.siteLinkId}" value="%{isEnabled}" name="headerList" />
                        </td>
                    </s:iterator>
                    <td>
                        <s:submit type="button" theme="simple" value="Save" onclick="form.action='processManageHeaders'; form.submit();"/>
                    </td>
                </tr>
            </s:form>
        </s:iterator>
    </table>
</s:div>