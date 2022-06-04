package com.ccc.tcapi.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import com.ccc.tcapi.configurations.FileUploadPropertiesConfig;
import com.ccc.tcapi.exceptions.FileNotFoundException;
import com.ccc.tcapi.exceptions.FileStorageException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileHandlerServiceImpl implements FileHandlerService {

    private final Path fileStorageLocation;

    @Autowired
    public FileHandlerServiceImpl(FileUploadPropertiesConfig fileUploadProperties) {

        try {
            this.fileStorageLocation = Paths.get(fileUploadProperties.getLocation())
                    .toAbsolutePath()
                    .normalize();

            Files.createDirectories(this.fileStorageLocation);

        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
                    ex);
        }
    }

    @Override
    public String Upload(MultipartFile file) {

        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return "static/uploads/" + fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    @Override
    public Boolean Deelete(String filePath, Integer rowId) {
        return null;
    }

    @Override
    public List<String> UploadMultiples(MultipartFile[] files) {
        List<String> filePaths = new ArrayList<>();

        for(MultipartFile file: files) {
            String filePath = this.Upload(file);
            filePaths.add(filePath);
        }

        return filePaths;
    }

    @Override
    public Resource LoadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + fileName, ex);
        }
    }

}
