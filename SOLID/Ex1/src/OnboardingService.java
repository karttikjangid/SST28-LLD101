import java.util.*;

public class OnboardingService {
    private final StudentRepository db;

    public OnboardingService(StudentRepository db) { this.db = db; }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {

        ConsolePrinter printer = new ConsolePrinter();
        printer.printInput(raw);


        // parsing 
        Parsing parsing = new Parsing();
        Map<String,String> kv = parsing.parseInput(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        // validation inline, printing inline
        StudentValidator validator = new StudentValidator();
        List<String> errors = validator.validate(name, email, phone, program);

        // error printing 
        if(errors.size() > 0){
        printer.printErrors(errors);
        return;
        }

        // SAVING in Database/Map
        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);

        // priting the output / savedd user
        printer.printConfirmation(rec, db.count());
    }
}
