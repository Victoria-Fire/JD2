package jd2;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class StudentType2StrategyTest extends TestCase {
    private double talent;
    private double expected;

    public StudentType2StrategyTest(double talent, double expected) {
        this.talent = talent;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: testCountNumberOfHours -> с талантом {0} = {1}")
    public static Iterable<Object[]> dataForStudentType2StrategyTest() {
        return Arrays.asList(new Object[][]{{0.1, 1980}, {0.2, 990}, {0.3, 660}, {0.4, 495},
                {0.5, 396}, {0.6, 330}, {0.7, 282}, {0.8, 247}, {0.9, 220}, {1.0, 198}});
    }

    @Test
    public void testCountNumberOfHours() {
        SkillStrategy type2 = new StudentType2Strategy();

        EducationResult result = type2.countNumberOfHours(talent);
        assertEquals(expected, result.getHoursAnalysis(), 0.9);
        assertEquals(expected, result.getHoursPracticalPart(), 0.9);
    }
}