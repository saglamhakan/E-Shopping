package demo.EShopping.security;

import demo.EShopping.dataAccess.UserRepository;
import demo.EShopping.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<demo.EShopping.entities.User> user = userRepository.findByEmail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user with email = " + email);
        } else {
            // Dinamik yetkilendirme
            for (Role role : user.get().getRoles()) { // 'Role' sizin kendi Role sınıfınız olmalı
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName().toUpperCase()));
            }
        }

        return new User(
                email,
                user.get().getPassword(),
                grantedAuthorities
        );
    }
}
