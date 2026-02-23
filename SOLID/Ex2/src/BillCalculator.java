import java.util.List;
import java.util.Map;

public class BillCalculator {

    public double calculateSubtotal(List<OrderLine> lines, Map<String, MenuItem> menu) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            subtotal += (item.price * l.qty);
        }
        return subtotal;
    }
    public double calculateTax(double subtotal, double taxPct) {
        return subtotal * (taxPct / 100.0);
    }
    public double calculateDiscount(double subtotal, String customerType, int itemCount) {
        return DiscountRules.discountAmount(customerType, subtotal, itemCount);
    }
    
}
