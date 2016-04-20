<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<s:div id="site-wrapper">
		<s:property value="#blogSiteUrl"/>
    <s:div>
        <s:div>
            <s:div style="width:100%; height: 50%; text-align: center;">
                <s:div id="banner">
					<s:div id="banner-img">
						<tiles:insertAttribute name="banner" ignore="true" />
					</s:div>
				</s:div>
            </s:div>
            <s:div>
                <s:div style="position:absolute; min-width:60%; margin-left:20%; margin-right:20%;">
                    <s:div style="float:right;">
	                    <s:div id="header">
							<s:div id="header-buttons">
								<tiles:insertAttribute name="header" ignore="true" />
							</s:div>
	                    </s:div>
                    </s:div>
                    <s:div style="clear:both;">
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
</body>
</html>