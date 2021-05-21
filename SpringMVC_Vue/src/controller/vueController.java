package controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class vueController {
    @RequestMapping("/vue")
    public String index(){
        return "vue.html";
    }

    @RequestMapping("/json")
    @ResponseBody
    public String json(){
        JSONObject result = new JSONObject();
        result.put("name","sinscry");
        System.out.println(result.toString());
        return result.toString();
    }
}
