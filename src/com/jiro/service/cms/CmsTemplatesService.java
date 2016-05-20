package com.jiro.service.cms;

import com.jiro.model.cms.CmsTemplates;

public interface CmsTemplatesService {

    CmsTemplates getByImgSrc(String imgSrc);
    
    CmsTemplates getNewCmsTemplates();
    
    CmsTemplates getById(long templateId);
    
    void initializeBlog();

    CmsTemplates getByTemplateName(String templateName);
        
}
