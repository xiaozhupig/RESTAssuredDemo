package com.learn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
//@RequestMapping("/file")
public class UploadController {
    @RequestMapping("/upload")
    public String upLoad(@RequestParam("fileName") MultipartFile file, HttpServletRequest request) throws IOException {
        if(file.getSize() >0){
            String realPath = request.getSession().getServletContext().getRealPath("file");
            String filename = file.getOriginalFilename();
            File file1 = new File(realPath,filename);
            file.transferTo(file1);
            request.setAttribute("filepath","file1/"+filename);
            return "sucess";
        }
        return "error";
    }

    @RequestMapping(value = "/upload1",method = RequestMethod.POST)
    public String upload1(@RequestParam("fileName") MultipartFile file, HttpServletRequest request) throws IOException {
        //获取上传文件的名称
        String filename = file.getOriginalFilename();
        System.out.println("上传文件的名称："+ filename);
//        long timestamp = UUID.randomUUID().timestamp();
//        String index = filename.substring(filename.indexOf("."));
        //下载到的目标文件
        String path = request.getServletContext().getRealPath("/");
        //新建文件
        File file1 = new File(path,filename);
        //将文件写入
        file.transferTo(file1);
        return "redirect:sucess";

    }

    @PostMapping("/upload/static")
    public void wriToStatic(HttpServletRequest request,
                            RedirectAttributes redirectAttributes,
                            @RequestParam("uploadFile") MultipartFile file) throws IOException {
        if(!file.isEmpty()) {
            //获取目标文件夹
            String path = request.getServletContext().getRealPath("/") + "static/img/";
            //获取用户上传的源文件名
            String fileName = file.getOriginalFilename();
            //新建文件
            File file1 = new File(path, fileName);
            //将文件写入
            file.transferTo(file1);

            redirectAttributes.addFlashAttribute("message","upload to static success");
            System.out.println("success");
        } else {
            redirectAttributes.addFlashAttribute("message","upload file can not be empty");
            System.out.println("error");
        }

    }
}
