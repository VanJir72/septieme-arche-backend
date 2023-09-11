package fr.demos.septemearchebackend.service.impl;


import fr.demos.septemearchebackend.exceptions.UserNotFoundException;
import fr.demos.septemearchebackend.model.Address;
import fr.demos.septemearchebackend.model.User;
import fr.demos.septemearchebackend.repository.AddressRepository;
import fr.demos.septemearchebackend.repository.UserRepository;
import fr.demos.septemearchebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserServiceImpl(UserRepository userRepository,
                           AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() throws UserNotFoundException {
        List<User> users = userRepository.findAll();
        if (users.size() > 0) {
            return users;
        } else {
            throw new UserNotFoundException("Pas de resultat !");
        }
    }

    @Override
    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id);
        } else {
            throw new UserNotFoundException("Aucun utilisateur a été trouvé avec l'id = " + id + ".");
        }
    }

    @Override
    public User updateUser(Long id, User user) throws UserNotFoundException {
        if (userRepository.findById(id).isPresent()) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException("Aucun user a été trouvé avec l'id = " + id + ".");
        }
    }


    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "OK";
    }


    @Override
    public String addAnAddressToUser(Long id_User, Address Address) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id_User);
        if (user.isPresent()) {
            addressRepository.save(Address);
            Address.getUser().setId(id_User);
            user.get().getAddresses().add(Address);
            System.out.println(Address.toString());

            return "OK pour ajouter la nouvelle Address de (id) = " + Address.getId();
        } else {
            throw new UserNotFoundException("Aucun utilisateur a été trouvé avec l'id = " + id_User + ".");
        }
    }



}
