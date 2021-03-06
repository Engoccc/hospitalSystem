package web.example.users;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    //@NotEmpty  ：既不能为null也不能为""，注意与@NotNull区别
    @NotEmpty
    @Size(min = 11,max = 11)
    private String phone;

    @NotEmpty
    private String name;

    @NotEmpty
    private String sex;

    @NotEmpty
    private String password;

    //字符串用 @Size 数字用@Digits
    @NotEmpty
    @Size(min = 18,max = 18)
    private String uid;//身份证号

    @NotEmpty
    @Size(min = 9,max = 9)
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
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword(){return password;}
    public void setPassword(String pwd){this.password = pwd;}


    public String getSex() {
        return sex;
    }
    public void setSex(String sex) { this.sex = sex; }

    public String  getUid() {
        return uid;
    }
    public void setUid(String uid){this.uid = uid;}

    public String getCard() {
        return card;
    }
    public void setCard(String card){this.card = card;}

}
