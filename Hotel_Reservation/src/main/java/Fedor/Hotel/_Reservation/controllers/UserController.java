package Fedor.Hotel._Reservation.controllers;

//import com.ey.springboot3security.entity.AuthRequest;
//import com.ey.springboot3security.entity.UserInfo;
//import com.ey.springboot3security.service.JwtService;
//import com.ey.springboot3security.service.UserInfoService;

import Fedor.Hotel._Reservation.Dto.AuthRequest;
import Fedor.Hotel._Reservation.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import Fedor.Hotel._Reservation.service.JwtService;
import Fedor.Hotel._Reservation.service.UserInfoService;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome, this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public ResponseEntity<?> authenticateAndGetToken( @RequestBody AuthRequest authRequest) {
        System.out.println(authRequest.getEmail()+" "+authRequest.getPassword());
        try {
            // Authenticate using username and password from the request
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );

            // Check if the authentication was successful
            if (authentication.isAuthenticated()) {
                // Get UserDetails from the authentication object
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();

                // Generate a token for the authenticated user including their roles
                String token = jwtService.generateToken(userDetails);

                // Return the generated token with a 200 OK response
                return ResponseEntity.ok(token);
            } else {
                // If authentication was not successful, respond with 401 Unauthorized
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
            }
        } catch (AuthenticationException e) {
            System.out.println("Authentication exception: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


}
