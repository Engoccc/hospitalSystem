package web.example.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import web.example.users.CustomGenericException;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(CustomGenericException.class)//可以直接写@ExceptionHandler,不指明异常类，会自动映射
    public ModelAndView customGenericExceptionHnadler(CustomGenericException exception){ //还可以声明接收其他任意参数
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errMsg",exception.getErrMsg());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)//可以直接写@EceptionHandler，IOExeption继承于Exception
    public ModelAndView allExceptionHandler(Exception exception){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errMsg", exception.getMessage());
        return modelAndView;
    }
}