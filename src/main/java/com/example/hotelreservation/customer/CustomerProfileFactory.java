
package com.example.hotelreservation.customer;

public class CustomerProfileFactory {
    public static CustomerProfile createCustomerProfile(String type) {
        return switch (type.toLowerCase()) {
            case "regular" -> new RegularCustomer();
            case "vip" -> new VIPCustomer();
            case "corporate" -> new CorporateCustomer();
            default -> throw new IllegalArgumentException("Unsupported customer type: " + type);
        };
    }
}
