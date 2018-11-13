package web.example.users;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Doctor {
    //@NotEmpty  ：既不能为null也不能为""，注意与@NotNull区别

    @NotEmpty
    @Size(min = 11,max = 11)
    private String phone;

    @NotEmpty
    private String name;

    @NotEmpty
    private String sex;


    //字符串用 @Size 数字用@Digits
    @NotEmpty
    @Size(min = 18,max = 18)
    private String did;//身份证号

    @NotEmpty
    private String ranks;


    @NotEmpty
    private String office;

    @NotNull
    private int doctor_price;

    public Doctor(){}

    public Doctor(String phone,String name,String sex,String did,String ranks,String office,int doctor_price){
        this.phone=phone;
        this.name=name;
        this.sex=sex;
        this.did=did;
        this.ranks=ranks;
        this.office = office;
        this.doctor_price = doctor_price;
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

    public String getOffice(){return office;}
    public void setOffice(String office){this.office = office;}


    public String getSex() {
        return sex;
    }
    public void setSex(String sex) { this.sex = sex; }

    public String  getDid() {
        return did;
    }
    public void setDid(String did){this.did = did;}

    public String getRanks() {
        return ranks;
    }
    public void setRanks(String ranks){this.ranks = ranks;}

    public int getDoctor_price(){return doctor_price;}
    public void setDoctor_price(int doctor_price){this.doctor_price = doctor_price;}
}
