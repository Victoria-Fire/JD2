package jd2;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class StudentType3StrategyTest extends TestCase {
    private double talent;
    private double expected;

    public StudentType3StrategyTest(double talent, double expected) {
        this.talent = talent;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: testCountNumberOfHours -> с талантом {0} = {1}")
    public static Iterable<Object[]> dataForStudentType3StrategyTest() {
        return Arrays.asList(new Object[][]{{0.1, 5940}, {0.2, 2970}, {0.3, 1980}, {0.4, 1485},
                {0.5, 1188}, {0.6, 990}, {0.7, 848}, {0.8, 742}, {0.9, 660}, {1.0, 594}});
    }

    @Test
    public void testCountNumberOfHours() {
        SkillStrategy type3 = new StudentType3Strategy();

        EducationResult result = type3.countNumberOfHours(talent);
        assertEquals(expected, result.getHoursPracticalPart(), 0.6);

    }
}