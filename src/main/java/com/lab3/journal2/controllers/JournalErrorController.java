package com.lab3.journal2.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
public class JournalErrorController implements ErrorController {
    @RequestMapping(value = "/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String uri = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        //String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        String timestamp = LocalDateTime.now().toString();
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        String message = exception.getCause().getMessage();
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("uri", uri);
                return "error/error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                model.addAttribute("timestamp", timestamp);
                model.addAttribute("exception", message);
                model.addAttribute("code", statusCode);
                return "error/error-500";
            }
        }
        /* String datestamp = LocalDateTime.now().toString();
        String uri = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        String type = (String) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE);
        //String exception = (String) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        int status = (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        model.addAttribute("datestamp", datestamp);

        model.addAttribute("type", type);
        model.addAttribute("exception", exception);
        model.addAttribute("message", message);
        model.addAttribute("status", status);*/
        //model.addAttribute("exception", exception);
        //System.out.println("Some error happened " + status);
        //throw new RuntimeException("test exception");
        return "/error/error";
    }
}
