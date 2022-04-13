package basePackage.Dao;

import basePackage.dataBaseClasses.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShiftDao extends JdbcDaoSupport
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	private void initialize() {
		setJdbcTemplate(jdbcTemplate);
	}
	
	public List<Shift> getAllShifts() {
		String query = "SELECT * FROM shifts";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		List<Shift> shiftList = new ArrayList<>();
		
		for (Map<String, Object> row : rows) {
			Shift shift = new Shift(Integer.parseInt(row.get("shift_ID").toString()),
					(Integer.parseInt(row.get("staff_ID").toString())),
					(String) row.get("start_time"),
					(String) row.get("end_time"));
			shiftList.add(shift);
		}
		return shiftList;
	}
	
	public void addShift(String staff_ID, String start_time, String end_time) {
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String staff_IDSpaceFixed = staff_ID.replace("WHITESPACEHEREX", " ");
		String start_timeSpaceFixed = start_time.replace("WHITESPACEHEREX", " ");
		String end_timeSpaceFixed = end_time.replace("WHITESPACEHEREX", " ");
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_shift");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("staff_ID", staff_IDSpaceFixed);
		inParameters.put("start_time", start_timeSpaceFixed);
		inParameters.put("end_time", end_timeSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		simpleJdbcCall.execute(in);
	}
	
	public void delete_shift(String shiftID){
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_shift");
		
		Integer shiftIDToInt = Integer.parseInt(shiftID);
		
		simpleJdbcCall.execute(shiftIDToInt);
	}
}
