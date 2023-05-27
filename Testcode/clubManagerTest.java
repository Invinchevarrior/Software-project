
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class clubManagerTest {
    private club_Manager manager;

    @BeforeEach
    void setUp() {
        manager = new club_Manager();
    }

    @Test
    void add_and_get_clubs() {
        Club testClub = new Club("TestClub", "TestRole", "TestSemester", 10, 20, 30, true);
        manager.addclub(testClub);
        assertTrue(manager.getclubs().contains(testClub));
    }

    @Test
    void remove_club() {
        Club testClub = new Club("TestClub", "TestRole", "TestSemester", 10, 20, 30, true);
        manager.addclub(testClub);
        manager.removeclub(testClub);
        assertFalse(manager.getclubs().contains(testClub));
    }

    // Add more test cases for other methods.
}

