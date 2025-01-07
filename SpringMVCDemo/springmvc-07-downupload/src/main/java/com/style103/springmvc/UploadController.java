package com.style103.springmvc;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * create by 103style on 2025/1/7 22:54
 * github:https://github.com/103style
 * <p>
 * 上传文件
 * 1.form表单的请求方式必须是post
 * 2.form表单必须设置 enctype="multipart/form-data"
 */
@Controller
public class UploadController {

    /**
     * photo : input表单中的 name
     */
    @PostMapping("/test/upload")
    public String handleFileUpload(@RequestParam("photo") MultipartFile photo, HttpSession session, RedirectAttributes redirectAttributes) throws IOException {
        // 检查文件是否为空
        if (photo.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "请选择一个文件进行上传");
            return "redirect:/index";
        }

        //获取上传的文件的文件名
        String fileName = photo.getOriginalFilename();
        System.out.println("------fileName:" + fileName);

        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + hzName;
        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        //实现上传功能
        photo.transferTo(new File(finalPath));
        redirectAttributes.addFlashAttribute("message", "文件上传成功");
        return "upload_success";
    }
}
