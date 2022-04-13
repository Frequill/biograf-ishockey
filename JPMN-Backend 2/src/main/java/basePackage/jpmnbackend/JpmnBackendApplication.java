package basePackage.jpmnbackend;

import basePackage.Service.*;
import basePackage.Service.ShiftService;
import basePackage.dataBaseClasses.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
@ComponentScan(basePackages = "basePackage")


//Den här ska vara i domain-klassen som håller alla endpoints
@RestController
public class JpmnBackendApplication {
    
    public static ApplicationContext context;

    @Autowired
    CustomerService customerService;
    
    @Autowired
    StaffService staffService;
    
    @Autowired
    ScreeningService screeningService;
    
    @Autowired
    SaloonService saloonService;
    
    @Autowired
    ShiftService shiftService;
    
    public static void main(String[] args) {
        //SpringApplication.run(JpmnBackendApplication.class, args);
        
        
        //Skriver ut all info om customer_ID 1 från customers i databasen
        context = SpringApplication.run(JpmnBackendApplication.class, args);
        StaffService staffService = context.getBean(StaffService.class);
        CustomerService customerService = context.getBean(CustomerService.class);
        ScreeningService screeningService = context.getBean(ScreeningService.class);

        //System.out.println(customerService.getCustomerById(1));
        
    
        /* ArrayList<Customer> copy = customerService.getAllCustomers();
        
        for (int i = 0; i < copy.size(); i++){
            System.out.println(copy.get(i));
            System.out.println("");
        }*/
        
        //System.out.println(customerService.getAllCustomers().get(1));
       
        //Försök att stoppa in en ny customer
        //Customer Arnold = new Customer(5,"'Arnold Schwarzenegger'", "'bigaustiraman@fatgains.com'", "'5663378744005202'", "12'", "'24'");
        //customerService.insertCustomer(Arnold);
        
        
        //fel import, ändrade till Spring
        //.getBean gav error tills jag prövade de olika
        //context.getBean(Class<T>, object.. objects )
        
    
        //System.out.println(customerService.getCustomerById(1));
        
        /*
        SpringApplication.run(JpmnBackendApplication.class, args);
    
        CustomerService customerService = SpringApplication.run(JpmnBackendApplication.class, args).getBean(CustomerService.class);
        //CustomerService customerService = context.getBean(CustomerService.class);

        Customer Arnold = new Customer(2,"Arnold Schwarzenegger", "bigaustiraman@fatgains.com", "5663378744005202", "12", "12");
        //customerService.insertCustomer(Arnold);
        //System.out.println(customerService.;);
        
        customerService.getCustomerById(2);
        System.out.println(customerService.getCustomerById(2));


        // Problemet nu: Våran syntax är säkert fel, exakt hur fixar vi våran DAO klass?

        // Få våra stored procedures i MySQL att nås från IntelliJ
        // Hur vet vi ifall application.properties fungerar?
        */
    }
    
    @GetMapping ("/hello")
    public String testConnection(@RequestParam(value = "name", defaultValue = "error") String name){
        name = "The connection " + name;
        return name;
    }
    //POTENTIELL LYXFUNKTION, IF-SATS. SOM PRINTAR UT OM STAFF_ID INTE MATCHAR
    @GetMapping ("/getStaffByID")
    public String getStaffById(@RequestParam(value = "staff_ID", defaultValue = "incorrect input") String staff_id){
        StaffService staffService = context.getBean(StaffService.class);
        staff_id = String.valueOf(staffService.getStaffById(Integer.parseInt(staff_id)));
        return staff_id;
    }
    
    @GetMapping ("/getAllStaff")
    public String getAllStaff(){
        StaffService staffService = context.getBean(StaffService.class);
        ArrayList allStaff = staffService.getAllStaff();
        //String returnable = allStaff.toString();
        //String returnable = "";
        
        ArrayList<String> allStaffString = new ArrayList<>();
        
        for (int i = 0; i < allStaff.size(); i++){
            allStaffString.add(allStaff.get(i).toString());
            //returnable += i + "\n";
        }
    
        String returnable = allStaffString.toString();
        
        System.out.println("TEST\n" + returnable);
        return returnable;
    }
    
    @GetMapping("/addStaff")
    public String addStaff(@RequestParam(value = "valuesAsCSV", defaultValue = "Incomplete statement") String valuesAsCSV){
        
        String[] separatedValuesStaff = valuesAsCSV.split(",");
        
        Staff staff = new Staff(separatedValuesStaff[1], separatedValuesStaff[2], separatedValuesStaff[3], separatedValuesStaff[4], separatedValuesStaff[5]);
        StaffService staffService = context.getBean(StaffService.class);
        staffService.insertStaff(staff);
        
        return staff.toString();
    }
    
    @DeleteMapping ("/deleteStaffById")
    public void deleteStaffById(@RequestParam(value = "s_ID", defaultValue = "incorrect input") String staff_id) {
        staffService.deleteStaff(staff_id);
    }
    
