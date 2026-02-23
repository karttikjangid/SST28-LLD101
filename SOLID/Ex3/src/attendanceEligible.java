

public class attendanceEligible implements Eligibility {
    int minAttendance;
    public attendanceEligible(RuleInput config){
        this.minAttendance=config.minAttendance;
    }
    @Override
    public String evaluate(StudentProfile s) {
        if(s.attendancePct<minAttendance){
            return "attendance below "+minAttendance;
        }
        else return null;
    }
    
}
