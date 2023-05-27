import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class clubTest {
    private Club testClub;

    @BeforeEach
    void setUp() {
        testClub = new Club("TestClub", "TestRole", "TestSemester", 10, 20, 30, true);
    }

    @Test
    void getname_Club() {
        assertEquals("TestClub", testClub.getname_Club());
    }

    @Test
    void getname_Role() {
        assertEquals("TestRole", testClub.getname_Role());
    }

    @Test
    void getSemester() {
        assertEquals("TestSemester", testClub.getSemester());
    }

    @Test
    void getCredit() {
        assertEquals(10, testClub.getCredit());
    }

    @Test
    void getHours() {
        assertEquals(20, testClub.getHours());
    }

    @Test
    void get_rolerank() {
        assertEquals(30, testClub.get_rolerank());
    }

    @Test
    void isverified() {
        assertTrue(testClub.isverified());
    }

    // Add more test cases for other methods.
}

