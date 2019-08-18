package personalFinance.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import personalFinance.model.MoneyFlow;
import personalFinance.model.User;
import personalFinance.repository.MoneyFlowRepository;
import personalFinance.repository.UserRepository;
import personalFinance.utils.UserDTO;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
    private MoneyFlowRepository moneyFlowRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserController(UserRepository userRepository, MoneyFlowRepository moneyFlowRepository) {
        this.userRepository = userRepository;
        this.moneyFlowRepository = moneyFlowRepository;
    }

    @ResponseBody
    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    @ResponseBody
    @GetMapping(value = "/all/{id}")
    public List<MoneyFlow> getArrivalAndExpenseById(@PathVariable(value = "id") Long id) {
        List<MoneyFlow> results = this.moneyFlowRepository.findAllByUserId(id);
        return results;
    }

    @ResponseBody
    @GetMapping(value = "/all/date/{date}")
    public List<MoneyFlow> getArrivalAndExpenseByDate(@PathVariable(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<MoneyFlow> results = this.moneyFlowRepository.findAllByCreationDate(date);
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
