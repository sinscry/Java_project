package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;

@CrossOrigin
@Controller
public class userController {
    @RequestMapping("/user")
    @ResponseBody
    public String user(@RequestBody User user){
        System.out.println(user.getUname());
        return user.getUname();
    }
}
