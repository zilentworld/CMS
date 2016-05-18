package com.jiro.action.site;

import java.util.List;

import com.jiro.model.site.SitePost;
import com.jiro.service.site.SitePostService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostPreviewAction extends SiteAbstractAction {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    private SitePostService sitePostService;
    private List<SitePost> postPreviewList;
    private String siteUrl;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String url = request.getHeader("referer");
        String blogUrl = getBlogSiteUrl();
        System.out.println("postPreview:blogPostAction:url:" + url);
        System.out.println("postPreview:blogPostAction:" + blogUrl);
        System.out.println("postPreview:blogPostAction:" + siteUrl);
        postPreviewList = sitePostService.getPostPreview(siteUrl, 0, 5);
        System.out.println("postPreviewList:size:" + postPreviewList.size());
//        setNextAction(getBlogSiteUrl() + "/home");
//        System.out.println("postPreviewAction:execute:nextAction:" + getNextAction());
        System.out.println("postPreviewAction:execute:blogSiteUrl:" + getBlogSiteUrl());

        return SUCCESS;
    }

    public List<SitePost> getPostPreviewList() {
        return postPreviewList;
    }

    public void setPostPreviewList(List<SitePost> postPreviewList) {
        this.postPreviewList = postPreviewList;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}
