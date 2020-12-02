package f_json.controller;

import f_json.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;




@Controller
public class TestController {
    /**
     * 接收页面请求的JSON参数，并返回JSON格式的结果
     */
    @RequestMapping("testJson")
    @ResponseBody
    public Person testJson(@RequestBody Person user) {
        // 打印接收的JSON格式数据
        System.out.println("pname=" + user.getPname() + ",password="
                + user.getPassword() + ",page" + user.getPage());
        ;
        // 返回JSON格式的响应
        return user;
    }

    @RequestMapping("/index")
    public String index(){
        return "f_json/index.jsp";
    }
}
