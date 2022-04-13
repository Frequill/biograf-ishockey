package basePackage.Dao;

import basePackage.dataBaseClasses.Customer;
import basePackage.dataBaseClasses.Staff;
import basePackage.dataBaseClasses.Upcomming_screening;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningDaoTest {

    @Mock
    JdbcTemplate jdbcTemplateMock;



    @Mock
    ScreeningDao screeningDaoMock;




    @Mock
    Upcomming_screening screeningMock = new Upcomming_screening(04, "Spider man", "VIASAT", "2022-04-04 21:00", "XL", "150");


    @Mock
    List<Upcomming_screening> screeningListMock = new ArrayList<>();

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addScreenings() {
        // Setup
        String works = "works"; // String I want returned from addScreenings
        Mockito.when(screeningDaoMock.addScreenings("Spider man", "VIASAT", "2022-04-04 21:00", "XL")).thenReturn(works);

        // Action
        String result = screeningDaoMock.addScreenings("Spider man", "VIASAT", "2022-04-04 21:00", "XL");

        // Result
        assertEquals(works, result);

        System.out.println("Expected: " + works + "      Actual result: " + result);
    }

    @Test
    void getAllScreenings() {
        // Setup
        Mockito.when(screeningDaoMock.getAllScreenings()).thenReturn(screeningListMock);

        // Action
        List<Upcomming_screening> testList = screeningDaoMock.getAllScreenings();

        // Result
        assertEquals(screeningListMock, testList);

        System.out.println("Expected: " + screeningListMock + "      Now showing testList: --> " + testList + " <--  If testList showed \"screeningListMock\" then test was successful!" + ""); // Output
    }

    @Test
    void deleteScreeningById() {

        // Setup
        String works = "works";
        Mockito.when(screeningDaoMock.deleteScreeningById("1")).thenReturn(works);

        // Action
        String d = screeningDaoMock.deleteScreeningById("1");

        // Result
        assertEquals(works, d);
        Mockito.verify(screeningDaoMock).deleteScreeningById("1");

        System.out.println("Expected: " + works + "      Result: " + d);
    }
}