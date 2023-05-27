import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

public class achieveTest {
    private std_Achieve stdAchieve;

    @BeforeEach
    public void setup() {
        stdAchieve = new std_Achieve();
    }

    @Test
    public void testAddAchievement() {
        stdAchieve.addAchievement("testUser", "testAchievement1");
        List<String> achievements = stdAchieve.getAchievements("testUser");
        assertTrue(achievements.contains("testAchievement1"));
    }

    @Test
    public void testRemoveAchievement() {
        stdAchieve.addAchievement("testUser", "testAchievement1");
        stdAchieve.removeAchievement("testUser", "testAchievement1");
        List<String> achievements = stdAchieve.getAchievements("testUser");
        assertFalse(achievements.contains("testAchievement1"));
    }

    @Test
    public void testModifyAchievement() {
        stdAchieve.addAchievement("testUser", "testAchievement1");
        stdAchieve.modifyAchievement("testUser", "testAchievement1", "testAchievement2");
        List<String> achievements = stdAchieve.getAchievements("testUser");
        assertFalse(achievements.contains("testAchievement1"));
        assertTrue(achievements.contains("testAchievement2"));
    }

    @Test
    public void testSaveAndLoad() throws IOException {
        stdAchieve.addAchievement("testUser", "testAchievement1");
        stdAchieve.saveToFile("testAchievements.txt");

        std_Achieve loadedStdAchieve = new std_Achieve();
        loadedStdAchieve.loadFromFile("testAchievements.txt");
        List<String> achievements = loadedStdAchieve.getAchievements("testUser");
        assertTrue(achievements.contains("testAchievement1"));
    }
}
