package com.example.projectreport.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
//    private AuthenticationManager authenticationManager;
//    CustomUserDetailsService customUserDetailsService;
//    private JwtUtil jwtUtil;
//    @PostMapping("/authenticate")
//    public String authenticate(@RequestBody AuthRequest authRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
//            );
//        } catch (Exception e) {
//            throw new Exception("invalid username or password");
//        }
//        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
//        return jwtUtil.generateToken(userDetails);
//    }
}
