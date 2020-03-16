package cn.lxh.community.controller;

import cn.lxh.community.dto.FileDTO;
import cn.lxh.community.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

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
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl(generatedFileName);
        return fileDTO;
    }
}
