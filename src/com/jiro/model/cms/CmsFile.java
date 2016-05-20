package com.jiro.model.cms;

import org.apache.commons.io.FilenameUtils;

import javax.persistence.Entity;
import java.io.File;

/**
 * Created by dev-pc on 5/20/16.
 */
public class CmsFile {

    private File file;
    private boolean isCmsEditable;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isCmsEditable() {
        return isCmsEditable;
    }

    public void setCmsEditable(boolean cmsEditable) {
        isCmsEditable = cmsEditable;
    }

    public CmsFile() {
    }

    public CmsFile(File file) {
        this.file = file;
        System.out.println("cmsFile:file:" + file.getName());
        System.out.println("cmsFile:extension:" + FilenameUtils.getExtension(file.toPath().toString()));
        isCmsEditable = "html".equals(FilenameUtils.getExtension(file.toPath().toString()))
                || "txt".equals(FilenameUtils.getExtension(file.toPath().toString()));
        System.out.println("cmsFile:isCmsEditable:" + isCmsEditable);
    }
}
