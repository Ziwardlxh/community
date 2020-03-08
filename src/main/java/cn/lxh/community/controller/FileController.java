package cn.lxh.community.controller;

import cn.lxh.community.dto.FileDTO;
import cn.lxh.community.service.FileUploadService;
import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FileController {

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(HttpServletRequest request) {
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multiRequest.getFile("editormd-image-file");
        String generatedFileName = fileUploadService.upload(file, file.getContentType(), file.getOriginalFilename());
        FileDTO fileDTO  = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl(generatedFileName);
        return fileDTO;
    }
}
