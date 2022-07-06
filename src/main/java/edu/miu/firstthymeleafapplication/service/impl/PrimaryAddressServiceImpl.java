package edu.miu.firstthymeleafapplication.service.impl;

import edu.miu.firstthymeleafapplication.model.PrimaryAddress;
import edu.miu.firstthymeleafapplication.repository.PrimaryAddressRepository;
import edu.miu.firstthymeleafapplication.service.PrimaryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrimaryAddressServiceImpl implements PrimaryAddressService {

    @Autowired
    private PrimaryAddressRepository primaryAddressRepository;

    @Override
    public PrimaryAddress addNewPrimaryAddress(PrimaryAddress primaryAddress) {
        return primaryAddressRepository.save(primaryAddress);
    }
}
