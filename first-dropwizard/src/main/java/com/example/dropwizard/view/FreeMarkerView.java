package com.example.dropwizard.view;

import io.dropwizard.views.View;

/**
 * Created with IntelliJ IDEA.
 * User: sully.rafiq
 * Date: 31/07/2014
 * Time: 17:45
 * To change this template use File | Settings | File Templates.
 */
public class FreeMarkerView extends View {

    private Object templateData;

    public FreeMarkerView(String templateName) {
        super(templateName + ".ftl");
    }

    public FreeMarkerView(String templateName, Object templateData) {
        super(templateName + ".ftl");
        this.templateData = templateData;
    }

    public Object getTemplateData() {
        return templateData;
    }

}
