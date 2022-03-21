package jd2;

public class StudentType3Strategy implements SkillStrategy {

    @Override
    public EducationResult countNumberOfHours(double talent) {
        double hoursOneSkill = Main.TOTAL_NUMBER_HOURS_PER_COURS * 3;

        EducationResult educationResult = new EducationResult();
        educationResult.setHoursPracticalPart(hoursOneSkill / talent);
        return educationResult;
    }

    @Override
    public StudentType getStudentType() {
        return StudentType.THIRD;
    }
}
