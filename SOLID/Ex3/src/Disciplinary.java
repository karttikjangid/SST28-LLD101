

public class Disciplinary implements Eligibility {
    @Override
    public String evaluate(StudentProfile s) {
        if(s.disciplinaryFlag!=LegacyFlags.NONE){
            return "disciplinary flag present";
        }
        else return null;

    }
    
}
