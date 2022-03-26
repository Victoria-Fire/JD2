package jd2;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class StudentType1StrategyTest extends TestCase {
    double talent;
    double expected;

    public StudentType1StrategyTest(double talent, double expected) {
        this.talent = talent;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: testCountNumberOfHours -> с талантом {0} = {1}")
    public static Iterable<Object[]> dataForStudentType1StrategyTest() {
        return Arrays.asList(new Object[][]{{0.1, 660}, {0.2, 330}, {0.3, 220}, {0.4, 165},
                {0.5, 132}, {0.6, 110}, {0.7, 94}, {0.8, 82}, {0.9, 73}, {1.0, 66}});
    }


    @Test
    public void testCountNumberOfHours() {
        SkillStrategy type1 = new StudentType1Strategy();

        EducationResult result = type1.countNumberOfHours(talent);
        assertEquals(expected, result.getHoursAnalysis(), 0.5);
        assertEquals(expected, result.getHoursPracticalPart(), 0.5);
        assertEquals(expected, result.getHoursFlow(), 0.5);
    }
}