package co.goho.qingxu.kq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KqController {

    @RequestMapping(value = "/")
    public String toLogin(){
        return "login";
    }


}
