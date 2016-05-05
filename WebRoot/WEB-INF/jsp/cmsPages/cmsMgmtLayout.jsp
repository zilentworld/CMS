<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
</head>
<style>
    .border {
    border: 1px solid black;
    }
    .header {
        float: left;
    }
    .template {
    height: 50vh;
    width: 50vh;
    float: left;
    margin: 1%;
    cursor: pointer;
    }
    .right-open {
    margin-right: 5px;
    }
    .ov-hidden {
    overflow: hidden;
    }
    h2, h3 {
    text-align: center;
    }
    tr:nth-child(even) {
        background-color: #CCC;
    }
    tr > th {
        background-color: #879EFF;
    }
</style>
<body>
    <s:div class="border" style="height: 90vh; margin: 4vh;">
        <s:div id="header">
            <s:div id="header-links" style="margin-top: 10px; margin-bottom: 10px; overflow: auto;">
   				<s:div style="float: left; margin-left: 2vh;">
   					Hi <s:property value="#session.cms_user.cmsUsername" />!
   				</s:div>
    			<s:set var="cmsUser" value="#session.cms_user" />
    			<s:if test="'cms_admin'.equals(#cmsUser.cmsUserType.cmsUserTypeCode)">
	                <!--admin-->
	                <s:div style="float:right; margin-right: 2vh;">
	                    <s:div class="header">
	    					<s:a href="javascript:callAction('showSiteList');">
	                    		Site List
	                    	</s:a>
	                    </s:div>
	                    <s:div class="header">&nbsp;|&nbsp;</s:div>
	                    <s:div class="header">
	    					<s:a href="javascript:callAction('showManageHeaders');">
	                    		Manage Headers
	                    	</s:a>
	                    </s:div>
	                </s:div>
                </s:if>
				<s:else>
					<!-- client -->
					<s:div style="float:right; margin-right: 2vh;">
						<s:div class="header">
							<s:a href="javascript:callAction('showMySites');">
								My Sites
							</s:a>
						</s:div>
						<s:div class="header">&nbsp;|&nbsp;</s:div>
						<s:div class="header">
							<s:a href="javascript:callAction('showMyUsers');">
								My Users
							</s:a>
						</s:div>
					</s:div>
				</s:else>
            </s:div>
        </s:div>
        <hr width="100%" />
        <s:div style="clear: both;"/>
        <s:div id="body">
			<tiles:insertAttribute name="content" ignore="true" />
        </s:div>
    </s:div>
</body>
	<script>
		function callAction(action) {
			window.location = action;
		}
		function toggleHidden(divId) {
			var theDiv = document.getElementById(divId);
			theDiv.style.display = (theDiv.style.display == 'block' ? 'none'
					: 'block');
			return false;
		}
	</script>
</html>