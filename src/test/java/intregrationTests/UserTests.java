package intregrationTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserClient;
import users.create.CreateUsersReqBody;
import users.create.response.ResponseOfCreateUser;

import java.util.UUID;


public class UserTests {
    private UserClient userClient;

    @BeforeClass
    public void beforeTest(){
        userClient=new UserClient();
    }

    @Test
    public void shouldCreateAndGetUser(){
        //arrange
        CreateUsersReqBody cuReqBody = new CreateUsersReqBody.Builder().build();
        //act
        int id= userClient.createUsers(cuReqBody).getData().getId();
        //assert
        //⌥⏎ to static import
        userClient.getUser(id).assertUser(cuReqBody);
    }
}
