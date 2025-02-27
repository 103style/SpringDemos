package com.style103.springmvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * create by 103style on 2025/1/5 15:36
 * github:https://github.com/103style
 */
@Controller
public class ShareDataController {

    /**
     * 这个运行报错 先不管吧
     * Spring5.3+版本 用 javax.servlet 会报错
     * 需要替换成 jakarta.servlet 依赖
     * @return
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        request.setAttribute("testScope", "hello,servletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("testScope", "hello,ModelAndView");
        return modelAndView;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testScope", "hello,Model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testScope", "hello,Map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.put("testScope", "hello,ModelMap");
        return "success";
    }

    /**
     * Spring5.3+版本 用 javax.servlet 会报错
     * 需要替换成 jakarta.servlet 依赖
     */
    @RequestMapping("testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testScope", "hello,Session");
        return "success";
    }

    /**
     * Spring5.3+版本 用 javax.servlet 会报错
     * 需要替换成 jakarta.servlet 依赖
     */
    @RequestMapping("testApplication")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testScope", "hello,ServletContext");
        return "success";
    }
}
