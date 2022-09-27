package jci.entreprise.performance.services;

import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public ResponseEntity<String> createUser(User user);//admin
    public ResponseEntity<String>deleteUser(Long id);//admin
    public ResponseEntity<String>updateUser(User user);//admin
    public List<User> getAllUser(); //admin user
}
