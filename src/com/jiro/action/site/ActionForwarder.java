package com.jiro.action.site;

public class ActionForwarder extends SiteAbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        System.out.println("actionForwarder:nextAction:"+getNextAction());
        System.out.println("actionForwarder:blogUrl:"+getBlogSiteUrl());
        return SUCCESS;
    }

    @Override
    public void validate() {
        // TODO Auto-generated method stub
        super.validate();
    }

}
