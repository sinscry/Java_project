package control.control1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/login")
    public String login(){
        return "simple_control0/login.jsp";
    }

    @RequestMapping("/register")
    public String register(){
        return "simple_control0/register.jsp";
    }
}
