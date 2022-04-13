package basePackage.Service;

import basePackage.Dao.ShiftDao;
import basePackage.dataBaseClasses.Saloon;
import basePackage.dataBaseClasses.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShiftService
{
	@Autowired
	ShiftDao shiftDao;
	
	public ArrayList<Shift> getAllShifts(){return (ArrayList<Shift>) shiftDao.getAllShifts();
	}
	
	public void addShift(String shift_ID, String start_time, String end_time){
		shiftDao.addShift(shift_ID, start_time, end_time);
	}
	
	public void deleteShift(String shiftID){
		shiftDao.delete_shift(shiftID);
	}
}
