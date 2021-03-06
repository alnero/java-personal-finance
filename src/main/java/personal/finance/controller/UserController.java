package personal.finance.controller;

import personal.finance.model.User;
import personal.finance.exception.UserNotFoundException;
import java.util.Collection;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
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
    @RequestMapping(value = "{userId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@PathVariable("userId") Long userId) throws UserNotFoundException {
        User user = this.userMap.get(userId);
        if (user == null) {
            throw new UserNotFoundException("User with id=" + userId + " not found");
        }
        user.setUserContent("Some random content which updates user.");
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
    @RequestMapping(value = "{userId}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userMap.remove(userId);
    }
}
