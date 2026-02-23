package com.simonpeg.security;

import com.simonpeg.entity.Account;
import com.simonpeg.service.abs.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private AccountService accountService;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        var link = "/account/access-denied";
        link = "/account/loginForm";
        String message = "";

        var username = request.getParameter("username");

        Account acc = accountService.getAccount(username);

        if(acc != null){
            message = "Username or password invalid";
        }
        response.sendRedirect(request.getContextPath() + link + "?errors=" + message);
    }
}
