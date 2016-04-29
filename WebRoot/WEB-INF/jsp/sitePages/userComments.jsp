<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<h2>
	My Comments
</h2>

<s:iterator value="userSiteComments">
	<s:div id="comment-%{siteCommentId}">
		on
		<s:a href="javascript:callAction('postContent?postId=%{sitePost.sitePostId}');"> 
    		<s:property value="sitePost.sitePostTitle"/>
    	</s:a>
		<p>
			<s:property value="siteCommentContent" />
		</p>
	</s:div>
</s:iterator>
<s:if test="userSiteComments.size() == 0">
	There seems to be nothing here
</s:if>