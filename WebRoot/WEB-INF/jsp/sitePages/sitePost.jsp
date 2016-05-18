<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
<s:div>
	<s:if test="'edit'.equals(postType)">
		<h2>Edit Blog Post</h2>
	</s:if>
	<s:else>
		<h2>New Blog Post</h2>
	</s:else>
	<s:if test="%{msg} != null && %{msg}.length() > 0">
    	<s:property value="msg"/>
    </s:if>
	<s:form method="post">
		<s:if test="'edit'.equals(postType)">
			<s:hidden name="sitePost.sitePostId" value="%{postId}" />
			<s:hidden name="postType" value="edit" />
		</s:if>
		<s:textfield label="Title" name="sitePost.sitePostTitle"
			class="blog-title" id="blog_title" />
		<s:textarea label="Content" name="sitePost.sitePostContent"
			class="blog-content" id="blog_content" />
		<s:submit type="button" onclick="form.action='newSitePost'; form.submit();" value="Submit"/>
	</s:form>
</s:div>
<script>
	tinymce.init({ selector:'textarea' });
</script>