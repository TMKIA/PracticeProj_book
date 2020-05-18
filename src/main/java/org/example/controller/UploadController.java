package org.example.controller;

import org.example.entity.Login;
import org.example.entity.Upload;
import org.example.service.UploadService;
import org.example.service.impl.UploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author TMK
 * date 2020/5/2 - 17:59
 */
@Controller
@RequestMapping("/upload")
@SessionAttributes(value = {"loginUser"})
public class UploadController {
    @Resource(name = "uploadServiceImpl")
    private UploadService uploadService;

    @RequestMapping("/fileUpload")
    public String fileUpload(@ModelAttribute(value = "loginUser")Login loginUser, HttpServletRequest request, Model model) throws IllegalStateException, IOException {
        long startTime = System.currentTimeMillis();    //用于计时
        Upload newUpload = new Upload(loginUser.getId());    //文件上传信息
        List<String> fileNameList = new ArrayList<>();    //文件名列表
        //将当前上下文初始化给  CommonsMultipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
            if (file != null) {

                    String fileName = file.getOriginalFilename();
                    String path = "C:/Users/Administrator/Desktop/upload/" + fileName;  //存储路径
                    file.transferTo(new File(path));    //上传

                    fileNameList.add(fileName);  //文件名存入list

                    newUpload.setPath(path);    //更新信息的路径
                    newUpload.setFilename(fileName);    //更新信息的文件名

                    if(uploadService.checkOneUpload(newUpload)==null){  //若 无同信息的上传数据
                        uploadService.saveUpload(newUpload);    //则 添加本上传数据到数据库
                    }
                }

            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("上传耗间：" + (endTime - startTime) + "ms");
        model.addAttribute("fileNameList",fileNameList);
        return "success";
    }

    @ModelAttribute
    public Login getLoginUser(){
        return new Login();
    }
}
