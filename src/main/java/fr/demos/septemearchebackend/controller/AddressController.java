package fr.demos.septemearchebackend.controller;


import fr.demos.septemearchebackend.exceptions.AddressNotFoundException;
import fr.demos.septemearchebackend.model.Address;
import fr.demos.septemearchebackend.response.ResponseHandler;
import fr.demos.septemearchebackend.service.AddressService;
import fr.demos.septemearchebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private final AddressService addressService;




    public AddressController(AddressService addressService) {
        this.addressService = addressService;

    }


    /* ================================================== createAdresse =================================================== */
    @PostMapping()
    public ResponseEntity<Address> createAdresse(@RequestBody Address addresse) {
        Address createdAddress = addressService.createAddress(addresse);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }
    /* ==================================================================================================================== */

    /* ================================================== getAllAdresses ================================================== */
    @GetMapping()
    public List<Address> getAllAdresses() {
        return addressService.getAllAddresses();
    }


    /* ==================================================================================================================== */

    /* ================================================== getAdresseById ================================================== */
    @GetMapping("/{id}")
    public Optional<Address> getAdresseById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }
    /* ==================================================================================================================== */

    /* ================================================== updateAdresse ================================================== */
    @PutMapping("/{id}")
    public Address updateAdresse(@PathVariable Long id, @RequestBody Address Address) {
        return addressService.updateAddress(id, Address);
    }
    /* =================================================================================================================== */

    /* ================================================== deleteAdresse ================================================== */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAdresse(@PathVariable Long id) throws AddressNotFoundException {
        if (addressService.getAddressById(id).isPresent()) {
            return ResponseHandler.responseBuilder("L'adresse avec l'id = " + id + ", a bien été supprimé.",
                    HttpStatus.OK, addressService.deleteAddress(id));
        } else {
            throw new AddressNotFoundException("Aucune adresse a été trouvé avec l'id = " + id + ".");
        }
    }
    /* =================================================================================================================== */
}











