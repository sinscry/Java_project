package b_simpleMVC.service;

import b_simpleMVC.pojo.UserForm;

public interface UserService {
    boolean login(UserForm user);
    boolean register(UserForm user);
}
