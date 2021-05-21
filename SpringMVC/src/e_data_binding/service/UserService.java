package e_data_binding.service;

import e_data_binding.pojo.User;

import java.util.ArrayList;

public interface UserService {
    boolean addUser(User u);
    ArrayList<User> getUsers();
}
