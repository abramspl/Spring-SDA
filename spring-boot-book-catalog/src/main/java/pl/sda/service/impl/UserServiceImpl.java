package pl.sda.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.model.Role;
import pl.sda.model.User;
import pl.sda.repository.RoleRepository;
import pl.sda.repository.UserRepository;
import pl.sda.service.UserService;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void save(User user) {

        //zaszyfrować hasło
        //przypisać użytkownikowi rolę USER
        //zapisać użytkownika do bazy danych

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); //do user ustawiamy zaszyfrowane hasło

        final Role roleUser = roleRepository.findByName("USER"); //pobieramy obiekt typu Rola z bazy danych

        user.setRoles(Arrays.asList(roleUser)); //do user przypisujemy rolę USER

        userRepository.save(user); //zapisujemy użytkownika do bazy danych

    }
}
