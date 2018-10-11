package web.example.dao;

import org.apache.ibatis.annotations.Param;
import web.example.users.User;

public interface UserDao {
    /**
     * 通过用户名和密码查找用户
     */
    User getUser(@Param("phone") String uphone, @Param("password") String pwd);
    void addUser(@Param("phone") String phone,@Param("password") String password,@Param("name") String name, @Param("sex") String sex,@Param("uid") String uid, @Param("card") String card);
}
