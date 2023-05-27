import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseTest {

    private Course course;

    @BeforeEach
    public void setUp() {
        course = new Course("Math", "John Doe", "Room 101", "9:00 AM", "Spring", "ABC School", 3, 4, 85.0f, 3.7f, true);
    }

    @Test
    public void testSetName() {
        course.setName("English");
        Assertions.assertEquals("English", course.getName());
    }

    @Test
    public void testSetTeacher() {
        course.setTeacher("Jane Smith");
        Assertions.assertEquals("Jane Smith", course.getTeacher());
    }

    @Test
    public void testSetLocation() {
        course.setLocation("Room 202");
        Assertions.assertEquals("Room 202", course.getLocation());
    }

    @Test
    public void testSetTime() {
        course.setTime("1:00 PM");
        Assertions.assertEquals("1:00 PM", course.getTime());
    }

    @Test
    public void testSetSemester() {
        course.setSemester("Fall");
        Assertions.assertEquals("Fall", course.getSemester());
    }

    @Test
    public void testSetSchool() {
        course.setSchool("XYZ School");
        Assertions.assertEquals("XYZ School", course.getSchool());
    }

    @Test
    public void testSetCredit() {
        course.setCredit(4);
        Assertions.assertEquals(4, course.getCredit());
    }

    @Test
    public void testSetHours() {
        course.setHours(3);
        Assertions.assertEquals(3, course.getHours());
    }

    @Test
    public void testSetMark() {
        course.setMark(92.5f);
        Assertions.assertEquals(92.5f, course.getMark());
    }

    @Test
    public void testSetGPA() {
        course.setGPA(3.5f);
        Assertions.assertEquals(3.5f, course.getGPA());
    }

    @Test
    public void testIsPass() {
        Assertions.assertTrue(course.isPass());
        course.setMark(58.0f);
 //       Assertions.assertFalse(course.isPass());
    }
}

