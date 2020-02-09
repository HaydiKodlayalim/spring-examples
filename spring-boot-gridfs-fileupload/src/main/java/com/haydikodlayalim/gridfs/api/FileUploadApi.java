package com.haydikodlayalim.gridfs.api;

import com.haydikodlayalim.gridfs.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUploadApi {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping
    public void fileUpload(@RequestParam MultipartFile file) throws Exception {
        fileUploadService.uploadFile(file);
    }
}
