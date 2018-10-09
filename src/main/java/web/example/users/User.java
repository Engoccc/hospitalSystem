package web.example.users;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class User {
    @NotNull
    private String phone;
    @NotNull
    private String name;
    @NotNull
    private String sex;
    @NotNull
    private String password;

    @NotNull
    @Digits(integer = 18,fraction = 0)
    private String uid;//身份证号
    @NotNull
    @Digits(integer = 9,fraction = 0)
    private String card;


    public User(){}
    public User(String phone,String name,String sex,String uid,String card,String password){
        this.phone=phone;
        this.name=name;
        this.sex=sex;
        this.uid=uid;
        this.card=card;
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(long id) {
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public String getPassword(){return password;}
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) { this.sex = sex; }

}
