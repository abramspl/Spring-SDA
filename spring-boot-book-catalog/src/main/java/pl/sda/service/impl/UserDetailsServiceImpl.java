package pl.sda.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.model.User;
import pl.sda.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User userFromDb = userRepository.findByUsername(username);

        final List<String> roles = userFromDb.getRoles()
                .stream()
                .map(r -> r.getName())
                .collect(Collectors.toList());

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(userFromDb.getUsername())
                .password(userFromDb.getPassword())
                .roles(roles.toArray(new String[0]))
                .build();
    }
}
