package web.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import web.example.service.DoctorService;
import web.example.service.OfficeService;
import web.example.service.OrderService;
import web.example.service.UserService;
import web.example.users.CustomGenericException;
import web.example.users.Order;
import web.example.users.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.Errors;

@Controller

public class registerController {
        static String phone;
        static String checkNum;

        @Autowired
        UserService userService;

        @Autowired
        DoctorService doctorService;

        @Autowired
        OrderService orderService;

        @Autowired
        OfficeService officeService;

        @RequestMapping("/construction")
        public String Construction() {
        return "construction";
    }

        @RequestMapping(value="/index",method = RequestMethod.GET)
        public String index() {
            return "index";
        }

        @RequestMapping("/register")
        public String showRegister(){
            return "register";
        }

    @RequestMapping("/p/photos")
    public String showPhotos(){
        return "photos";
    }

    public String getRadom(int length){
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }


    //判断是否位数字
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    //发送验证码
    @RequestMapping(value = "/register/rstatus",method = RequestMethod.GET)
    public String getCheckNum(@RequestParam(value = "userPhone",required = false) String userPhone,HttpServletRequest request){
        String num = getRadom(6);

        if( (!isNumeric(userPhone)) || userPhone.length() != 11 )
            throw new CustomGenericException("手机号不合法....");
        phone = userPhone;
        checkNum = "11111";

        if(!userService.exsistUser(userPhone)) {
            System.out.println("手机号码 " + phone + " 您的验证码是: " + checkNum);
            request.getSession().setAttribute("userPhone",userPhone);    //add
            return "register";
        }
        else {
            throw new CustomGenericException("该手机号已经注册，请直接登录");
        }
    }

    @RequestMapping(value = "/register/rstatus",method = RequestMethod.POST)
    public String checkNum(String num,Model model,HttpServletRequest request){

     System.out.println("您输入的验证码是："+num);
     if(checkNum.equals(num)){
         System.out.println("验证通过！");
         model.addAttribute("phone",phone);
         request.getSession().removeAttribute("userPhone");
         return "registerForm";
     }
     else{
         System.out.println("验证失败！");
         throw new CustomGenericException("验证码错误，测试期间验证码为5个1");
     }
    }

    @RequestMapping(value = "/register/rstatus/submitUser",method = RequestMethod.POST)
    public String submitUser(@Valid User user,Errors errors){
            System.out.println(phone+" pwd: "+user.getPassword()+" name: "+user.getName()+" sex: "+user.getSex()+" uid:"+user.getUid()+" card: "+user.getCard());
            if(errors.hasErrors()) {
                System.out.println(errors.toString());
                throw new CustomGenericException("表单校验错误，请检查您输入的信息......");
            }
            try {
                userService.insertIn(phone, user.getPassword(), user.getName(), user.getSex(), user.getUid(), user.getCard());
                return "successAdd";
            }
            catch (Exception e){
                System.out.println(e.toString());
                throw new CustomGenericException("后台插入数据库出错，请联系管理员.....");
            }
        }
//    @RequestMapping(value = "/register/rstatus/submitUser",method = RequestMethod.POST)
//    public String submitUser(@Valid String password, @Valid String name, @Valid String sex, @Valid String uid , @Valid String card,Errors errors){
//                if(errors.hasErrors()) {
//                    return "error.jsp";
//                }
//                System.out.println(phone + " pwd: " + password+" "+name+" "+uid+" "+card);
//                userService.insertIn(phone, password, name, sex, uid, card);
//                return "successAdd";
//
//    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String logIn(){
            return "login";
    }

    @RequestMapping(value = "/checkInfo",method = RequestMethod.POST)
    public String checkInfo(HttpServletRequest request, User user){
        System.out.println("phone: " + user.getPhone() + ";Password: " + user.getPassword());
        if(userService.login(user.getPhone(),user.getPassword())){
            User u = userService.getUser(user.getPhone(),user.getPassword());
            request.getSession().setAttribute("user",u);
            return "redirect:/userInfo";
        }
        else {
            return "login";
        }
    }


    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public String showUser(Model model,HttpServletRequest request){

        Object user = request.getSession().getAttribute("user");
        if(user != null) {
            model.addAttribute("user", user);
            return "userInfo";
        }
        else
            throw new CustomGenericException("当前无用户登录.....");
    }


    @RequestMapping("/logout")
    public String clearSession(HttpSession session){
        session.removeAttribute("user");
        System.out.println("clear session ok.");
        return "index";
    }

    @RequestMapping("/departments")
    public String getDepartments(Model model){
        model.addAttribute("departmentList",doctorService.getDepartments());
        return "departments";
    }

    @RequestMapping(value = "/departments/{department_name}",method = RequestMethod.GET)
    public String getOffices(@PathVariable("department_name") String department_name, Model model){
        model.addAttribute("officeList",doctorService.getOffices(department_name));
        return "offices";
    }
    @RequestMapping(value = "/offices/{office_name}",method = RequestMethod.GET)
    public String getDoctors(@PathVariable("office_name") String office_name, Model model){
        model.addAttribute("doctorList",doctorService.getDoctors(office_name));
        return "doctors";
    }

    @RequestMapping(value = "/mkOrder",method = RequestMethod.GET)
    public String mkOrder(HttpServletRequest request,Model model){

        Object user = request.getSession().getAttribute("user");
        String user_phone = "";
        String user_name = "";
        for (Field f:user.getClass().getDeclaredFields()){   //遍历通过反射获取object的类中的属性名
            f.setAccessible(true);    //设置改变属性为可访问
            try {
                if (f.getName().equals("phone")) {
                    user_phone = f.get(user).toString();
                    System.out.println("属性值" + f.get(user).toString());
                }
                if(f.getName().equals("name")){
                    user_name = f.get(user).toString();
                    System.out.println("属性值" + f.get(user).toString());
                }
            }
            catch (Exception e){}
        }

        int order_price =Integer.valueOf(request.getSession().getAttribute("price").toString()).intValue();

        orderService.insertIn(user_phone,request.getSession().getAttribute("did").toString(),new Date(),order_price);

        model.addAttribute("orderList",orderService.getOrdersByUser(user_phone));
        return "orders";
    }

    @RequestMapping("/myOrders")
    public  String getMyOrders(HttpServletRequest request,Model model){
            Object user = request.getSession().getAttribute("user");
            String user_phone = "";

            for (Field f:user.getClass().getDeclaredFields()){   //遍历通过反射获取object的类中的属性名
                f.setAccessible(true);    //设置改变属性为可访问
                try {
                    if (f.getName().equals("phone"))
                        user_phone = f.get(user).toString();
                }
                catch (Exception e){}
            }
            model.addAttribute("orderList",orderService.getOrdersByUser(user_phone));
            return "orders";
    }

    @RequestMapping(value = "/queryOffice",method = RequestMethod.POST)
    public String QueryOffice(Model model,String office_name){
    model.addAttribute("officeList",officeService.getOfficeByName(office_name));
    return "queryOfficeResult";
    }
}