    @GetMapping ("/getAllScreenings")
    public String getAllScreenings(){
        ScreeningService screeningService = context.getBean(ScreeningService.class);
        ArrayList allScreenings = screeningService.getAllScreenings();
        
        ArrayList<String> allScreeningsString = new ArrayList<>();
        
        for (int i = 0; i < allScreenings.size(); i++){
            allScreeningsString.add(allScreenings.get(i).toString());
        }
        
        String returnable = allScreeningsString.toString();
        
        System.out.println("TEST\n" + returnable);
        return returnable;
    }
    
    @RequestMapping ("/addScreening")
    public void addScreening(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
        String[] separatedValues = valuesAsCSV.split(",");
        
        screeningService.addScreening(separatedValues[1], separatedValues[2], separatedValues[3], separatedValues[4]);
        
    }
    
    @DeleteMapping ("deleteScreeningById")
    public void deleteScreeningById(@RequestParam(value = "movie_ID", defaultValue = "incorrect input") String movie_ID) {
        screeningService.deleteScreeningById(movie_ID);
    }
    
    @RequestMapping("/addSaloon")
    public void setAddSaloonService(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String values){
        String[] separatedValues = values.split(",");
        
        saloonService.addSaloon(separatedValues[1], separatedValues[2]);
    }
    
    @DeleteMapping ("/deleteSaloonByID")
    public void deleteSaloonById(@RequestParam(value = "saloon_ID", defaultValue = "incorrect input") String saloon_id) {
        saloonService.deleteSaloon(saloon_id);
    }
    
    @GetMapping ("/getAllSaloons")
    public String getAllSaloons(){
        StaffService staffService = context.getBean(StaffService.class);
        SaloonService saloonService = context.getBean(SaloonService.class);
        ArrayList allSaloons = saloonService.getAllSaloons();
        //String returnable = allStaff.toString();
        //String returnable = "";
        
        ArrayList<String> allSaloonsString = new ArrayList<>();
        
        for (int i = 0; i < allSaloons.size(); i++){
            allSaloonsString.add(allSaloons.get(i).toString());
            //returnable += i + "\n";
        }
        
        String returnable = allSaloonsString.toString();
        
        System.out.println("TEST\n" + returnable);
        return returnable;
    }
    
    @DeleteMapping ("/deleteShiftByID")
    public void deleteShiftById(@RequestParam(value = "shift_ID", defaultValue = "incorrect input") String shift_id) {
        shiftService.deleteShift(shift_id);
    }
    
    @RequestMapping ("/addShift")
    public void addShift(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
        String[] separatedValues = valuesAsCSV.split(",");
        
        shiftService.addShift(separatedValues[1], separatedValues[2], separatedValues[3]);
    }
    
    @GetMapping ("/getAllShifts")
    public String getAllShifts(){
        ShiftService shiftService = context.getBean(ShiftService.class);
        
        ArrayList allShifts = shiftService.getAllShifts();
        
        ArrayList<String> allShiftsString = new ArrayList<>();
        
        for (int i = 0; i < allShifts.size(); i++){
            allShiftsString.add(allShifts.get(i).toString());
        }
        
        String returnable = allShiftsString.toString();
        
        System.out.println("TEST\n" + returnable);
        return returnable;
    }
    
    @RequestMapping ("/addCustomer")
    public void addCustomer(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
        String[] separatedValues = valuesAsCSV.split(",");
        
        customerService.addCustomer(separatedValues[1], separatedValues[2], separatedValues[3], separatedValues[4]);
    }
    
    @RequestMapping ("/verify_customer")
    public void customerLogin(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
        String[] separatedValues = valuesAsCSV.split(",");
        
        customerService.customerLogin(separatedValues[1], separatedValues[2]);
    }
    
    @RequestMapping("/getLastValidationNumber")
    public String getValidationNumber(){
        String returnable = customerService.getValidationNumber();
        
        return returnable;
    }
    
    @RequestMapping ("/getUser_ID")
    public String getCustomerIDByEmail(@RequestParam(value = "userEmailAddress", defaultValue = "incorrect input") String email){
        System.out.println("HOHOHO" + email);
        String returnable = customerService.getCustomerIDByEmail(email);
        
        return returnable;
    }
    
    @RequestMapping ("/getMyBookings")
    public String getMyBookings(@RequestParam(value = "user_ID", defaultValue = "incorrect input") String user_ID){
        System.out.println("HOHOHO" + user_ID);
        String returnable = customerService.getMyBookings(user_ID);
        
        return returnable;
    }
    
    @RequestMapping ("/bookTickets")
    public void bookTickets(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
        System.out.println("Testing if values work: " + valuesAsCSV);
        String[] splitValues = valuesAsCSV.split(",");
        
        System.out.println("Testing if split is successful: " + splitValues[1] + " " + splitValues[2] + " " + splitValues[3]);
        
        customerService.bookTickets(splitValues[1], splitValues[2], splitValues[3]);
    }
    
    @DeleteMapping ("/deleteOrderByID")
    public void deleteOrderById(@RequestParam(value = "orderID", defaultValue = "incorrect input") String orderID) {
        customerService.deleteOrder(orderID);
    }
}