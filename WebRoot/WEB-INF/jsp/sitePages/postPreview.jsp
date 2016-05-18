<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>Blog Posts</h2>
<s:iterator value="postPreviewList">
    <s:div id="post-title-%{sitePostId}">
        <s:a href="javascript:callAction('content?postId=%{sitePostId}');">
            <s:property value="sitePostTitle"/>
        </s:a>
    </s:div>
    <s:div id="post-user-%{sitePostId}">
        by <s:property value="siteUser.siteUserUsername"/>
    </s:div>
    <s:div id="post-preview-%{sitePostId}">
        <p>
            <s:if test="sitePostContent.length() > 100">
                <s:property value="sitePostContent.substring(0,100)" />...
            </s:if>
            <s:else>
                <s:property value="sitePostContent" />
            </s:else>
        </p>
    </s:div>

    <br/>
</s:iterator>