package b_simpleMVC.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/index","/"})
public class IndexController {
    @RequestMapping("/login")
    public String login(){
        return "b_simpleMVC/login.jsp";
    }

    @RequestMapping("/register")
    public String register(){
        return "b_simpleMVC/register.jsp";
    }
}
