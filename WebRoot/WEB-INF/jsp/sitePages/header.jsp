<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    <s:set var="siteMapVars" value="#session.siteMapVars" />
	<s:set var="blogSiteUrl" value="blogSiteUrl" />
	<s:set var="siteUser" value="%{#session.siteMapVars[#blogSiteUrl].siteUserId}"/>
    <s:if test="##session.siteMapVars[#blogSiteUrl].siteUserId > 0">
    	Hi <s:property value="#siteUser.siteUserUsername"/>!
    </s:if>
		<s:form id="header_form">
			<s:div id="home" class="float-left">
				<s:submit type="button" onclick="form.action='/%{blogSiteUrl}'; form.submit();" value="Home"/>
			</s:div>
			<s:div id="login" class="float-left">
				<s:if test="#siteUser.siteUserId > 0">
					<s:submit type="button" id="banner_logout_btn" onclick="form.action='doLogout'; form.submit();" value="Logout" class="header-button"/>
				</s:if>
				<s:else>
					<s:submit type="button" id="banner_login_btn" onclick="form.action='showLogin'; form.submit();" value="Login" class="header-button"/>
			    </s:else>
		    </s:div>
		    <s:div class="float-right">
		    	&nbsp;
		    </s:div>
		</s:form>
	<br />
	<s:if test="#siteUser.siteUserId > 0">
		<s:div id="header_user_control_div" >
			<s:form id="user_control_form">
			    <s:div id="user_controls" class="float-right">
				    <s:if test="#siteUser.isAdmin == 1">
				    	<s:div id="new_post_div" class="float-left">
							<s:submit type="button" id="control_new_post" onclick="form.action='showNewSitePost'; form.submit();" value="Create New Post" class="header-button"/>
						</s:div>
<!-- 				    	<s:div id="my_posts_div" class="float-left"> -->
<!-- 							<s:submit type="button" id="control_my_posts" onclick="form.action='userPosts'; form.submit();" value="My Posts" class="header-button"/> -->
<!-- 						</s:div> -->
					</s:if>
			    	<s:div id="my_comments_div" class="float-left">
						<s:submit type="button" id="control_my_comments" onclick="form.action='userComments'; form.submit();" value="My Comments" class="header-button"/>
					</s:div>
				    <s:div class="float-right">
				    	&nbsp;
				    </s:div>
			    </s:div>
		    </s:form>
		</s:div>
	</s:if>
	<br />