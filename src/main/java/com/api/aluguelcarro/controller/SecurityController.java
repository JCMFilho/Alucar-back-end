package com.api.aluguelcarro.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.aluguelcarro.model.User;
import com.api.aluguelcarro.utils.Constants;

@Controller
public class SecurityController {

    @RequestMapping(value = "/user-auth", method = RequestMethod.GET)
    @ResponseBody
    @Secured({Constants.ROLE_CLIENT, Constants.ROLE_ADMIN})
    public User user() {
        return (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
