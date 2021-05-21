package c_type_conversion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conver")
public class Goodsontroller {
    @RequestMapping("/index")
    public String index(){
        return "c_type_conversion/addGoods.jsp";
    }


    @RequestMapping("/addGoods")
    public String add(String goodsname, double goodsprice, int goodsnumber, Model model){
        double total = goodsprice*goodsnumber;
        System.out.println(total);
        model.addAttribute("total",total);
        return "c_type_conversion/success.jsp";
    }
}
