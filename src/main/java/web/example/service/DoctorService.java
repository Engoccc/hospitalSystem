package web.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.example.dao.DoctorDao;
import web.example.users.Doctor;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorDao doctorDao;
    public List<Doctor> getDoctors(String office_name){
     List<Doctor> dl = doctorDao.getDoctors(office_name);
     if(dl.isEmpty()) {
         System.out.println("Get Doctors Failed or no doctors");
         return null;
     }
     else {
         for(Doctor i : dl)
             System.out.println(i.getDid()+i.getName()+i.getPhone()+i.getOffice()+i.getRanks()+i.getDoctor_price());
         return dl;
     }
     }

    public List<String> getDepartments(){
        List<String> dp =doctorDao.getDepartments();
        for(String i : dp)
            System.out.println(i);
        return dp;
    }

    public List<String> getOffices(String depn){
        List<String> offl =doctorDao.getOffices(depn);
        for(String i : offl)
            System.out.println(i);
        return offl;
    }
}
