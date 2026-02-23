import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        
        // 1. The Student's Request
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        
        // 2. Build THEIR specific shopping cart
        List<PriceEstimator> cart = new ArrayList<>();
        
        // Add the correct room
        cart.add(new DoubleRoom()); 
        
        // Add the correct add-ons
        cart.add(new LaundryPrice());
        cart.add(new MessPrice());
        
        // 3. Process the cart
        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo());
        calc.process(req, cart);
    }
}