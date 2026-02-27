public class ExportResult {
    public final String contentType;
    public final byte[] bytes;
    public boolean exportSuccessful;
    public String errorMessage;
    public ExportResult(String errorMessage) {
        this.errorMessage = errorMessage;
        this.exportSuccessful = false;
        this.contentType = null;
        this.bytes = null;
    }

    public ExportResult(String contentType, byte[] bytes) {
        this.contentType = contentType;
        this.bytes = bytes;
        exportSuccessful = true;
    }
}
