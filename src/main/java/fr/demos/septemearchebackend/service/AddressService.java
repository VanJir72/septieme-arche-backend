package fr.demos.septemearchebackend.service;

import fr.demos.septemearchebackend.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address createAddress(Address Address);

    List<Address> getAllAddresses();

    Optional<Address> getAddressById(Long id);

    Address updateAddress(Long id, Address Address);

    String deleteAddress(Long id);
}
