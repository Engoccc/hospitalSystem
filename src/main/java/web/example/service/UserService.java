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
            return false;
        }else {
            return true;
        }
    }

    public void insertIn(String phone,String password,String name,String sex,String uid,String card){
        userDao.addUser(phone,password,name,sex,uid,card);
    }
}
