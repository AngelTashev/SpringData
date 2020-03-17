package com.example.xmlexlivedemo.services.impl;

import com.example.xmlexlivedemo.models.dtos.SupplierSeedDto;
import com.example.xmlexlivedemo.models.entities.Supplier;
import com.example.xmlexlivedemo.repositories.SupplierRepository;
import com.example.xmlexlivedemo.services.SupplierService;
import com.example.xmlexlivedemo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Random;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Random random;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Random random) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.random = random;
    }

    @Override
    public void seedSuppliers(List<SupplierSeedDto> supplierSeedDtos) {
        supplierSeedDtos
                .forEach(supplierSeedDto -> {
                    if(this.validationUtil.isValid(supplierSeedDto)){
                        if(this.supplierRepository
                                .findByName(supplierSeedDto.getName()) == null){

                            Supplier supplier = this.modelMapper
                                    .map(supplierSeedDto, Supplier.class);

                            this.supplierRepository.saveAndFlush(supplier);

                        }else {
                            System.out.println("Already in DB");
                        }
                    }else {
                        this.validationUtil
                                .violations(supplierSeedDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });
    }

    @Override
    public Supplier getRandomSupplier() {
        long randomId = this.random
                .nextInt((int) this.supplierRepository.count()) + 1;

        return this.supplierRepository.getOne(randomId);
    }
}
