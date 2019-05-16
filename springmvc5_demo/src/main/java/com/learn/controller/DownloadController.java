package com.learn.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class DownloadController {

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String filename, HttpServletRequest request, Model model) throws IOException {
        System.out.println("开始下载----");
        //下载文件的路径
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/static/img/");
        File file = new File(path+File.separator+filename);
        //设置响应头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment",filename);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        System.out.println("====");
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),httpHeaders, HttpStatus.CREATED);

    }
}
