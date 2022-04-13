package basePackage.Dao;

import basePackage.dataBaseClasses.Customer;
import basePackage.dataBaseClasses.Shift;
import basePackage.dataBaseClasses.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
@Repository
public class CustomerDao extends JdbcDaoSupport
{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @PostConstruct
    private void initialize(){
        setJdbcTemplate(jdbcTemplate);
    }
    
    public void insertCustomer(String customer_name, String customer_email, String salt1, String creditcard_number, String salt2){
        
        String query = "INSERT INTO customers(customer_name, customer_email, salt1, creditcard_number, salt2) VALUES ?, ?, ?, ?, ?)";
        
        int result = jdbcTemplate.update(query, customer_name, customer_email, salt1, creditcard_number, salt2);
        
        if (result > 0){
            System.out.println(result + " customer added to database");
        }
    }
    
    public Customer getCustomerById(String id){
        String query = "SELECT * FROM customers WHERE customer_ID = ?";
        
        Customer customer = jdbcTemplate.queryForObject(query, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer cus = new Customer(rs.getInt("customer_ID"),
                    rs.getString("customer_name"),
                    rs.getString("customer_email"),
                    rs.getString("salt1"),
                    rs.getString("creditcard_number"),
                    rs.getString("salt2"));
                
                    return cus;
                }
        }, id);
        
        return customer;
    }
    
    public List<Customer> getAllCustomers(){
        String query = "SELECT * FROM customers";
        
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        List<Customer> customerList = new ArrayList<>();
        
        for (Map<String, Object> row: rows){
            Customer customer = new Customer((long)row.get("customer_ID"),
                    (String)row.get("customer_name"),
                    (String)row.get("customer_email"),
                    (String)row.get("salt1"),
                    (String)row.get("creditcard_number"),
                    (String)row.get("salt2"));
            customerList.add(customer);
        }
        
        return customerList;
    }
    
    public void addCustomer(String user_name, String user_email, String user_creditcard, String user_password) {
        // If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
        // This phrase is raplaced back with a space here so that the String takes its original form with spaces included
        // (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
        String user_nameSpaceFixed = user_name.replace("WHITESPACEHEREX", " ");
        String user_emailSpaceFixed = user_email.replace("WHITESPACEHEREX", " ");
        String user_creditcardSpaceFixed = user_creditcard.replace("WHITESPACEHEREX", " ");
        String user_passwordSpaceFixed = user_password.replace("WHITESPACEHEREX", " ");
        
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_customer");
        
        Map<String, String> inParameters = new HashMap<>();
        
        inParameters.put("customer_name", user_nameSpaceFixed);
        inParameters.put("customer_email", user_emailSpaceFixed);
        inParameters.put("creditcard_number", user_creditcardSpaceFixed);
        inParameters.put("customer_password", user_passwordSpaceFixed);
        
        SqlParameterSource in = new MapSqlParameterSource(inParameters);
        
        simpleJdbcCall.execute(in);
        
        //simpleJdbcCall.execute(user_nameSpaceFixed, user_emailSpaceFixed, user_creditcardSpaceFixed, user_passwordSpaceFixed );
    }
    
    public void existingUserLogin (String users_email, String users_password){
        String users_emailSpaceFixed = users_email.replace("WHITESPACEHEREX", " ");
        String users_passwordSpaceFixed = users_password.replace("WHITESPACEHEREX", " ");
    
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("verify_customer");
    
        Map<String, String> inParameters = new HashMap<>();
    
        inParameters.put("users_email", users_emailSpaceFixed);
        inParameters.put("users_password", users_passwordSpaceFixed);
    
        SqlParameterSource in = new MapSqlParameterSource(inParameters);
    
        String.valueOf(simpleJdbcCall.execute(in));
        
        
    }
    
    public String getValidationNumber(){
        String query = "SELECT * FROM user_validation";
    
        String answer = String.valueOf(jdbcTemplate.queryForList(query));
        
        return answer;
    }
    
    public String getCustomerIDByEmail(String email){
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_customerIDByEmail");
        String answer = String.valueOf(simpleJdbcCall.execute(email));
        
        System.out.println("answer " + answer);
        return answer;
    }
    
    public String getIndividualBookings(String user_ID){
        String query = "SELECT * FROM transactions WHERE customer_ID = " + user_ID;
    
        String answer = String.valueOf(jdbcTemplate.queryForList(query));
    
        return answer;
    }
    
    public void bookTickets(String customer_ID, String amountOfDesiredTickets, String movie_ID) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("book_tickets");
        
        Map<String, String> inParameters = new HashMap<>();
        
        inParameters.put("customer_ID",customer_ID);
        inParameters.put("tickets", amountOfDesiredTickets);
        inParameters.put("movie_by_ID", movie_ID);
        
        SqlParameterSource in = new MapSqlParameterSource(inParameters);
        
        simpleJdbcCall.execute(in);
    }
    
    public void delete_order(String orderID){
        
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_order");
        
        Integer orderIDToInt = Integer.parseInt(orderID);
        
        simpleJdbcCall.execute(orderIDToInt);
    }
}
