import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    // OCP violation: switch + add-on branching + printing + persistence.
    public void process(BookingRequest req , List<PriceEstimator> estimators) {
        double total_monthly = 0.0;

        for(PriceEstimator e : estimators){
            total_monthly += e.getPrice();
        }

        Money monthly = new Money(total_monthly);
        Money deposit = new Money(5000.0);
        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }
}
