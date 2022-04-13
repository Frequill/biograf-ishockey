package basePackage.Service;

import basePackage.Dao.StaffDao;
import basePackage.dataBaseClasses.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Repository
@Service
public class StaffService {

    @Autowired
    StaffDao staffDao;

    public void insertStaff(Staff staff){
        staffDao.insertStaff(staff.getName(), staff.getSalary(), staff.getSalt1(), staff.getEmail_address(), staff.getSalt2());
    }

    public Staff getStaffById(int staff_ID){
        return staffDao.getStaffById(String.valueOf(staff_ID));
    }

    public ArrayList<Staff> getAllStaff(){
        return (ArrayList<Staff>) staffDao.getAllStaff();
    }
    
    public void deleteStaff(String s_ID){
        staffDao.delete_staff(s_ID);
    }
}
