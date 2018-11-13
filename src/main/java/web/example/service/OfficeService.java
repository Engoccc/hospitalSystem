package web.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.example.dao.OfficeDao;
import web.example.users.Office;

import java.util.List;

@Service
public class OfficeService {
    @Autowired
    OfficeDao officeDao;

    public List<Office> getOfficeByName(String office_name){
        List<Office> ol = officeDao.getOfficeByName(office_name);
        if(ol.isEmpty()) {
            System.out.println("Get Office Failed or no Office");
            return null;
        }
        else {
            for(Office o : ol)
                System.out.println(o.getOffice_id()+""+o.getOffice_name()+""+o.getDepartment_name());
            return ol;
        }
    }
}
