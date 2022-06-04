package com.ccc.tcapi.controller;

import com.ccc.tcapi.dto.RequestCountry;
import com.ccc.tcapi.dto.RequestEmail;
import com.ccc.tcapi.entites.CountryEntity;
import com.ccc.tcapi.service.EmailHandlerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/email")
public class TestEmailController {

    @Autowired
    EmailHandlerService emailService;

    @GetMapping("/send/text/message")
    public String Send() throws Exception {
        Boolean isSend = emailService.Send(new RequestEmail(
                "mrjana.jana@gmail.com",
                "Testing simple text mail",
                "This is simple text mail"));
        if (isSend) {
            return "Sent successfully!";
        } else {
            return "OPPS: Something went wrong.";
        }
    }

    @GetMapping("/send/static/html/template")
    public String SendStaticHtmlTemplate() throws Exception {
        Boolean isSend = emailService.Send(new RequestEmail(
                "mrjana.jana@gmail.com",
                "Testing with static HTML template",
                true,
                "static-template.ftlh"));

        if (isSend) {
            return "Sent successfully!";
        } else {
            return "OPPS: Something went wrong.";
        }
    }

    @GetMapping("/send/dynamic/html/template")
    public String SendDynamicHtmlTemplate() throws Exception {

        RequestCountry requestModel = new RequestCountry(new CountryEntity());
        CountryEntity country = requestModel.getCountry();
        country.setCountryName("India");

        Boolean isSend = emailService.Send(new RequestEmail(
                "mrjana.jana@gmail.com",
                "Testing with dynamic HTML template",
                true,
                "model-template.ftlh",
                country));

        if (isSend) {
            return "Sent successfully!";
        } else {
            return "OPPS: Something went wrong.";
        }
    }

    @PostMapping("/send/dynamic/html/template/with/attachment")
    public String SendDynamicHtmlTemplateWithAttachments(@RequestParam("attachments") MultipartFile attachments)
            throws Exception {

        RequestCountry requestModel = new RequestCountry(new CountryEntity());
        CountryEntity country = requestModel.getCountry();
        country.setCountryName("India");

        Boolean isSend = emailService.Send(new RequestEmail(
                "mrjana.jana@gmail.com",
                "Testing with dynamic HTML template with attachments",
                true,
                true,
                "model-template.ftlh",
                country,
                attachments));

        if (isSend) {
            return "Sent successfully!";
        } else {
            return "OPPS: Something went wrong.";
        }
    }
}
