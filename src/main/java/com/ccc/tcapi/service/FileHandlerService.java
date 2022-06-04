package com.ccc.tcapi.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileHandlerService {

    public String Upload(MultipartFile file);  

    public List<String> UploadMultiples(MultipartFile[] files);
    
    public Resource LoadFileAsResource(String fileName);
    
    public Boolean Deelete(String filePath, Integer rowId);

}
