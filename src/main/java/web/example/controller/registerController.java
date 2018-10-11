package web.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.example.service.UserService;
import web.example.users.User;

import javax.servlet.http.HttpServletRequest;


@Controller

public class registerController {
        static String phone;
        static String checkNum;

        @Autowired
        UserService userService;

        @RequestMapping(value="/index",method = RequestMethod.GET)
        public String index() {
        return "index";
    }

        @RequestMapping("/register")
        public String showRegister(){
            return "register";
        }

//    @RequestMapping("/register/rstatus,method = RequestMethod.GET")
//    public String checkPhone(){
//
//        HttpClient client = new HttpClient();
//        PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
//        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
//        NameValuePair[] data ={ new NameValuePair("Uid", "735093244qq"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob","17725296243"),new NameValuePair("smsText","验证码：8888")};
//        post.setRequestBody(data);
//
//        try {
//            client.executeMethod(post);
//            Header[] headers = post.getResponseHeaders();
//            int statusCode = post.getStatusCode();
//            System.out.println("statusCode:" + statusCode);
//            for (Header h : headers) {
//                System.out.println(h.toString());
//            }
//            String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
//            System.out.println(result); //打印返回消息状态
//        }
//        catch (Exception e){}
//
//
//        post.releaseConnection();
//
//        return "PhoneCheck";
//    }

    public String getRadom(int length){
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

    @RequestMapping(value = "/register/rstatus",method = RequestMethod.GET)
    public String getCheckNum(@RequestParam("userPhone") String userPhone){
        String num = getRadom(6);
        phone = userPhone;
        checkNum = num;
        System.out.println("手机号码 "+phone+" 您的验证码是: "+checkNum);
        return "PhoneCheck";
    }

    @RequestMapping(value = "/register/rstatus",method = RequestMethod.POST)
    public String checkNum(String num){

     System.out.println("您输入的验证码是："+num);
     if(checkNum.equals(num)){
         System.out.println("验证通过！");
         return "registerForm";
     }
     else{
         System.out.println("验证失败！");
         return "rFailed";
     }
    }

    @RequestMapping(value = "/register/rstatus/submitUser",method = RequestMethod.POST)
    public String submitUser(User user){
            System.out.println(phone+" pwd: "+user.getPassword()+" name: "+user.getName()+" sex: "+user.getSex()+" uid:"+user.getUid()+" card: "+user.getCard());
            userService.insertIn(phone,user.getPassword(),user.getName(),user.getSex(),user.getUid(),user.getCard());
            return "success";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String logIn(){
            return "login";
    }
    @RequestMapping(value = "/checkInfo",method = RequestMethod.POST)
    public String checkInfo(HttpServletRequest request, User user){

        System.out.println("phone: " + user.getPhone() + ";Password: " + user.getPassword());
        if(userService.login(user.getPhone(),user.getPassword())){
            request.getSession().setAttribute("user",user);
            return "redirect:/userInfo";
        }
        else {
            return "login";
        }
    }

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public String showUser(){
            return "userInfo";
    }
}
