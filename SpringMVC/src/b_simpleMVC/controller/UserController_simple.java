package b_simpleMVC.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import b_simpleMVC.pojo.UserForm;

import javax.servlet.http.HttpSession;


//封印这个简单版的controller
//@Controller
//@RequestMapping("/user")
public class UserController_simple {
    //得到一个用来记录日志的对象，这样在打印信息的时候能够标记打印的是哪个类的信息
    private static final Log logger = LogFactory.getLog(UserController_simple.class);

    /*
    处理登录
     */
    @RequestMapping("/login")
    public String login(UserForm user, HttpSession session, Model model){
        if("zhangsan".equals(user.getUname())
                && "123456".equals(user.getUpass())){
            session.setAttribute("user", user);
            logger.info("成功");
            return "b_simpleMVC/main.jsp"; //跳转成功页面
        }else{
            logger.info("失败");
            model.addAttribute("messageError","用户名或密码错误");
            return "b_simpleMVC/login.jsp";
        }

    }
    @RequestMapping("/register")
    public String register(UserForm user, Model model){
        if("zhangsan".equals(user.getUname())
            && "123456".equals(user.getUpass())){
            logger.info("成功");
            return "b_simpleMVC/login.jsp";
        }else{
            logger.info("失败");
            // 在register.jsp页面上可以使用EL表达式取出model的uname值
            model.addAttribute("uname",user.getUname());
            return "b_simpleMVC/register.jsp";
        }
    }
}
