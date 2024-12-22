
package com.example.hotelreservation.customer;

public class CorporateCustomer implements CustomerProfile {
    @Override
    public String getProfileType() {
        return "Corporate Customer";
    }
}
