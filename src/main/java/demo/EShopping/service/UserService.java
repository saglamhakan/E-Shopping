package demo.EShopping.service;

import demo.EShopping.requests.AddUserRequest;
import demo.EShopping.requests.UpdateUserRequest;
import demo.EShopping.dataAccess.UserRepository;
import demo.EShopping.entities.User;
import demo.EShopping.responses.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveOneUser(AddUserRequest newUser) {

        User toSave=new User();
        toSave.setUserId(newUser.getUserId());
        toSave.setUserName(newUser.getUserName());
        toSave.setPassword(newUser.getPassword());
        toSave.setEmail(newUser.getEmail());
        toSave.setAge(newUser.getAge());
        toSave.setBirthDate(newUser.getBirthDate());


        return userRepository.save(toSave);

    }

    public User updateoneUser(int userId, UpdateUserRequest newUser) {
        Optional<User> user=userRepository.findById(userId);
        if (user.isPresent()){
            User founduser=user.get();
            founduser.setUserName(newUser.getUserName());
            founduser.setPassword(newUser.getPassword());
            founduser.setBirthDate(newUser.getBirthDate());
            founduser.setEmail(newUser.getEmail());
            founduser.setAge(newUser.getAge());
            userRepository.save(founduser);
            return founduser;
        }else
        return null;
    }

    public void deleteByUserId(int userId) {
        userRepository.deleteById(userId);
    }

    public User getOneUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }


    public List<GetUserResponse> getAllUsers() {

        List<User> users=userRepository.findAll();
        List<GetUserResponse> userResponses=new ArrayList<GetUserResponse>();

        for (User user:users){
            GetUserResponse foundUser=new GetUserResponse(user);
            foundUser.setUserName(user.getUserName());

            userResponses.add(foundUser);

        }
        return userResponses;
    }

    public User getOneUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
