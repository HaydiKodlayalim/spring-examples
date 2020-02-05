package com.haydikodlayalim.gridfs.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    public void uploadFile(MultipartFile file) throws Exception {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("filename", file.getOriginalFilename());
        dbObject.put("contentType", file.getContentType());
        dbObject.put("size", file.getSize());
        dbObject.put("userId", "12345");
        ObjectId id = gridFsTemplate.store(file.getInputStream(),file.getOriginalFilename(), dbObject);
        System.out.println(id.toString());
    }
}
