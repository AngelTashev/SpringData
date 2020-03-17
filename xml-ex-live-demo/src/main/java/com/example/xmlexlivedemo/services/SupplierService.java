package com.example.xmlexlivedemo.services;

import com.example.xmlexlivedemo.models.dtos.SupplierSeedDto;
import com.example.xmlexlivedemo.models.entities.Supplier;

import java.util.List;

public interface SupplierService {
    void seedSuppliers(List<SupplierSeedDto> supplierSeedDtos);

    Supplier getRandomSupplier();
}
