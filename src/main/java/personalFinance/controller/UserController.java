package personalFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personalFinance.model.User;
import personalFinance.repository.UserRepository;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
    public User updateUserById(@PathVariable(value = "id") Long id, @RequestBody String content) {
        User user = this.userRepository.findUserByUserId(id);
        user.setName(content);
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
    public User createUser(@RequestBody String content) {
        User user = new User(content);
        user = this.userRepository.save(user);
        return user;
    }


    /*
    private Map<Long, User> userMap = new HashMap<>();

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        Collection<User> collection = userMap.values();
        List<User> list = new ArrayList<>();
        list.addAll(collection);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "{userId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@PathVariable("userId") Long userId) throws UserNotFoundException {
        User user = this.userMap.get(userId);
        if (user == null) {
            throw new UserNotFoundException("User with id=" + userId + " not found");
        }
        user.setName("Some random content which updates user.");
        this.userMap.put(userId, user);
        return user;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody String userContent) {
        Long userId = ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE);
        User user = new User(userId, userContent);
        this.userMap.put(userId, user);
        return user;
    }


    @ResponseBody
    @RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userMap.remove(userId);
    }
    */
}
