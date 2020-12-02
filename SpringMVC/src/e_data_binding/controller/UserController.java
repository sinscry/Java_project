package e_data_binding.controller;

import e_data_binding.pojo.User;
import e_data_binding.service.UserService;
import e_data_binding.service.UserServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    // 得到一个用来记录日志的对象,这样在打印信息的时候能够标记打印的是哪个类的信息
    private static final Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/input")
    public String inputuser(Model model){
        HashMap<String, String> hobbys = new HashMap<String,String>();
        hobbys.put("篮球","篮球");
        hobbys.put("兵乓球","兵乓球");
        hobbys.put("电玩","电玩");
        hobbys.put("游泳","游泳");
        // 如果model中没有user属性，userAdd.jsp会抛出异常，因为表单标签无法找到
        // modelAttribute 属性指定的 form backing object
        model.addAttribute("user",new User());
        model.addAttribute("hobbys",hobbys);
        model.addAttribute("carrers", new String[] { "教师", "学生", "coding 搬运工",
                "IT民工", "其他" });
        model.addAttribute("houseRegisters", new String[] { "北京", "上海", "广州",
                "深圳", "其他" });
        return "e_data_binding/userAdd.jsp";
    }
    @RequestMapping(value = "/save")
    public String addUser(@ModelAttribute User user, Model model){
        if(userService.addUser(user)) {
            logger.info("成功");
            return "redirect:/user/list";
        }else {
            logger.info("失败");
            HashMap<String, String> hobbys = new HashMap<String, String>();
            hobbys.put("篮球", "篮球");
            hobbys.put("乒乓球", "乒乓球");
            hobbys.put("电玩", "电玩");
            hobbys.put("游泳", "游泳");
            // 这里不需要 model.addAttribute ("user", new User ()),因为 @ModelAttribute
            // 指定 form backing object
            model.addAttribute("hobbys", hobbys);
            model.addAttribute("carrers", new String[] { "教师", "学生",
                    " coding搬运工", "IT民工", "其他" });
            model.addAttribute("houseRegisters", new String[] { "北京", "上海",
                    "广州", "深圳", "其他" });
            return "e_data_binding/userAdd.jsp";
        }
    }
    @RequestMapping(value = "/list")
    public String listUsers(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users",users);
        return "e_data_binding/userList.jsp";
    }
}
