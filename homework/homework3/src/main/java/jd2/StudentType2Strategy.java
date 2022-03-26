package jd2;

public class StudentType2Strategy implements SkillStrategy {

    @Override
    public EducationResult countNumberOfHours(double talent) {
        double timeType2 = Main.TOTAL_NUMBER_HOURS_PER_COURS * 2;
        double hoursOneSkill = timeType2 / 2;

        EducationResult educationResult = new EducationResult();
        educationResult.setHoursAnalysis(hoursOneSkill / talent);
        educationResult.setHoursPracticalPart(hoursOneSkill / talent);
        return educationResult;
    }

    @Override
    public StudentType getStudentType() {
        return StudentType.SECOND;
    }
}
