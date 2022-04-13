package basePackage.Dao;

import basePackage.dataBaseClasses.Customer;
import basePackage.dataBaseClasses.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StaffDaoTest {



    @Mock
    JdbcTemplate jdbcTemplateMock;



    @Mock
    StaffDao staffDaoMock;




    @Mock
    Staff staffMock = new Staff(01, "Anders", "5000", "salt1", "anders@mail.com", "salt2");


    @Mock
    List<Staff> staffListMock = new ArrayList<>();

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void insertStaff(){


//   Setup
        String query = "INSERT INTO staff(name, salary, salt1, email_address, salt2) VALUES (?, ?, ?, ?, ? )";
        Mockito.when(jdbcTemplateMock.update(query, "Anders", "5000", "salt1", "anders@mail.com", "salt2")).thenReturn(1);

// Action
        int i = jdbcTemplateMock.update(query, "Anders", "5000", "salt1", "anders@mail.com", "salt2");


        // Result

        assertEquals(1,i);

    }

    @Test
    void getStaffById() {

        // Setup
        Mockito.when(staffDaoMock.getStaffById(Mockito.anyString())).thenReturn(staffMock);

        // Action
        Staff e = staffDaoMock.getStaffById("1");

        // Result
        assertEquals(staffMock, e);
        Mockito.verify(staffDaoMock).getStaffById("1");

        System.out.println("Expected: " + staffMock + "      Result: " + e);
    }

    @Test
    void getAllStaff() {
        // Setup
        Mockito.when(staffDaoMock.getAllStaff()).thenReturn(staffListMock);

        // Action
        List<Staff> testList = staffDaoMock.getAllStaff();

        // Result
        assertEquals(staffListMock, testList);

        System.out.println("Expected: " + staffListMock + "      Now showing testList: --> " + testList + " <--  If testList showed \"staffListMock\" then test was successful!" + ""); // Output
    }



    @Test
    void delete_staff() {

        // Setup
        String works = "works";
        Mockito.when(staffDaoMock.delete_staff("1")).thenReturn(works);

        // Action
        String d = staffDaoMock.delete_staff("1");

        // Result
        assertEquals(works, d);
        Mockito.verify(staffDaoMock).delete_staff("1");

        System.out.println("Expected: " + works + "      Result: " + d);
    }
}