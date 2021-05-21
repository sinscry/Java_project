package controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @RequestMapping("/index")
        public String handleRequest(Model model) throws Exception {
            model.addAttribute("message","这是第一个SpringMVC网页");
            return "index";
        }
    @RequestMapping("/json")
    @ResponseBody
    public String json(Model model){
        JSONObject result = new JSONObject();
        result.put("good","good");
        System.out.println(result);
        model.addAttribute("message","json");
        return result.toJSONString();
    }
	@RequestMapping("/json_list")
	@ResponseBody
	public String json_list() {
        JSONArray jsonArray = JSONArray.parseArray("[{'name':'梁鸿振','stock_list':[{'stock_id':'110059','stock_nm':'浦发银行','sprice':'9.72','oprice':'9.71'}]}]");
        return jsonArray.toString();
    }
}