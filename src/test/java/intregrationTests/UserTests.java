package intregrationTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserClient;
import users.UsersService;
import users.create.CreateUsersReqBody;
import users.create.response.ResponseOfCreateUser;

import java.util.UUID;


public class UserTests {
    private UsersService usersService;

    @BeforeClass
    public void beforeTest(){
        usersService=new UsersService();
    }

    @Test
    public void shouldCreateAndGetUser(){
        //arrange
        CreateUsersReqBody cuReqBody = new CreateUsersReqBody.Builder().build();
        //act
        int id= usersService.createUsers(cuReqBody).getData().getId();
        //assert
        //⌥⏎ to static import
        usersService.getUser(id).assertUser(cuReqBody);
    }
}
