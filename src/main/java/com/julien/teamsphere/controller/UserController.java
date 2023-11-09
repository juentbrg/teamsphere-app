package com.julien.teamsphere.controller;

import com.julien.teamsphere.DTO.UserGetDTO;
import com.julien.teamsphere.DTO.UserPostDTO;
import com.julien.teamsphere.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/private/user")
public class UserController {

    private final UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/ping")
    public ResponseEntity<Void> ping() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateSession(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("JSESSIONID".equals(cookie.getName()) && cookie.getValue() != null) {
                    return ResponseEntity.ok(true);
                }
            }
        }
        return ResponseEntity.ok(false);
    }

    @GetMapping("/get")
    public List<UserGetDTO> findAllUser() {
        return userService.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserGetDTO> findByUserId(@PathVariable int id) {
        UserGetDTO user = userService.findById(id);
        if (null != user) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserPostDTO userPostDTO){
        logger.info("registerUser called with data {}", userPostDTO);
        try {
            userService.save(userPostDTO);
            return ResponseEntity.ok("{\"message\": \"User added successfully\"}");
        } catch (Exception e) {
            if ("Email already taken.".equals(e.getMessage())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"Email already taken.\"}");
            } else if ("Username already taken.".equals(e.getMessage())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"Username already taken.\"}");
            } else if ("Email is not valid".equals(e.getMessage())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"Email is not valid\"}");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"An error has occurred\"}");
            }
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> loginUser(HttpServletRequest request) {
        try {
            userService.authenticateUser(request.getParameter("email"), request.getParameter("password"));
            return ResponseEntity.ok("{\"message\": \"User authenticated successfully\"}");
        } catch (Exception e) {
            if ("Wrong email or password".equals(e.getMessage())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Wrong email or password\"}");
            }else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"An error has occurred\"}");
            }
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable int id) {
        logger.info("deleteUserById called with id {}", id);
        boolean isDeleted = userService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("{\"message\": \"User deleted successfully.\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable int id, @RequestBody UserPostDTO user) {
        logger.info("updateUserById called with id {} and data {}", id, user);
        boolean isUpdated = userService.updateById(id, user);
        if (isUpdated) {
            return ResponseEntity.ok("{\"message\": \"User successfully updated.\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
