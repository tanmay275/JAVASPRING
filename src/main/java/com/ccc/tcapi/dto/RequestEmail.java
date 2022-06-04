package com.ccc.tcapi.dto;

import org.springframework.web.multipart.MultipartFile;

public class RequestEmail {
    
    private String toEmail;
    private String subject;
    private Boolean hasTemplate = false;
    private Boolean hasAttachment = false;
    private String templateName = "";
    private Object model;
    private String simpleMessage;
    private MultipartFile file;
 

    public RequestEmail(String toEmail, String subject, String simpleMessage) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.simpleMessage = simpleMessage;
    }

    public RequestEmail(String toEmail, String subject, Boolean hasTemplate, String templateName) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.hasTemplate = hasTemplate;
        this.templateName = templateName;
    }

    public RequestEmail(String toEmail, String subject, Boolean hasTemplate, String templateName, Object model) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.hasTemplate = hasTemplate;
        this.templateName = templateName;
        this.model = model;
    }

    public RequestEmail(String toEmail, String subject, Boolean hasTemplate, Boolean hasAttachment, String templateName,
            Object model, MultipartFile file) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.hasTemplate = hasTemplate;
        this.hasAttachment = hasAttachment;
        this.templateName = templateName;
        this.model = model;
        this.file = file;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getHasTemplate() {
        return hasTemplate;
    }

    public void setHasTemplate(Boolean hasTemplate) {
        this.hasTemplate = hasTemplate;
    }
    
    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(Boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getSimpleMessage() {
        return simpleMessage;
    }

    public void setSimpleMessage(String simpleMessage) {
        this.simpleMessage = simpleMessage;
    }
    
}
