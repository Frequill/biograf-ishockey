package basePackage.Dao;

import basePackage.dataBaseClasses.Saloon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SaloonDao
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Saloon> getAllSaloons() {
		String query = "SELECT * FROM saloons";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		List<Saloon> saloonList = new ArrayList<>();
		
		for (Map<String, Object> row : rows) {
			Saloon saloon = new Saloon(Integer.parseInt(row.get("saloon_ID").toString()),
					(String) row.get("saloon_name"),
					(int) row.get("seats"));
			saloonList.add(saloon);
		}
		return saloonList;
	}
	
	public void addSaloon(String saloon_name, String seats){
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String titleSpaceFixed = saloon_name.replace("WHITESPACEHEREX", " ");
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_saloon");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("saloon_name", titleSpaceFixed);
		inParameters.put("seats", seats);
		
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		simpleJdbcCall.execute(in);
	}
	
	public void delete_saloon(String saloonID){
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_saloon");
		
		Integer saloonIDToInt = Integer.parseInt(saloonID);
		
		simpleJdbcCall.execute(saloonIDToInt);
	}
	
}
