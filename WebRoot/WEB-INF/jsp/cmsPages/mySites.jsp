<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div style="margin: 2.5%; width: 95%; height: 95%; overflow: auto;" class="border">
    <s:form method="POST" id="publishFrm">
        <s:hidden id="publishId" name="cmsUserSiteId" value="aa"  />
        <table style="width : 100%; text-align: center;">
            <tr>
                <th rowspan="2">
                    Site Name
                </th>
                <th colspan="2">
                    Status
                </th>
            </tr>
            <tr>
                <th>
                    Published
                </th>
                <th>
                    Status
                </th>
            </tr>
            <s:iterator value="cmsUserSiteLists">
                <tr>
                    <td>
                        <s:set var="siteUrl" value="blogUrl" />
                        <s:if test="isPublished == 1 && isEnabled == 1">
                            <s:a href="javascript:callAction('%{#siteUrl}');">
                                <s:property value="#siteUrl" />
                            </s:a>
                        </s:if>
                        <s:else>
                            <s:property value="#siteUrl" />
                        </s:else>
                    </td>
                    <td>
                        <s:if test="isPublished == 1">
                            Yes
                        </s:if>
                        <s:else>
                            No
                        </s:else>
                    </td>
                    <td>
                        <s:if test="isEnabled == 1">
                            Enabled
                        </s:if>
                        <s:else>
                            Disabled
                        </s:else>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </s:form>
    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script>
        $(document).ready(function () {
        });
    </script>
</s:div>