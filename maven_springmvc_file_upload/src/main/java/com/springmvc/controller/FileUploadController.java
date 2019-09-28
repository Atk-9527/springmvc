package com.springmvc.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileUploadController {

    /**
     * 文件上传
     *
     * @return
     */
    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");
        // 使用 fileUpload 组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 创建该文件夹
            file.mkdirs();
        }
        // 解析 request 对象，获得上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items = upload.parseRequest(request);
        // 遍历
        for (FileItem item : items) {
            // 进行判断，当前 item 对象是否是上传文件项
            if (item.isFormField()) {
                // 说明是普通的表单项
            } else {
                // 说明上传文件项
                // 获取上传文件的名称
                String fileName = item.getName();
                // 把文件的名称设置成唯一值
                String s = UUID.randomUUID().toString().replace("-", "");
                fileName = s + "_" + fileName;
                // 完成文件上传
                item.write(new File(path, fileName));
                // 删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * Spring MVC文件上传
     *
     * @return
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("spring mvc 文件上传");
        // 使用 fileUpload 组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 创建该文件夹
            file.mkdirs();
        }
        // 说明上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置成唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 完成文件上传
        upload.transferTo(new File(path, filename));
        return"success";
}

    /**
     * Spring MVC文件上传
     *
     * @return
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile upload) throws Exception {
        System.out.println("spring mvc 跨服务器文件上传");
        // 定义上传文件服务器路径
        String path = "http://localhost:9090/maven_springmvc_file_upload_server/";
        // 说明上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置成唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 创建客户端对象
        Client client = Client.create();
        // 和图片服务器进行连接
        WebResource resource = client.resource(path + filename);
        // 上传文件
        resource.put(upload.getBytes());
        return"success";
    }
}
