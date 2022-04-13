package basePackage.Service;

import basePackage.Dao.SaloonDao;
import basePackage.Dao.StaffDao;
import basePackage.dataBaseClasses.Saloon;
import basePackage.dataBaseClasses.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Repository
@Service
public class SaloonService {
	
	@Autowired
	SaloonDao saloonDao;
	
	public ArrayList<Saloon> getAllSaloons(){
		return (ArrayList<Saloon>) saloonDao.getAllSaloons();
	}
	
	public void addSaloon(String saloon_name, String seats){
		saloonDao.addSaloon(saloon_name, seats);
	}
	
	public void deleteSaloon(String saloonID){
		saloonDao.delete_saloon(saloonID);
	}
}
