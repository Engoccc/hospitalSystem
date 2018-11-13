package web.example.users;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    //@NotEmpty  ：既不能为null也不能为""，注意与@NotNull区别

    @NotNull
    private int user_order_id;

    @NotEmpty
    private String user_name;

    @NotEmpty
    @Size(min = 11,max = 11)
    private String user_phone;

    @NotEmpty
    @Size(min = 18,max = 18)
    private String doctor_id;

    @NotEmpty
    private String doctor_name;

    @NotEmpty
    private String office_name;

    private Date user_order_time;

    @NotEmpty
    private int user_order_price;

    @NotEmpty
    private int pay_state;


    public Order(){}

    public Order(String user_name,String user_phone,String doctor_id,String doctor_name,String office_name,Date user_order_time,int user_order_price,int pay_state){
        this.user_phone = user_phone;
        this.user_name = user_name;
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.office_name = office_name;
        this.user_order_price = user_order_price;
        this.pay_state = pay_state;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = df.format(user_order_time);
        this.user_order_time = user_order_time;

    }

    public void setUser_order_id(int user_order_id) {
        this.user_order_id = user_order_id;
    }

    public int getUser_order_id() {
        return user_order_id;
    }

    public String getUser_phone() {
        return user_phone;
    }
    public void setUser_phone(String phone) {
        this.user_phone = phone;
    }

    public String getUser_name() { return user_name; }
    public void setUser_name(String user_name) { this.user_name = user_name; }

    public String getDoctor_name() { return doctor_name; }

    public void setDoctor_name(String doctor_name) { this.doctor_name = doctor_name; }

    public String getDoctor_id() {
        return doctor_id;
    }
    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getOffice_name() { return office_name; }

    public void setOffice_name(String office_name) { this.office_name = office_name; }

    public Date getUser_order_time(){return user_order_time;}
    public void setUser_order_time(Date user_order_time){this.user_order_time = user_order_time;}

    public int getUser_order_price() {
        return user_order_price;
    }
    public void setUser_order_price(int user_order_price) { this.user_order_price = user_order_price; }

    public int getPay_state() {
        return pay_state;
    }
    public void setPay_state(int pay_state) { this.pay_state = pay_state; }


}
