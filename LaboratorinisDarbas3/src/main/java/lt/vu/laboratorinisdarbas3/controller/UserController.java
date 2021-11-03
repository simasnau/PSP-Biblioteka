package lt.vu.laboratorinisdarbas3.controller;

import lt.vu.laboratorinisdarbas3.model.User;
import lt.vu.laboratorinisdarbas3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) throws Exception {
        return userService.findById(userId);
    }

    @PostMapping()
    public User createUser(@RequestBody User user) throws Exception {
        return userService.createUser(user);
    }

    @PutMapping()
    public User updateUserById(@RequestBody User userInfo) throws Exception {
        return userService.updateUser(userInfo);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }
}
