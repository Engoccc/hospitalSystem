package web.example.dao;

import org.apache.ibatis.annotations.Param;
import web.example.users.User;

public interface UserDao {
    /**
     * 所有的DAO接口都由Mybatis来实现
     * 采用@Param注解来实现传入多个参数，也可以用map
     */
    User getUser(@Param("phone") String uphone, @Param("password") String pwd);
    void addUser(@Param("phone") String phone,@Param("password") String password,@Param("name") String name, @Param("sex") String sex,@Param("uid") String uid, @Param("card") String card);
    User exsistUser(@Param("phone") String user_phone);
}
