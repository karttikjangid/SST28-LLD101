
import java.util.List;

public class Demo03 {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        RuleInput config = new RuleInput();
        List<Eligibility> rules = List.of(new Disciplinary() , new CGReligibility(config) , new CreditEligibility(config) , new attendanceEligible(config));
        EligibilityEngine engine = new EligibilityEngine(new FakeEligibilityStore(),rules);
        engine.runAndPrint(s);
    }
}
