package com.jiro.service.cms;

import com.jiro.model.cms.CmsTemplates;

public interface CmsTemplatesService {

    public CmsTemplates getByImgSrc(String imgSrc);
    
    public CmsTemplates getNewCmsTemplates();
    
    public CmsTemplates get(long templateId);
    
    public void initializeBlog();
        
}