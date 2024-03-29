package demo.EShopping.controllers;

import demo.EShopping.dataAccess.UserRepository;
import demo.EShopping.requests.AddUserRequest;
import demo.EShopping.requests.UpdateUserRequest;
import demo.EShopping.entities.User;
import demo.EShopping.responses.GetByIdUserResponse;
import demo.EShopping.responses.GetAllUserResponse;
import demo.EShopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userservice){
        this.userService=userservice;

    }

    @GetMapping("/{userId}")
    public GetByIdUserResponse findById(@PathVariable Long userId){
        return userService.getById(userId);
     /*
        GetByIdUserResponse user=userService.getById(userId);
        if (user==null){
            throw new UserNotFoundException("User not available");
        }
        return new GetByIdUserResponse();
*/
    }

    @GetMapping("/getAll")
    public List<GetAllUserResponse> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping("/add")
    public User createOneUser(@RequestBody AddUserRequest newUser){
        return userService.saveOneUser(newUser);
    }

    @PutMapping("{userId}")
    public User updateOneUser(@PathVariable  Long userId, @RequestBody UpdateUserRequest updateUserRequest){
        return userService.updateOneUser(userId, updateUserRequest);

    }

    @DeleteMapping("/{userId}")
    public void deleteByUserId(@PathVariable Long userId){
        userService.deleteByUserId(userId);
    }
}
