<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
		<s:form id="header_form">
			<s:div id="home" style="float:left">
				<button id="header_btn" onclick="form.action='postPreviewAction'; form.submit();" class="header-button">Home</button>
			</s:div>
			<s:div id="login" style="float:left">
				<s:if test="#session.userid > 0">
					<button id="banner_logout_btn" onclick="form.action='logout'; form.submit();" class="header-button">Logout</button>
				</s:if>
				<s:else>
			    	<button id="banner_login_btn" onclick="form.action='doLogin'; form.submit();" class="header-button">Login</button>
			    </s:else>
		    </s:div>
		    <s:div style="float:right;">
		    	&nbsp;
		    </s:div>
		</s:form>
	<br />
	<s:if test="#session.userid > 0">
		<s:div id="header_user_control_div" style="clear:both; float:right">
			<s:form id="user_control_form">
			    <s:div id="user_controls" style="float:right">
			    	<s:div id="new_post_div" style="float:left">
						<button id="control_new_post" onclick="form.action='newBlogPost'; form.submit();" class="header-button">Create New Post</button>
					</s:div>
			    	<s:div id="my_posts_div" style="float:left">
			    		<button id="control_my_posts" onclick="form.action='userPosts'; form.submit();" class="header-button">My Posts</button>
					</s:div>
			    	<s:div id="my_comments_div" style="float:left">
						<button id="control_my_comments" onclick="form.action='userComments'; form.submit();" class="header-button">My Comments</button>
					</s:div>
				    <s:div style="float:right;">
				    	&nbsp;
				    </s:div>
			    </s:div>
		    </s:form>
		</s:div>
	</s:if>
	<br />