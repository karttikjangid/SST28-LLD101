import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final Storage store ;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(Storage store) { this.store = store; }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        // ConsolePrinter printer = new ConsolePrinter();
        String invId = "INV-" + (++invoiceSeq);
        BillCalculator calc = new BillCalculator();
        // printer.invoiceGenerator(invId);

        double subtotal = calc.calculateSubtotal(lines, menu);

        double taxPct = TaxRules.taxPercent(customerType);
        double tax = calc.calculateTax(subtotal, taxPct);
        
        double discount = calc.calculateDiscount(subtotal, customerType, lines.size());


        double total = subtotal + tax - discount;


        ReceiptGenerator receiptGen = new ReceiptGenerator();
        String receipt = receiptGen.buildReceipt(invId, lines, menu, subtotal, taxPct, tax, discount, total);
        store.save(invId, receipt);

        String printable = InvoiceFormatter.identityFormat(receipt);
        System.out.println(printable);
        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");

    }
}
