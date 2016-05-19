package com.jiro.cms;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by dev-pc on 5/18/16.
 */
public class CmsTagsMap {

    public static Map<String, String[]> tagsMap = new HashedMap();

    static {
        tagsMap.put("[!postPreview]", new String[]{"<s:action name=\"/", "/postPreview\" executeResult=\"true\"></s:action>"});
        tagsMap.put("[!postContent]", new String[]{"<s:action name=\"/", "/postContent\" executeResult=\"true\"></s:action>"});
        tagsMap.put("[!siteLogin]", new String[]{"<s:action name=\"/", "/showLogin\" executeResult=\"true\"></s:action>"});
        tagsMap.put("[!siteLoginButton]", new String[]{"<s:if test=\"#session.siteMapVars['", "'].siteUserId > 0\">\n" +
                "\t\t\t\t\t<s:submit type=\"button\" onclick=\"window.location='doLogout';\" value=\"Logout\" class=\"header-button\"/>\n" +
                "\t\t\t\t</s:if>\n" +
                "\t\t\t\t<s:else>\n" +
                "\t\t\t\t\t<s:submit type=\"button\" onclick=\"window.location='login';\" value=\"Login\" class=\"header-button\"/>\n" +
                "\t\t\t    </s:else>"});
        tagsMap.put("[!siteNewPost]", new String[]{"<s:action name=\"/", "/showNewPost\" executeResult=\"true\"></s:action>"});
        tagsMap.put("[!siteNewPostButton]", new String[]{"<s:set var=\"sessionUser\" value=\"%{#session.siteMapVars['", "']}\" />" +
                "<s:if test=\"#sessionUser.siteUserId > 0 && #sessionUser.isAdmin == 1\">\n" +
                "    <button onclick=\"window.location='./createPost'\">\n" +
                "        Create New Post" +
                "    </button>" +
                "</s:if>"});
        tagsMap.put("[!siteUserDisplay]", new String[]{"<s:set var=\"sessionUser\" value=\"%{#session.siteMapVars['", "']}\" />" +
                "<s:if test=\"#sessionUser.siteUserId > 0\">\n" +
                "    \tHi <s:property value=\"#sessionUser.siteUserUsername\"/>!\n" +
                "    </s:if>"});
        tagsMap.put("[!siteRegister]", new String[]{"<s:action name=\"/", "/showRegister\" executeResult=\"true\"></s:action>"});
    }

}
