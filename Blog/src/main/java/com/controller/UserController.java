package com.controller;

import com.common.Response;
import com.common.Status;
import com.common.ValidateCode;
import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vicriss on 2015/09/18.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("userId")
public class UserController {

    int status = Status.SUCCESS;

    @Autowired
    public UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody User user, ModelMap modelMap) {

        User u1 = userRepository.findOne(user.getId());
        if (u1 == null || !u1.getPassword().equals(user.getPassword()))
            status = Status.ERROR;
        else {
            modelMap.addAttribute("userId", u1.getId());
        }
        return new Response(status, u1);
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object addUser(@RequestBody User user) {
        int status = Status.SUCCESS;
        User user1 = userRepository.save(user);
        return new Response(status);
    }


    @ResponseBody
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public Response validate(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        ValidateCode validateCode = new ValidateCode();
        try {
            validateCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            status = Status.ERROR;
            e.printStackTrace();
        }

        return new Response(status);
    }

}
