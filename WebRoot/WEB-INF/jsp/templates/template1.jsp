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

		<s:property value="#blogSiteUrl"/>
<s:div id="site_whole" style="height: 100%; width: 100%">
    <s:div id="site-container"
         style="min-width: 80%;
			max-width: 90%;
			position: absolute;
			left: 5%;
			right: 5%;
			border: 1px solid black;
			background-color: white">
        <s:div id="banner">
            <s:div id="banner-img">
				<tiles:insertAttribute name="banner" ignore="true" />
            </s:div>
        </s:div>
        <s:div id="site-holder" style="margin:1%">
            <hr/>
            <s:div id="headers" style="min-height: 5%;">
                <s:div id="header-buttons" style="min-height: 10px;">
                    <s:div style="float:right;">
						<tiles:insertAttribute name="header" ignore="true" />
                    </s:div>
                    <s:div style="clear:both;">

                    </s:div>
                </s:div>
            </s:div>
            <hr/>
            <s:div id="body-content" style="height:70%">
                <s:div id="body-container" style="margin: 1%">
                    <s:div id="main-content" style="min-width:70%; width:85%; max-width:85%; float:left">
                        <s:div style="width=90%; height=90%; clear:both; margin:1%">
                            <s:div id="posts-content" style="margin:1%">
		                        <s:div id="body">
									<tiles:insertAttribute name="body" />
		                        </s:div>
                            </s:div>
                        </s:div>
                    </s:div>
                    <s:div id="side-content" style="min-width:10%; max-width:15%; float:left;">
                        <s:div>
                            <s:div id="archive-content" style="margin: 3%; min-height: 30%">
								<tiles:insertAttribute name="archive" />
                            </s:div>
                        </s:div>
                    </s:div>
                </s:div>
            </s:div>
            <hr style="clear:both;" />
            <s:div id="footer-content" style="clear:both; height:5%">
                <s:div id="footer">
					<tiles:insertAttribute name="footer" />
                </s:div>
            </s:div>
            <hr style="clear:both;" />
        </s:div>
    </s:div>
</s:div>
</body>
</html>