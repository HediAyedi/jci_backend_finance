package jci.entreprise.performance.controllers;

import jci.entreprise.performance.entities.User;
import jci.entreprise.performance.services.UserService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/user")
///api/auth/signup
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody User user) {
        return userService.createUser(user);

    }
    
    
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody User user){
        return userService.updateUser(user);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
    	return userService.deleteUser(id);
    }
    
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
    	return userService.getAllUser();
    }
    
    
}



