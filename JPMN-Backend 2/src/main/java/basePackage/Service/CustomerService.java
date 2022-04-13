package basePackage.Service;

import basePackage.Dao.CustomerDao;
import basePackage.dataBaseClasses.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Repository
@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public void insertCustomer(Customer customer){
        customerDao.insertCustomer(customer.getCustomer_name(), customer.getCustomer_email(), customer.getSalt1(), customer.getCreditcard_number(), customer.getSalt2());
    }
    
    public Customer getCustomerById(int customer_ID){
        return customerDao.getCustomerById(String.valueOf(customer_ID));
    }
    
    public ArrayList<Customer> getAllCustomers(){
        return (ArrayList<Customer>) customerDao.getAllCustomers();
    }
    
    
    public void addCustomer(String user_name, String user_email, String user_creditcard, String user_password){
        customerDao.addCustomer(user_name, user_email, user_creditcard, user_password);
    }
    
    public void customerLogin(String users_email, String users_password){
        customerDao.existingUserLogin(users_email, users_password);
    }
    
    public String getValidationNumber(){
        String returnable = customerDao.getValidationNumber();
        
        return returnable;
    }
    
    public String getCustomerIDByEmail(String email){
        
        String returnable = customerDao.getCustomerIDByEmail(email);
        return returnable;
    }
    
    public String getMyBookings(String user_ID){
        
        String returnable = customerDao.getIndividualBookings(user_ID);
        return returnable;
    }
    
    public void bookTickets(String user_ID, String amountOfDesiredTickers, String movie_ID){
        customerDao.bookTickets(user_ID, amountOfDesiredTickers, movie_ID);
    }
    
    public void deleteOrder(String orderID){
        customerDao.delete_order(orderID);
    }
}
