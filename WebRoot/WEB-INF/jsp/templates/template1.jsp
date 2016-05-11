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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/generationBaseFiles/css/template1.css" />
<body>
	<s:div id="site_whole" class="site-whole">
		<s:div id="site-container" class="site-container">
			<s:div id="banner">
				<s:div id="banner-img">
					<tiles:insertAttribute name="banner" ignore="true" />
				</s:div>
			</s:div>
			<s:div id="site-holder" class="margin1">
				<hr />
				<s:div id="headers" class="headers">
					<s:div id="header-buttons" class="header-buttons">
						<s:div style="float:right;">
							<tiles:insertAttribute name="header" ignore="true" />
						</s:div>
						<s:div class="clear" />
					</s:div>
				</s:div>
				<hr />
				<s:div id="body-content">
					<s:div id="body-container" class="margin1">
						<s:div id="main-content" class="main-content">
							<s:div class="main-inner">
								<s:div id="posts-content" class="margin1">
									<s:div id="body" class="margin5">
										<tiles:insertAttribute name="body" />
									</s:div>
								</s:div>
							</s:div>
						</s:div>
						<s:div id="side-content" class="side-content">
							<s:div>
								<s:div id="archive-content" class="archive-content">
									<tiles:insertAttribute name="archive" />
								</s:div>
							</s:div>
						</s:div>
					</s:div>
				</s:div>
				<hr class="clear" />
				<s:div id="footer-content" class="footer-content">
					<s:div id="footer">
						<tiles:insertAttribute name="footer" />
					</s:div>
				</s:div>
				<hr class="clear" />
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