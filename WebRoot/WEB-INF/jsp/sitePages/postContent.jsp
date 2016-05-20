<%@ taglib prefix="s" uri="/struts-tags" %>
<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
<s:set var="siteMapVars" value="#session.siteMapVars"/>
<s:set var="blogSiteUrl" value="blogSiteUrl"/>
<s:set var="sessionSiteUser" value="%{#siteMapVars[#blogSiteUrl]}"/>

<s:set var="sitePost" value="sitePost"/>
<s:if test="sitePost != null">
    <s:div id="sitePost-content"
           class="site-post-content">
        <s:div id="post-content" style="display: block;">
            <s:div id="post-title">
                <h4>
                    <s:property value="sitePost.sitePostTitle"/>
                </h4>
            </s:div>
            <s:div id="blog-poster">
                <i> by <s:property value="sitePost.siteUser.siteUserUsername"/>
                </i>
            </s:div>
            <s:div id="blog-postbody">
                <s:property value="sitePost.sitePostContent" escape="false"/>
            </s:div>
        </s:div>
        <s:if
                test="#sessionSiteUser.siteUserId == sitePost.siteUser.siteUserId">
            <s:div id="post-content-edit" style="display: none;">
                <form method="POST">
                    <s:hidden name="sitePost.sitePostId" value="%{sitePost.sitePostId}"/>
                    <s:hidden name="postType" value="edit"/>
                    <s:textfield id="post-edit-title" name="sitePost.sitePostTitle"/>
                    <s:textarea id="post-edit-content" name="sitePost.sitePostContent"/>
                    <s:div class="clear float-right">
                        <s:submit onclick="javascript:return switchHidden('post-content-edit','post-content') || toggleHidden('post-controls');"
                                  value="Cancel" theme="simple"/>
                        <s:submit theme="simple" type="button" onclick="form.action='editPost'; form.submit();"
                                  value="Submit"/>
                    </s:div>
                </form>
            </s:div>
            <s:div id="post-controls" class="clear float-right" style="display: block;">
                <s:form id="post-control-form">
                    <%--<s:a--%>
                    <%--href="javascript:callAction('editPost?postType=edit&postId=' + %{sitePost.sitePostId});">--%>
                    <%--Edit--%>
                    <%--</s:a> --%>
                    <s:a onclick="javascript:return switchHidden('post-content-edit','post-content') || toggleHidden('post-controls');">
                        Edit
                    </s:a>
                    |
                    <s:a
                            href="javascript:callAction('deletePost?postId=' + %{sitePost.sitePostId});"
                            onclick="return confirm('Are you sure?')">
                        Delete
                    </s:a>
                </s:form>
            </s:div>
        </s:if>
    </s:div>
    <br/>

    <!-- Comment Area -->
    <s:div id="post-comment-area" class="clear">
        <s:label>Post a Comment:</s:label>
        <s:if test="#sessionSiteUser.siteUserId > 0">
            <s:div id="post-comment-new">
                <s:form method="post">
                    <s:hidden name="siteComment.sitePost.sitePostId"
                              value="%{sitePost.sitePostId}"/>
                    <s:textarea name="siteComment.siteCommentContent"
                                class="comment-textarea"/>
                    <br/>
                    <s:submit type="button" onclick="form.action='saveComment'; form.submit();" value="Submit"/>
                </s:form>
            </s:div>
        </s:if>
        <s:else>
            <br/>
            <s:label>
                Kindly login to comment
            </s:label>
        </s:else>
        <s:iterator value="siteComments">
            <s:div id="comment-%{siteCommentId}">
                <h5>
                    <s:div id="comment-controls" style="display:block;">
                        <s:form id="comment-control-form-%{siteCommentId}">
                            <s:property value="siteUser.siteUserUsername"/>
                            on <s:date name="commentDate" format="dd/MM/yyyy hh:mm:ss"/>
                            <s:if test="#sessionSiteUser.siteUserId == siteUser.siteUserId">
                                (
                                <s:a
                                        onclick="javascript:return switchHidden('comment-edit-%{siteCommentId}','comment-content-%{siteCommentId}');">
                                    Edit
                                </s:a>
                                |
                                <s:a
                                        href="javascript:callAction('deleteComment?commentId=' + %{siteCommentId} + '&postId=' + %{sitePost.sitePostId});"
                                        onclick="return confirm('Are you sure?')">
                                    Delete
                                </s:a>
                                )
                            </s:if>
                        </s:form>
                    </s:div>
                </h5>
                <s:div id="comment-content-%{siteCommentId}" style="display:block;">
                    <p>
                        <s:property value="siteCommentContent"/>
                    </p>
                </s:div>
                <s:if test="#sessionSiteUser.siteUserId == siteUser.siteUserId">
                    <s:div id="comment-edit-%{siteCommentId}" style="display:none;">
                        <s:form action="postComment" method="post">
                            <table>
                                <tr>
                                    <td colspan="2">
                                        <s:hidden
                                                name="siteComment.sitePost.sitePostId"
                                                value="%{sitePost.sitePostId}"/>
                                        <s:hidden
                                                name="commentType" value="edit"/>
                                        <s:hidden
                                                name="siteComment.siteCommentId" value="%{siteCommentId}"/>
                                        <s:textarea value="%{siteCommentContent}"
                                                    name="siteComment.siteCommentContent" theme="simple"/></td>
                                </tr>
                                <tr>
                                    <td><s:submit
                                            onclick="return switchHidden('comment-edit-%{siteCommentId}','comment-content-%{siteCommentId}');"
                                            value="Cancel" theme="simple"/></td>
                                    <td>
                                        <s:submit theme="simple" type="button"
                                                  onclick="form.action='saveComment'; form.submit();" value="Submit"/>
                                    </td>
                                </tr>
                            </table>
                        </s:form>
                    </s:div>
                </s:if>
            </s:div>
        </s:iterator>
    </s:div>
</s:if>
<s:else>
    <s:div id="post-content-error">
        <h4>Error in loading post</h4>
    </s:div>
</s:else>
<script>
    function switchHidden(divId1, divId2) {
        var div1 = document.getElementById(divId1);
        var div2 = document.getElementById(divId2);
        div1.style.display = (div1.style.display == 'block' ? 'none' : 'block');
        div2.style.display = (div2.style.display == 'block' ? 'none' : 'block');

        return false;
    }
    tinymce.init({selector: '#post-edit-content'});
</script>