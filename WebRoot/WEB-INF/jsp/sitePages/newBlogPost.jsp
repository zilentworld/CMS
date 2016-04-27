<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" href="resources/markitup/skins/markitup/style.css" />
<link rel="stylesheet" type="text/css" href="resources/markitup/sets/default/style.css" />
<s:div>
	<s:if test="'edit'.equals(postType)">
		<h2>Edit Blog Post</h2>
	</s:if>
	<s:else>
		<h2>New Blog Post</h2>
	</s:else>
	<s:if test="%{isErrMsg()}">
    	Error in creating new blog post
    </s:if>
	<s:form action="processBlogPost" method="post">
		<s:if test="'edit'.equals(postType)">
			<s:hidden name="blogPost.blogPostId" value="%{postId}" />
			<s:hidden name="postType" value="edit" />
		</s:if>
		<s:textfield label="Title" name="blogPost.blogTitle"
			style="min-width:400px" id="blog_title" />
		<s:textarea label="Content" name="blogPost.postContent"
			style="width:600px; height:300px; max-width:1100px" id="blog_content" />
		<s:label>
			<i style="font-size:13px">Note: Enclose a url in &ltimage&gt
				&lt/image&gt for image support (max display size 800x800)</i>
		</s:label>
		<s:submit />
	</s:form>
	
</s:div>