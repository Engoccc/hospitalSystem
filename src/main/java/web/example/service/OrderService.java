package web.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.example.dao.OrderDao;
import web.example.users.Order;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public  void insertIn(String user_phone, String doctor_id, Date user_order_time, int user_order_price){
        orderDao.addOrder(user_phone,doctor_id,user_order_time,user_order_price);
    }

    public List<Order> getOrdersByUser(String user_phone){
        List<Order> ol = orderDao.getOrdersByUser(user_phone);
        if(ol.isEmpty()) {
            System.out.println("Get Order Failed or no order");
            return null;
        }
        else {
            for(Order i : ol)
                System.out.println(i.getUser_name()+""+i.getUser_phone()+" "+i.getDoctor_name()+" "+i.getUser_order_price()+" "+i.getUser_order_time());
            return ol;
        }
    }
}
