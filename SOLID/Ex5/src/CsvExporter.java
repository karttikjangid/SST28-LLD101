import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    public ExportResult doExport(ExportRequest req) {
        // LSP issue: changes meaning by lossy conversion
        String body = escape(req.body);
        String csv = "title,body\n" + escape(req.title) + "," + escape(req.body) + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    // to handle correct CSV with , and \n in the input 
    public String escape(String s){
        if (s == null) return "";
        // 1. Double up any existing quotes
        String escaped = s.replace("\"", "\"\"");
        // 2. Wrap the whole thing in quotes so commas and newlines are safely trapped inside
        return "\"" + escaped + "\"";
    }
}
