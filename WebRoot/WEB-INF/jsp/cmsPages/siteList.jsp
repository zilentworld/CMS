<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:div style="margin: 2.5%; width: 95%; height: 95%;" class="border">
    <s:form method="POST" id="publishFrm">
        <s:hidden id="publishId" value="aa" />
        <table style="width : 100%; text-align: center;">
            <tr>
                <th>
                    Site Name
                </th>
                <th>
                    Cms User
                </th>
                <th>
                    Action
                </th>
            </tr>
            <s:iterator value="cmsUserSiteLists">
                <tr>
                    <td>
                        <s:property value="blogUrl"/>
                    </td>
                    <td>
                        <s:property value="cmsUser.cmsUsername"/>
                    </td>
                    <td>
                        <s:submit class="publish" hidden-data="%{cmsUserSiteId}" type="button" value="Publish"
                                  theme="simple"/>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </s:form>
    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.publish').click(function () {
                var id = $(this).attr('hidden-data');
                var hidden = $("#publishId");
                var frm = $("#publishFrm");
                alert("id:"+id);
                alert("hidden:"+hidden.val());
                hidden.val(id);
                frm.attr('action', 'publishSite');

                alert("hidden:"+hidden.val());
                frm.submit();
            });
        });
    </script>
</s:div>