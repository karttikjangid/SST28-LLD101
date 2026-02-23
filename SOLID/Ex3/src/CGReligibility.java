
public class CGReligibility implements Eligibility {
    private double minCGR;
    public CGReligibility(RuleInput config){
        this.minCGR=config.minCgr;

    }
    @Override
    public String evaluate(StudentProfile s) {
        if(s.cgr<minCGR){
            
            return "CGR below"+minCGR;
        }
        else return null;
    }

    
}
