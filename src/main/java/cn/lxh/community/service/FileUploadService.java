package cn.lxh.community.service;

import cn.lxh.community.mapper.PictureMapper;
import cn.lxh.community.model.Picture;
import cn.lxh.community.model.PictureExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.UUID;

@Service
public class FileUploadService {

    @Autowired
    PictureMapper pictureMapper;


    public String upload(MultipartFile multipartFile, String mimeType, String fileName){
        String generatedFileName = null;
        String[] filePaths = fileName.split("\\.");
        if(filePaths.length > 1){
            generatedFileName = UUID.randomUUID().toString()+"."+filePaths[filePaths.length-1];
        }
        try  {
            Picture picture = new Picture();
            picture.setName(generatedFileName);
            picture.setImage(multipartFile.getBytes());
            picture.setMimetype(mimeType);
            pictureMapper.insert(picture);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return generatedFileName;
    }
}
