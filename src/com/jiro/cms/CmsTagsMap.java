package com.jiro.cms;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by dev-pc on 5/18/16.
 */
public class CmsTagsMap {

    public static Map<String, String[]> tagsMap = new HashedMap();

    static {
        tagsMap.put("[!postPreview]",new String[] {"<s:action name=\"/","/postPreview\" executeResult=\"true\"></s:action>"});
        tagsMap.put("[!postContent]",new String[] {"<s:action name=\"/","/postContent\" executeResult=\"true\"></s:action>"});
        tagsMap.put("[!siteLogin]",new String[] {"<s:action name=\"/","/showLogin\" executeResult=\"true\"></s:action>"});
        tagsMap.put("[!siteNewPost]",new String[] {"<s:action name=\"/","/showNewPost\" executeResult=\"true\"></s:action>"});
    }

}
