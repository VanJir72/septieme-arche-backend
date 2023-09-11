package fr.demos.septemearchebackend.controller;



import fr.demos.septemearchebackend.exceptions.UserNotFoundException;
import fr.demos.septemearchebackend.model.Address;
import fr.demos.septemearchebackend.model.User;
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
@RequestMapping("/users")

public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final AddressService addressService;



    public UserController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }




    /* ================================================ createUtilisateur ================================================= */
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        for (Address ad: user.getAddresses()) {
            ad.  setUser(user);
        }
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    /* ==================================================================================================================== */

    /* ================================================ getAllUtilisateurs ================================================= */
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    /* ==================================================================================================================== */

    /* ================================================ getAllUtilisateurs ================================================= */
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    /* ==================================================================================================================== */

    /* ================================================ updateUtilisateur ================================================= */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user)  {
        return userService.updateUser(id, user);
    }
    /* ==================================================================================================================== */

    /* ================================================ deleteUtilisateur ================================================= */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) throws UserNotFoundException {
        if (userService.getUserById(id).isPresent()) {
            return ResponseHandler.responseBuilder("L'utilisateur avec l'id = " + id + ", a bien été supprimé.",
                    HttpStatus.OK, userService.deleteUser(id));
        } else {
            throw new UserNotFoundException("Aucun utilisateur a été trouvé avec l'id = " + id + ".");
        }
    }
    /* ==================================================================================================================== */

    /* ================================================ ajouterUneAdresse à un utilisateur ================================================= */
    @PutMapping("/ajouterUneAdresse/{id_User}")
    public String addAnAddressToUser(@PathVariable Long id_User, @RequestBody Address Address) {
        return userService.addAnAddressToUser(id_User, Address);
    }
    /* ==================================================================================================================== */


}
