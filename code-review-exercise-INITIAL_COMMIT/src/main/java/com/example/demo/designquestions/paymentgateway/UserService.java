package src.main.java.com.example.demo.designquestions.paymentgateway;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    static List<User> userList = new ArrayList<>();

    public UserDO addUser(UserDO userDO) {
        User user1 = new User();
        user1.setEmail(userDO.getEmail());
        user1.setUsername(userDO.getName());
        user1.setUserId((int) Math.random() + 1);
        userList.add(user1);
        return convertUserToUserDO(user1);
    }

    private UserDO convertUserToUserDO(User user1) {
        UserDO userDO=new UserDO();
        userDO.setName(user1.getUsername());
        userDO.setEmail(user1.getEmail());
        userDO.setUserid(user1.getUserId());
        return  userDO;
    }

    public UserDO getUser(int userId){
        for(User user: userList){
            if(user.getUserId()==userId){
                return convertUserToUserDO(user);
            }
        }
        return null;
    }

}