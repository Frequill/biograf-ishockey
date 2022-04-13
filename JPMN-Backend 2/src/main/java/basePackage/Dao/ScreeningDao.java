package basePackage.Dao;

import basePackage.dataBaseClasses.Upcomming_screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScreeningDao
{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * This method can fuck off!  //Julius           (But I fixed it!)
	 */


	// Method should be void, but has been made to return string for test purpose
	public String addScreenings(String title, String studio, String screening_date, String saloon) {
		
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String titleSpaceFixed = title.replace("WHITESPACEHEREX", " ");
		String studioSpaceFixed = studio.replace("WHITESPACEHEREX", " ");
		String screening_dateSpaceFixed = screening_date.replace("WHITESPACEHEREX", " ");
		String saloonSpaceFixed = saloon.replace("WHITESPACEHEREX", " ");
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_screening");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("title", titleSpaceFixed);
		inParameters.put("studio", studioSpaceFixed);
		inParameters.put("screening_date", screening_dateSpaceFixed);
		inParameters.put("saloon", saloonSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);

		String testReturnable = String.valueOf(simpleJdbcCall.execute(in));
		return testReturnable;
	}
	
	public List<Upcomming_screening> getAllScreenings() {
		String query = "SELECT * FROM upcomming_screenings";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		List<Upcomming_screening> screeningList = new ArrayList<>();
		
		for (Map<String, Object> row : rows) {
			Upcomming_screening upcomming_screening = new Upcomming_screening(Long.parseLong(row.get("movie_ID").toString()),
					(String) row.get("title"),
					(String) row.get("studio"),
					(String) row.get("screening_date"),
					(String) row.get("saloon"),
					(String) row.get("avalible_tickets").toString());
			screeningList.add(upcomming_screening);
		}
		return screeningList;
	}

	public String deleteScreeningById(String s_ID){

		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("deleteScreeningById");

		Integer s_IDToInt = Integer.parseInt(s_ID);

		String testReturnable = String.valueOf(simpleJdbcCall.execute(s_IDToInt));

		return testReturnable;
	}
	
	
}
