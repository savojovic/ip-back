package org.etf.unibl.services.impl;

import lombok.AllArgsConstructor;
import org.etf.unibl.models.entities.AddressEntity;
import org.etf.unibl.repositories.AddressRepository;
import org.etf.unibl.services.AddressService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public void saveAddress(AddressEntity address) {
        addressRepository.save(address);
    }
}
