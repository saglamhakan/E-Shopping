package demo.EShopping.controllers;

import demo.EShopping.dataAccess.UserRepository;
import demo.EShopping.requests.AddUserRequest;
import demo.EShopping.requests.UpdateUserRequest;
import demo.EShopping.entities.User;
import demo.EShopping.exception.UserNotFoundException;
import demo.EShopping.responses.GetUserResponse;
import demo.EShopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userservice,
                          UserRepository userRepository){
        this.userService=userservice;
        this.userRepository = userRepository;
    }

    @GetMapping("/{userId}")
    public GetUserResponse getOneUserById(@PathVariable int userId){
        User user=userService.getOneUserById(userId);
        if (user==null){
            throw new UserNotFoundException("User not available");
        }
        return new GetUserResponse(user);

    }

    @GetMapping("/getAll")
    public List<GetUserResponse> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping("/add")
    public User createOneUser(@RequestBody AddUserRequest newUser){
        return userService.saveOneUser(newUser);
    }

    @PutMapping("{userId}")
    public User updateOneUser(@PathVariable  int userId, @RequestBody UpdateUserRequest newUser){
        return userService.updateoneUser(userId,newUser);

    }

    @DeleteMapping("/{userId}")
    public void deleteByUserId(@PathVariable int userId){
        userService.deleteByUserId(userId);
    }
}
