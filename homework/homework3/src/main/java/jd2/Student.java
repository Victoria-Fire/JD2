package jd2;

import java.util.Locale;
import java.util.Random;

public class Student{

    private final double talent;
    private final EducationResult educationResult;
    private final SkillStrategy skillStrategy;

    public Student(SkillStrategy skillStrategy) {
        this.talent = Double.parseDouble(format((new Random().nextInt(10) + 1) / 10.0));
        this.skillStrategy = skillStrategy;
        this.educationResult = skillStrategy.countNumberOfHours(talent);
    }

    public void printInfo() {
        System.out.println("Студент типа " + skillStrategy.getStudentType());
        System.out.println("Талант равен - " + format(talent));

        double totalHours = 0;
        Double hoursAnalysis = educationResult.getHoursAnalysis();
        Double hoursPracticalPart = educationResult.getHoursPracticalPart();
        Double hoursFlow = educationResult.getHoursFlow();

        if (hoursAnalysis != null) {
            System.out.println("Время разбора - " + format(hoursAnalysis));
            totalHours += hoursAnalysis;
        }
        if (hoursPracticalPart != null) {
            System.out.println("Время практики - " + format(hoursPracticalPart));
            totalHours += hoursPracticalPart;
        }
        if (hoursFlow != null) {
            System.out.println("Время нахождения в потоке - " + format(hoursFlow));
            totalHours += hoursFlow;
        }
        System.out.println("Общее время - " + format(totalHours));
        System.out.println("=================================\n");
    }

    private String format(double value) {
        return String.format(Locale.US, "%.1f", value);
    }

}
