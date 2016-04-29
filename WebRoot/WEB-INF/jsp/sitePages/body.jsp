<%@ taglib prefix="s" uri="/struts-tags"%>
<s:div>
	<h2>Blog Posts</h2>
	<s:iterator value="postPreviewList">
	    <s:div id="post-title-%{sitePostId}">
	    	<s:a href="javascript:callAction('postContent?postId=%{sitePostId}');">
	    	<%-- <s:a href="javascript:callAction('postContent?postId=%{sitePostId}');"> --%>
	    		<s:property value="sitePostTitle"/>
	    	</s:a>
	    </s:div>
	    <s:div id="post-user-%{sitePostId}">
	        by <s:property value="siteUser.siteUserUsername"/>
	    </s:div>
	    <s:div id="post-preview-%{sitePostId}">
	    	<p>
				<s:property value="sitePostContent.substring(0,sitePostContent.length() > 100 ? 100 : sitePostcontent.length())"/>
				<s:if test="sitePostContent.length() > 100">
					...
				</s:if>
			</p>
	    </s:div> 
		
		<br/>
	</s:iterator>
</s:div>