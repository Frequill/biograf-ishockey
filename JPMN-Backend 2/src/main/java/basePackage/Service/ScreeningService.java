package basePackage.Service;

import basePackage.Dao.ScreeningDao;
import basePackage.dataBaseClasses.Upcomming_screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ScreeningService
{
	
	@Autowired
	ScreeningDao screeningDao;
	
	public void addScreening(String title, String studio, String screening_date, String saloon){
		
		screeningDao.addScreenings(title, studio, screening_date, saloon);
	}
	
	public ArrayList<Upcomming_screening> getAllScreenings(){
		return (ArrayList<Upcomming_screening>) screeningDao.getAllScreenings();
	}
	
	public void deleteScreeningById(String movie_ID){
		screeningDao.deleteScreeningById(movie_ID);
	}
}