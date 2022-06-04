package com.ccc.tcapi.service;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import com.ccc.tcapi.dto.RequestEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class EmailHandlerService {

    private static final String fromEmail = "community.computer.c@gmail.com";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    Configuration config;

    public Boolean Send(RequestEmail request) throws Exception {
        Boolean response = false;
        if (request.getHasTemplate() && !request.getHasAttachment()) {
            response = SendWithHtmlTemplate(
                    request.getToEmail(),
                    request.getSubject(),
                    true,
                    request.getModel(),
                    request.getTemplateName());
        } else if (request.getHasTemplate() && request.getHasAttachment()) {
            response = SendWithHtmlTemplateAndAttachment(
                    request.getToEmail(),
                    request.getSubject(),
                    true,
                    request.getModel(),
                    request.getTemplateName(),
                    request.getFile());
        } else {
            response = SendWithSimpleMessage(
                    request.getToEmail(),
                    request.getSubject(),
                    request.getSimpleMessage());
        }
        return response;
    }

    /**
     * {@summary} Send only simple text message here
     * 
     * @param toEmail
     * @param subject
     * @param message
     * @return
     * @throws Exception
     */
    private boolean SendWithSimpleMessage(String toEmail, String subject, String message) throws Exception {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setFrom(fromEmail);

        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        mailSender.send(simpleMailMessage);

        return true;
    }

    /**
     * {@summary} Send html template with inline image
     * 
     * @param toEmail
     * @param subject
     * @param message
     * @param isHtmlTemplate
     * @return
     * @throws Exception
     */
    private boolean SendWithHtmlTemplate(String toEmail, String subject, Boolean isHtmlTemplate, Object model,
            String templateName)
            throws Exception {

        // Read template content based on view
        Template t = config.getTemplate(templateName);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        messageHelper.setTo(toEmail);
        messageHelper.setFrom(fromEmail, "Community Computer Center");

        messageHelper.setSubject(subject);
        messageHelper.setText(html, isHtmlTemplate);

        mailSender.send(mimeMessage);

        return true;
    }

    /**
     * {@summary} Send attachment with html template
     * 
     * @param toEmail
     * @param subject
     * @param message
     * @param isHtmlTemplate
     * @param attachment
     * @return
     * @throws Exception
     */
    private boolean SendWithHtmlTemplateAndAttachment(String toEmail, String subject, Boolean isHtmlTemplate,
            Object model, String templateName,
            MultipartFile attachment) throws Exception {

        // Read template content based on view
        Template t = config.getTemplate(templateName);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        messageHelper.setTo(toEmail);
        messageHelper.setFrom(fromEmail, "Community Computer Center");

        messageHelper.setSubject(subject);
        messageHelper.setText(html, isHtmlTemplate);

        // For setting Inline image file
        // ClassPathResource resource = new
        // ClassPathResource("/static/images/ccc.webp");
        // messageHelper.addInline("cccLogoImage", resource);

        // For attachment
        if (!attachment.isEmpty()) {
            String fileName = StringUtils.cleanPath(attachment.getOriginalFilename());
            InputStreamSource streamSource = new InputStreamSource() {
                @Override
                public InputStream getInputStream() throws IOException {
                    return attachment.getInputStream();
                }
            };

            messageHelper.addAttachment(fileName, streamSource);
        }

        mailSender.send(mimeMessage);

        return true;
    }
}
