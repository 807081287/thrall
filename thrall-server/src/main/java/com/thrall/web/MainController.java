package com.thrall.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Api(value = "主界面", description = "主界面")
@Controller
@RequestMapping("/home")
public class MainController {

    @ApiOperation(value = "主页")
    @GetMapping(name = "")
    public ModelAndView showMain() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.html");
        return mv;
    }
}
