package com.lab3.journal2.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * Add some error pages for 404, 500 status codes
 */
@Controller
public class JournalErrorController implements ErrorController {

    @RequestMapping(value = "/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String uri = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        String timestamp = LocalDateTime.now().toString();
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("uri", uri);
                return "error/error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
                String message = exception.getCause().getMessage();
                model.addAttribute("timestamp", timestamp);
                model.addAttribute("exception", message);
                model.addAttribute("code", statusCode);
                return "error/error-500";
            }else if(statusCode == HttpStatus.FORBIDDEN.value()) {
                return "error/error-403";
            }
        }
        return "/error/error";
    }
}
