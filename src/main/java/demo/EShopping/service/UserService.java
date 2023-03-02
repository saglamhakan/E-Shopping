package demo.EShopping.service;

import demo.EShopping.mappers.ModelMapperService;
import demo.EShopping.requests.AddUserRequest;
import demo.EShopping.requests.UpdateUserRequest;
import demo.EShopping.dataAccess.UserRepository;
import demo.EShopping.entities.User;
import demo.EShopping.responses.GetByIdUserResponse;
import demo.EShopping.responses.GetAllUserResponse;
import demo.EShopping.rules.UserBusinessRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    private ModelMapperService modelMapperService;

    private UserBusinessRules userBusinessRules;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapperService modelMapperService, UserBusinessRules userBusinessRules) {
        this.userRepository = userRepository;
        this.modelMapperService=modelMapperService;
        this.userBusinessRules=userBusinessRules;
    }

    public User saveOneUser(AddUserRequest newUser) {
        this.userBusinessRules.existsByUserName(newUser.getUserName());
        this.userBusinessRules.existsByEmail(newUser.getEmail());
        this.userBusinessRules.addPassword(newUser.getPassword());
        User user=this.modelMapperService.forRequest().map(newUser, User.class);

        return userRepository.save(user);

    }

    public void updateOneUser(Long userId, UpdateUserRequest updateUserRequest) {
        User user=this.modelMapperService.forRequest().map(updateUserRequest,User.class);
         userRepository.save(user);

    }

    public void deleteByUserId(Long userId) {
        userRepository.deleteById(userId);
    }

    public GetByIdUserResponse getById(Long userId) {

        User user=userRepository.findById(userId).orElseThrow();

        GetByIdUserResponse userResponse=this.modelMapperService.forResponse().map(user,GetByIdUserResponse.class);

        return userResponse;
    }


    public List<GetAllUserResponse> getAllUsers() {

        List<User> users=userRepository.findAll();
        List<GetAllUserResponse> userResponses=users.stream().map(user -> this.modelMapperService.forResponse()
                .map(user, GetAllUserResponse.class)).collect(Collectors.toList());

        return userResponses;

    }

    public User getOneUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


}
/*
  List<User> users=userRepository.findAll();
        List<GetUserResponse> userResponses=new ArrayList<GetUserResponse>();

        for (User user:users){
            GetUserResponse foundUser=new GetUserResponse(user);
            foundUser.setUserName(user.getUserName());

            userResponses.add(foundUser);

        }
        return userResponses;
 */