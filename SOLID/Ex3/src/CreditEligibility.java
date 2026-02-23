
public class CreditEligibility implements Eligibility {
    int minCredits;
    public CreditEligibility(RuleInput config){
        this.minCredits=config.minCredits;
    }
    @Override
    public String evaluate(StudentProfile s) {
        if(s.earnedCredits<minCredits){
            
            return "credits below "+minCredits;
        }
        else return null;
    }
    
}
