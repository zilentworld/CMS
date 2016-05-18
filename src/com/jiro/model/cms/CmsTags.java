package com.jiro.model.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dev-pc on 5/18/16.
 */
@Entity
@Table(name="cms_tags")
public class CmsTags {

    @Id
    @Column(name="tag_id")
    private long tagId;

    @Column(name="tag_name")
    private String tagname;

    @Column(name="tag_replace")
    private String tagReplace;

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public String getTagReplace() {
        return tagReplace;
    }

    public void setTagReplace(String tagReplace) {
        this.tagReplace = tagReplace;
    }
}
