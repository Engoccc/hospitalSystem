package web.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.example.dao.UserDao;
import web.example.users.User;



@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean login(String username, String password) {
        User user = userDao.getUser(username,password);
        if (user == null) {
            System.out.println("Login Failed");
            return false;
        }else {
            System.out.println("Login Successed");
            return true;
        }
    }

    public User getUser(String username, String password){
        if(userDao.getUser(username,password) == null)
            System.out.println("Get User Failed");
        return userDao.getUser(username,password);
    }

    public void insertIn(String phone,String password,String name,String sex,String uid,String card){
        userDao.addUser(phone,password,name,sex,uid,card);
    }
}
