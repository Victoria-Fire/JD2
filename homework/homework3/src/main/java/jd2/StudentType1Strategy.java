package jd2;

public class StudentType1Strategy implements SkillStrategy {

    @Override
    public EducationResult countNumberOfHours(double talent) {
        int hoursOneSkill = Main.TOTAL_NUMBER_HOURS_PER_COURS / 3;

        EducationResult educationResult = new EducationResult();
        educationResult.setHoursAnalysis(hoursOneSkill / talent);
        educationResult.setHoursPracticalPart(hoursOneSkill / talent);
        educationResult.setHoursFlow(hoursOneSkill / talent);
        return educationResult;
    }

    @Override
    public StudentType getStudentType() {
        return StudentType.FIRST;
    }
}
