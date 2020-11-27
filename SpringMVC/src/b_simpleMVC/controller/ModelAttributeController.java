package b_simpleMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ModelAttributeController extends BaseController{
    @RequestMapping("/add")
    public String add() {
        return "b_simpleMVC/addSuccess.jsp";
    }
    @RequestMapping("/update")
    public String update() {
        return "updateSuccess";
    }
    @RequestMapping("/delete")
    public String delete() {
        return "deleteSuccess";
    }
}