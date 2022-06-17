package com.ccc.tcapi.controller;

import java.util.List;

import com.ccc.tcapi.dto.TestRequestModel;
import com.ccc.tcapi.service.FileHandlerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class TestFileUploadController {

    @Autowired
    FileHandlerService fileHandler;

    @PostMapping("/upload/only/files")
    public List<String> UploadOnlyFiles(@RequestParam("attachments") MultipartFile[] files) {

        return fileHandler.UploadMultiples(files);

    }

    @PostMapping("/upload/files/with/model")
    public String UploadFilesWithModel(
            @RequestParam("attachments") MultipartFile[] files,
            @RequestParam("metaData") String model) throws Exception {

        TestRequestModel customModel = new ObjectMapper().readValue(model, TestRequestModel.class);

        // Object obj = StringToModelConverter.ConvertJsonStringToCustomObject(model,
        // TestRequestModel.class);
        return "Uploaded";
    }

}
