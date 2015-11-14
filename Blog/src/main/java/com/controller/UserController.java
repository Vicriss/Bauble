package com.controller;

import com.common.Response;
import com.common.Status;
import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vicriss on 2015/09/18.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("userId")
public class UserController {
    @Autowired
    public UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody User user, ModelMap modelMap) {
        int status = Status.SUCCESS;
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


}
