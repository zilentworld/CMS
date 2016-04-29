<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set var="siteMapVars" value="#session.siteMapVars" />
<s:set var="blogSiteUrl" value="blogSiteUrl" />
<s:set var="sessionSiteUser" value="%{#siteMapVars[#blogSiteUrl]}" />

<s:set var="sitePost" value="sitePost" />
<s:if test="sitePost != null">
	<s:div id="sitePost-content"
		style="word-wrap: break-word; overflow: hidden;">
		<s:div id="post-content">
			<s:div id="post-title">
				<h4>
					<s:property value="sitePost.sitePostTitle" />
				</h4>
			</s:div>
			<s:div id="blog-poster">
				<i> by <s:property value="sitePost.siteUser.siteUserUsername" />
				</i>
			</s:div>
			<s:div id="blog-postbody">
				<s:property value="sitePost.sitePostContent" escape="false" />
			</s:div>
		</s:div>
		<s:if
			test="#sessionSiteUser.siteUserId == sitePost.siteUser.siteUserId">
			<s:div id="post-controls" style="clear:both; float:right;">
				<s:form id="post-control-form">
					<s:a
						href="javascript:callAction('editSitePost?postType=edit&postId=' + %{sitePost.sitePostId});">
		    			Edit
		    		</s:a> 
			 		|
		    		<s:a
						href="javascript:callAction('deleteSitePost?postId=' + %{sitePost.sitePostId});"
						onclick="return confirm('Are you sure?')">
		    			Delete
		    		</s:a>
				</s:form>
			</s:div>
		</s:if>
	</s:div>
	<br />

	<!-- Comment Area -->
	<s:div id="post-comment-area" style="clear:both;">
		<s:label>Post a Comment:</s:label>
		<s:if test="#sessionSiteUser.siteUserId > 0">
			<s:div id="post-comment-new">
				<s:form method="post">
					<s:hidden name="siteComment.sitePost.sitePostId"
						value="%{sitePost.sitePostId}" />
					<s:textarea name="siteComment.siteCommentContent"
						style="width:320px; height:90px" />
					<br />					
        		<s:submit type="button" onclick="form.action='saveCommentPost'; form.submit();" value="Submit"/>
				</s:form>
			</s:div>
		</s:if>
		<s:else>
			<br />
			<s:label>
				Kindly login to comment
			</s:label>
		</s:else>
		AA
		<s:iterator value="siteComments">
			<s:div id="comment-%{siteCommentId}">
				<h5>
					<s:div id="comment-controls" style="display:block;">
						<s:form id="comment-control-form-%{siteCommentId}">
							<s:property value="siteUser.siteUserUsername" />
							on <s:date name="commentDate" format="dd/MM/yyyy hh:mm:ss" />
							<s:if test="#sessionSiteUser.siteUserId == siteUser.siteUserId">
								(
					    		<s:a
									onclick="javascript:return toggleHidden('comment-edit-%{siteCommentId}') 
									         || toggleHidden('comment-content-%{siteCommentId}');">
					    			Edit
					    		</s:a> 
						 		|
					    		<s:a
									href="javascript:callAction('deleteCommentPost?commentId=' + %{siteCommentId} + '&postId=' + %{sitePost.sitePostId});"
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
						<s:property value="siteCommentContent" />
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
											value="%{sitePost.sitePostId}" /> 
										<s:hidden
											name="commentType" value="edit" /> 
										<s:hidden
											name="siteComment.siteCommentId" value="%{siteCommentId}" />
										<s:textarea value="%{siteCommentContent}"
											name="siteComment.siteCommentContent" theme="simple" /></td>
								</tr>
								<tr>
									<td><s:submit
											onclick="return toggleHidden('comment-edit-%{siteCommentId}') 
											        || toggleHidden('comment-content-%{siteCommentId}');"
											value="Cancel" theme="simple" /></td>
									<td>
        							<s:submit theme="simple" type="button" onclick="form.action='saveCommentPost'; form.submit();" value="Submit"/>
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
	<s:div id="post-content">
		<h4>Error in loading post</h4>
	</s:div>
</s:else>