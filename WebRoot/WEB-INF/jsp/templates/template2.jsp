<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <s:div id="site-wrapper">
		<s:property value="#parameters.blogSiteUrl"/>
        <s:div>
            <s:div style="margin:1%; overflow-x:hidden;">
                <s:div id="sidebar" style="width:20%; float:left; border: 1px solid black;">
                    <s:div id="header">
						<s:div id="header-buttons">
							<tiles:insertAttribute name="header" ignore="true" />
						</s:div>
					</s:div>
                    <s:div id="archive-content" style="margin: 3%; min-height: 30%">
						<tiles:insertAttribute name="archive" />
                    </s:div>
                </s:div>
                <s:div id="main-content" style="margin-left: 2%; margin-bottom:2%; width:75%; float:left;">
                    <s:div style=" border: 1px solid black;">
						<s:div id="banner">
							<s:div id="banner-img">
								<tiles:insertAttribute name="banner" ignore="true" />
							</s:div>
						</s:div>
                        <s:div id="body">
							<tiles:insertAttribute name="body" />
                        </s:div>
                    </s:div>
                    <s:div id="footer" style=" border: 1px solid black; margin-top: 10px;">
						<tiles:insertAttribute name="footer" />
                    </s:div>
                </s:div>
            </s:div>
        </s:div>
    </s:div>
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
</body>
</html>