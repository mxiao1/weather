package com.xiao.controller;

import com.xiao.dao.Base;
import com.xiao.pojo.Student;
import com.xiao.service.JedisClientSingle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
public class HelloController {
    public static Logger logger = Logger.getLogger("HelloController.class");
    @Autowired
    private Base base;

    @Autowired
    JedisClientSingle jedisClientSingle;

    @RequestMapping(value = {"/xiao/hello"})
    public ModelAndView hello() throws Exception{
        ModelAndView mv = new ModelAndView();
        Student student = base.findById(1);
        logger.info("查询" + student.toString());
        mv.addObject("student", student);
        mv.setViewName("index");
        return mv;
    }

}
