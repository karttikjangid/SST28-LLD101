public abstract class Exporter {
    // implied "contract" but not enforced (smell)
    public ExportResult export(ExportRequest req){
        if(req==null){
            return new ExportResult("Request cannot be null");
        }
        return doExport(req);
    }
    public abstract ExportResult doExport(ExportRequest req);
}
