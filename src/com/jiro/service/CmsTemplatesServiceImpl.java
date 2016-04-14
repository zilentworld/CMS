package com.jiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.CmsTemplatesDao;
import com.jiro.model.CmsTemplates;

@Service
public class CmsTemplatesServiceImpl implements CmsTemplatesService {
    
    @Autowired
    CmsTemplatesDao cmsTemplatesDao;
    
    public CmsTemplatesDao getCmsTemplatesDao() {
        return cmsTemplatesDao;
    }

    public void setCmsTemplatesDao(CmsTemplatesDao cmsTemplatesDao) {
        this.cmsTemplatesDao = cmsTemplatesDao;
    }
    

    @Override
    public CmsTemplates get(long templateId) {
        return cmsTemplatesDao.get(templateId);
    }

    @Override
    public CmsTemplates getByImgSrc(String imgSrc) {
        System.out.println("service img src");
        if(checkImgSrc(imgSrc)) {
            System.out.println("pasok");
            int x = imgSrc.lastIndexOf("/") + 1;
            String webpath = imgSrc.substring(0, x);
            String imgName = imgSrc.substring(x);
            System.out.println("CMS SERVICE IMGSRC - webpath:"+ webpath + ", imgName:"+imgName);
            return cmsTemplatesDao.getByImgSrc(webpath, imgName);
        }
        return null;
    }
    
    public CmsTemplates getNewCmsTemplates(){
        return new CmsTemplates();
    }
    
    private boolean checkImgSrc(String imgSrc) {
        System.out.println("check img src");
        System.out.println("" + imgSrc.contains("/") + ":" + imgSrc.contains(".png") + ":" + imgSrc.contains(".jpg") + ":" +imgSrc.contains(".jpeg"));
        return (imgSrc.contains("/") && (
                    imgSrc.contains(".png") ||
                    imgSrc.contains(".jpg") ||
                    imgSrc.contains(".jpeg")
                ));
    }
}
