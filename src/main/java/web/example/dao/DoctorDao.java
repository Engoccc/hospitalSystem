package web.example.dao;

import org.apache.ibatis.annotations.Param;
import web.example.users.Doctor;

import java.util.List;

public interface DoctorDao {
    List<Doctor> getDoctors(@Param("office_name") String office_name);
    List<String> getDepartments();
    List<String> getOffices(@Param("department_name") String department_name);
}
