package src.main.java.com.example.demo.designquestions.paymentgateway;

public class UserController {
    UserService userService;

    public UserController(){userService=new UserService();}

    public UserDO addUser(UserDO userDO){return userService.addUser(userDO);}

    public UserDO getUser(int userId) {return userService.getUser(userId);}
}
