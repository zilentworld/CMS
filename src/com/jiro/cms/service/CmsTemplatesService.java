package com.jiro.cms.service;

import com.jiro.cms.model.CmsTemplates;

public interface CmsTemplatesService {

    public CmsTemplates getByImgSrc(String imgSrc);
    
    public CmsTemplates getNewCmsTemplates();
    
    public CmsTemplates get(long templateId);
    
    public void initializeBlog();
        
}
