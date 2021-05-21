package b_simpleMVC.controller;

import b_simpleMVC.pojo.UserForm;
import b_simpleMVC.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController_with_service {
    //得到记录日志的对象
    private static final Log logger = LogFactory.getLog(UserController_with_service.class);
    //注入服务
    @Autowired
    public UserService userService;

    //处理登录
    @RequestMapping("/login")
    public String login(UserForm user, HttpSession session, Model model){
        if(userService.login(user)){
            session.setAttribute("user",user);
            logger.info("成功");
            return "b_simpleMVC/main.jsp";
        }else{
            logger.info("失败");
            model.addAttribute("messageError","用户名或密码错误");
            return "b_simpleMVC/login.jsp";
        }
    }

    //处理注册
    @RequestMapping("/register")
    public String register(@ModelAttribute("user") UserForm user){
        if(userService.register(user)){
            logger.info("成功");
            return "b_simpleMVC/login.jsp";
        }else{
            logger.info("失败");
            return "b_simpleMVC/register.jsp";
        }
    }
}
