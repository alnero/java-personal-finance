package personalFinance.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personalFinance.model.User;
import personalFinance.repository.UserRepository;
import personalFinance.utils.UserDTO;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private ModelMapper modelMapper = new ModelMapper();

    @ResponseBody
    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable(value = "id") Long id) {
        User user = this.userRepository.findUserByUserId(id);
        return user;
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public User updateUserById(@PathVariable(value = "id") Long id, @RequestBody UserDTO userDTO) {
        User user = this.userRepository.findUserByUserId(id);
        modelMapper.map(userDTO, user);
        user = this.userRepository.save(user);
        return user;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void updateUserById(@PathVariable(value = "id") Long id) {
        this.userRepository.deleteById(id);
    }

    @ResponseBody
    @PostMapping
    public User createUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        modelMapper.map(userDTO, user);
        user = this.userRepository.save(user);
        return user;
    }
}
