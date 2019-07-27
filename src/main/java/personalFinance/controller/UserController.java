package personalFinance.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personalFinance.model.*;
import personalFinance.repository.*;
import personalFinance.utils.UserDTO;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
    private ArrivalRepository arrivalRepository;
    private ExpenseRepository expenseRepository;

    @Autowired
    public UserController(UserRepository userRepository,
                          ArrivalRepository arrivalRepository,
                          ExpenseRepository expenseRepository) {
        this.userRepository = userRepository;
        this.arrivalRepository = arrivalRepository;
        this.expenseRepository = expenseRepository;
    }

    private ModelMapper modelMapper = new ModelMapper();

    @ResponseBody
    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    @ResponseBody
    @GetMapping(value = "/all/{id}")
    public List<Object> getArrivalAndExpenceById(@PathVariable(value = "id") Long id) {
        List<Object> results = new ArrayList<>();
        List<Arrival> arrivals = this.arrivalRepository.findAllByUserId(id);
        List<Expense> expenses = this.expenseRepository.findAllByUserId(id);
        results.addAll(arrivals);
        results.addAll(expenses);
        return results;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable(value = "id") Long id) {
        User user = this.userRepository.findUserById(id);
        return user;
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public User updateUserById(@PathVariable(value = "id") Long id, @RequestBody UserDTO userDTO) {
        User user = this.userRepository.findUserById(id);
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
