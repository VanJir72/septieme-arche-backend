package fr.demos.septemearchebackend.service.impl;

import fr.demos.septemearchebackend.exceptions.AddressNotFoundException;
import fr.demos.septemearchebackend.model.Address;
import fr.demos.septemearchebackend.repository.AddressRepository;
import fr.demos.septemearchebackend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Address createAddress(Address Address) {
        return addressRepository.save(Address);
    }

    @Override
    public List<Address> getAllAddresses() throws AddressNotFoundException {
        List<Address> addresses = addressRepository.findAll();
        if (addresses.size() > 0) {
            return addresses;
        } else {
            throw new AddressNotFoundException("Pas de resultat !");
        }
    }

    @Override
    public Optional<Address> getAddressById(Long id) throws AddressNotFoundException {
        if (addressRepository.findById(id).isPresent()) {
            return addressRepository.findById(id);
        } else {
            throw new AddressNotFoundException("Aucune adresse a été trouvé avec l'id = " + id + ".");
        }
    }

    @Override
    public Address updateAddress(Long id, Address Address) throws AddressNotFoundException {
        if (addressRepository.findById(id).isPresent()) {
            Address.setId(id);
            return addressRepository.save(Address);
        } else {
            throw new AddressNotFoundException("Aucune Address a été trouvé avec l'id = " + id + ".");
        }
    }

    @Override
    public String deleteAddress(Long id) {
        addressRepository.deleteById(id);
        return "OK";
    }
}
