package com.yves.web.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 * @date Created in 11:28 2018/5/13
 */
@Controller
public class HelloWordController {

    @RequestMapping(value = "/helloWord")
    public ModelAndView helloWord(String name){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        modelAndView.addObject("name",name);
        return modelAndView;

    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(String name){
        return "success" + " " + name;
    }
}
