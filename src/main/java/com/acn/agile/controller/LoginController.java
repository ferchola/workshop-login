package com.acn.agile.controller;

import com.acn.agile.exception.LoginException;
import com.acn.agile.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final String ERROR_MSG = "Something went wrong, please try again";

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "Logs in a user")
    public String doLogin(String userId, String password) {
        try {
            return "HELLO ".concat(loginService.doLogin(userId, password));
        } catch (LoginException e) {
            return ERROR_MSG + " " + e.getMessage();
        }
    }

}
