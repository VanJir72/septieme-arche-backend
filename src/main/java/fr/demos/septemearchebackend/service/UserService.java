package fr.demos.septemearchebackend.service;

import fr.demos.septemearchebackend.model.Address;
import fr.demos.septemearchebackend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User updateUser(Long id, User user);
    String deleteUser(Long id);

    String addAnAddressToUser(Long id_User, Address Address);
}
