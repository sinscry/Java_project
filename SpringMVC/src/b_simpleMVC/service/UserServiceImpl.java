package b_simpleMVC.service;

import b_simpleMVC.pojo.UserForm;
import org.springframework.stereotype.Service;

//注解为一个服务
@Service
public class UserServiceImpl implements UserService{
    public boolean login(UserForm user){
        if("zhangsan".equals(user.getUname())
                && "123456".equals(user.getUpass())){
            return true;
        }
        return false;
    }
    public boolean register(UserForm user) {
        if ("zhangsan".equals(user.getUname())
                && "123456".equals(user.getUpass())) {
            return true;
        }
        return false;
    }
}
