package com.envy.penguinvalley.web.security;

import com.envy.penguinvalley.model.entity.Amministratore;
import com.envy.penguinvalley.model.repository.AmministratoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class  MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AmministratoreRepository aRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        //return new User("foo", "foo", new ArrayList<>());
        Optional<Amministratore> admin = aRepository.findByUsername(username);
        if(!admin.isPresent()) throw new UsernameNotFoundException(
                "Username not found: " + username);

        //TODO gestione authorità andrebbe presa dal db
        ArrayList<GrantedAuthority> auth = new ArrayList<>();
        auth. add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return new User(admin.get().getUsername(),
                        admin.get().getPassword(),
                        auth);
    }

}
