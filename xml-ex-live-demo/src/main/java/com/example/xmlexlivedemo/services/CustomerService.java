package com.example.xmlexlivedemo.services;

import com.example.xmlexlivedemo.models.dtos.CustomerSeedDto;
import com.example.xmlexlivedemo.models.dtos.CustomerViewRootDto;
import com.example.xmlexlivedemo.models.entities.Customer;

import java.util.List;

public interface CustomerService {
    void seedCustomers(List<CustomerSeedDto> customerSeedDtos);

    Customer getRandomCustomer();

    CustomerViewRootDto getAllOrderedCustomers();
}
