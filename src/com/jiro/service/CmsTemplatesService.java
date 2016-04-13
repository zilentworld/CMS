package com.jiro.service;

import com.jiro.model.CmsTemplates;

public interface CmsTemplatesService {

    public CmsTemplates getByImgSrc(String imgSrc);
    
    public CmsTemplates getNewCmsTemplates();
    
}
