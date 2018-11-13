package web.example.dao;

import org.apache.ibatis.annotations.Param;
import web.example.users.Order;

import java.util.Date;
import java.util.List;

public interface OrderDao {
    void addOrder(@Param("user_phone") String user_phone, @Param("doctor_id") String doctor_id, @Param("user_order_time") Date user_order_time, @Param("user_order_price") int user_order_price);
    List<Order> getOrdersByUser(@Param("user_phone") String user_phone);
}
