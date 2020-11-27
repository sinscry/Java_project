package d_formatter.controller;

import d_formatter.pojo.GoodsModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/formatter")
public class FormatterController {
    @RequestMapping("/addGoods")
    public String myConverter(GoodsModel gm, Model model){
        model.addAttribute("goods",gm);
        return "d_formatter/showGoodsb.jsp";
    }
    @RequestMapping("/index")
    public String add(){
        return "d_formatter/input.jsp";
    }
}
