package com.dobi;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//这个相当于@Controller 和 @ResponseBody（返回json格式）
public class TestController {

    @RequestMapping("/test")
    public String test(){
        int i = 1/1;
        return "hello";
    }

}
