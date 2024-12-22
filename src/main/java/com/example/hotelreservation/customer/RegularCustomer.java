
package com.example.hotelreservation.customer;

public class RegularCustomer implements CustomerProfile {
    @Override
    public String getProfileType() {
        return "Regular Customer";
    }
}
