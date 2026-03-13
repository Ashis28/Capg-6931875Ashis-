package com.capg.assessment.services;

import com.capg.assessment.entities.Address;
import com.capg.assessment.entities.Customer;

public interface CustomerSerivce {
	Customer registerCustomer(String name, String email, String phone);
    Customer addAddressToCustomer(Long customerId, Address address);
}
