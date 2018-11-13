package web.example.dao;

import org.apache.ibatis.annotations.Param;
import web.example.users.Office;

import java.util.List;

public interface OfficeDao {
    List<Office> getOfficeByName(@Param("office_name") String office_name);
}
