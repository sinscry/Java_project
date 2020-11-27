package b_simpleMVC.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

public class BaseController {
    @ModelAttribute
    public void isLogin(HttpSession session) throws Exception {
        if (session.getAttribute("user") == null) {
            System.out.println("没有权限");
            throw new Exception("没有权限");
        }
    }
}