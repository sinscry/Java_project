package c_type_conversion.controller;

import c_type_conversion.pojo.GoodsModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/my")
public class CoverterController {
    @RequestMapping("/index")
    public String index(){
        return "c_type_conversion/input.jsp";
    }

    @RequestMapping("/converter")
    public String myConverter(@RequestParam("goods") GoodsModel gm, Model model){
        model.addAttribute("goods",gm);
        return "c_type_conversion/showGoods.jsp";
    }
}
