package com.envy.penguinvalley.web;

import com.envy.penguinvalley.dto.AuthenticationRequestDTO;
import com.envy.penguinvalley.dto.AuthenticationResponseDTO;
import com.envy.penguinvalley.util.JwtUtil;
import com.envy.penguinvalley.web.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/")
public class AccessController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody AuthenticationRequestDTO authDTO) throws Exception {

        //Prova ad authenticare le credenziali in authDTO
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authDTO.getUsername(),
                            authDTO.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        //Crea il jwt Token
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authDTO.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponseDTO(jwt));
    }
}
