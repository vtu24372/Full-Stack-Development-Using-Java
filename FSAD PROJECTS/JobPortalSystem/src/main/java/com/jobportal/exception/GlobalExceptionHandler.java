package com.jobportal.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFound(ResourceNotFoundException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        model.addAttribute("title", "Resource Not Found");
        return "error/error";
    }
    
    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model model) {
        model.addAttribute("error", "An unexpected error occurred: " + ex.getMessage());
        model.addAttribute("title", "Server Error");
        return "error/error";
    }
    
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException ex, Model model) {
        model.addAttribute("error", "Something went wrong. Please try again.");
        model.addAttribute("title", "Application Error");
        return "error/error";
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        model.addAttribute("title", "Invalid Request");
        return "error/error";
    }
}