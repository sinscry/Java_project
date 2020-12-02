package d_formatter.controller;

import d_formatter.pojo.GoodsModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class FormatterController {
    @RequestMapping("/index")
    public String index(){
        return "d_formatter/input.jsp";
    }


    @RequestMapping("/formatter")
    public String myConverter(GoodsModel gm, Model model) {
        model.addAttribute("goods", gm);
        return "d_formatter/showGoodsb.jsp";
    }
}
