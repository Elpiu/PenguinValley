package com.envy.penguinvalley.model.entity;

import com.envy.penguinvalley.regex.REGEX;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "User")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Pattern(regexp = REGEX.USER_USERNAME_REGEX,
            message = REGEX.USER_USERNAME_MESSAGES)
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Pattern(regexp = REGEX.USER_PASSWORD_REGEX,
            message = REGEX.USER_PASSWORD_MESSAGES)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "listAuthorities", nullable = false)
    private String listAuthorities;

    @Embedded
    private UserInfo userInfo;

    @Transient
    private List<GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authorities != null) return authorities;

        authorities = Arrays.stream(listAuthorities.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

}
