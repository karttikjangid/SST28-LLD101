import java.util.*;

public class ConsolePrinter {

    public void printErrors(List<String> errors){
        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return;
        }
    }

    public void printInput(String raw){
        System.out.println("INPUT: " + raw);

    }

    public void printConfirmation(StudentRecord rec , int totalStudents){
        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + totalStudents);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);

    }

    
}
