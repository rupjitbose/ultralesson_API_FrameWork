import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserClient;
import users.create.CreateUsersReqBody;
import users.create.response.ResponseOfCreateUser;
import java.util.UUID;



public class CreateUserTest {
    private UserClient userClient;

    @BeforeClass
    public void beforeTest(){
        userClient=new UserClient();
    }

    @Test
    public void shouldCreateFemaleUser(){

//        String email = UUID.randomUUID() + "@gmail.com";
//        CreateUsersReqBody cuReqBody=CreateUsersReqBody.builder()
//                .name("Rani Ramakrishna")
//                .gender("female")
//                .email(email)
//                .status("active").build();
        //arrange
        CreateUsersReqBody cuReqBody = new CreateUsersReqBody.Builder().gender("female").build();
        //act
        ResponseOfCreateUser createUserResponse = userClient.createUsers(cuReqBody);
        //assert
        createUserResponse.assertUserInfo(cuReqBody);
    }

    @Test
    public void shouldCreateMaleUser(){
        //arrange
        CreateUsersReqBody cuReqBody = new CreateUsersReqBody.Builder().gender("male").build();
        //act
        ResponseOfCreateUser createUserResponse = userClient.createUsers(cuReqBody);
        //assert
        createUserResponse.assertUserInfo(cuReqBody);
    }
}
