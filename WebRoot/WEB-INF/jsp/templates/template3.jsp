<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/generationBaseFiles/css/template3/template.css" />
<body>
	<s:div id="site-wrapper">
		template3
		<s:property value="#blogSiteUrl" />
		<s:div>
			<s:div>
				<s:div class="outer-banner">
					<s:div id="banner">
						<s:div id="banner-img">
							<tiles:insertAttribute name="banner" ignore="true" />
						</s:div>
					</s:div>
				</s:div>
				<s:div>
					<s:div class="main-content">
						<s:div class="float-right">
							<s:div id="header">
								<s:div id="header-buttons" class="header-buttons">
									<tiles:insertAttribute name="header" ignore="true" />
								</s:div>
							</s:div>
						</s:div>
						<s:div class="clear">
						</s:div>
						<s:div id="body">
							<tiles:insertAttribute name="body" />
						</s:div>
						<s:div>
							<tiles:insertAttribute name="footer" />
						</s:div>
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