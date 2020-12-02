package controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@CrossOrigin
public class indexController {
    @RequestMapping("/index")
    public String index(){
        return "index.html";
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