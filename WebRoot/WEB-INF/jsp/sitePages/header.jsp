<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
		<s:form id="header_form">
			<s:div id="home" style="float:left">
				<s:set var="blogSiteUrl" value="#session.blog_site_url" />
				<s:submit type="button" onclick="form.action='%{blogSiteUrl}'; form.submit();" value="Home"/>
			</s:div>
			<s:div id="login" style="float:left">
				<s:if test="#session.siteUserId > 0">
					<s:submit type="button" id="banner_logout_btn" onclick="form.action='doLogout'; form.submit();" value="Login" class="header-button"/>
				</s:if>
				<s:else>
					<s:submit type="button" id="banner_login_btn" onclick="form.action='showLogin'; form.submit();" value="Logout" class="header-button"/>
			    </s:else>
		    </s:div>
		    <s:div style="float:right;">
		    	&nbsp;
		    </s:div>
		</s:form>
	<br />
	<s:if test="#session.siteUserId > 0">
		<s:div id="header_user_control_div" style="clear:both; float:right">
			<s:form id="user_control_form">
			    <s:div id="user_controls" style="float:right">
			    	<s:div id="new_post_div" style="float:left">
						<s:submit type="button" id="control_new_post" onclick="form.action='newBlogPost'; form.submit();" value="Create New Post" class="header-button"/>
					</s:div>
			    	<s:div id="my_posts_div" style="float:left">
						<s:submit type="button" id="control_my_posts" onclick="form.action='userPosts'; form.submit();" value="My Posts" class="header-button"/>
					</s:div>
			    	<s:div id="my_comments_div" style="float:left">
						<s:submit type="button" id="control_my_comments" onclick="form.action='userComments'; form.submit();" value="My Posts" class="header-button"/>
					</s:div>
				    <s:div style="float:right;">
				    	&nbsp;
				    </s:div>
			    </s:div>
		    </s:form>
		</s:div>
	</s:if>
	<br />