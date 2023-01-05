import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserClient;
import users.create.CreateUsersReqBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

import static org.testng.Assert.*;

public class CreateUserTest {
    private UserClient userClient;

    @BeforeClass
    public void beforeTest(){
        userClient=new UserClient();
    }

    @Test
    public void shouldCreateFemaleUser(){
//arrange
        String email = UUID.randomUUID() + "@gmail.com";
        CreateUsersReqBody cuReqBody=CreateUsersReqBody.builder().name("Rani Ramakrishna")
                .gender("female").email(email)
                .status("active").build();
        //act
        CreateUserResponse createUserResponse = userClient.createUsers(cuReqBody);
        //assert
        //⌥⏎ to static import
        assertEquals(createUserResponse.getStatusCode(),201);
        assertNotNull(createUserResponse.getData().getId());
        assertEquals(createUserResponse.getData().getName(),cuReqBody.getName());
        assertEquals(createUserResponse.getData().getEmail(),cuReqBody.getEmail());
        assertEquals(createUserResponse.getData().getGender(),cuReqBody.getGender());
    }

    @Test
    public void shouldCreateMaleUser(){
//arrange

        String email = UUID.randomUUID() + "@gmail.com";
        CreateUsersReqBody cuReqBody=CreateUsersReqBody.builder().name("Rup Ramakrishna")
                .gender("male").email(email)
                .status("active").build();
        //act
        CreateUserResponse createUserResponse = userClient.createUsers(cuReqBody);
        //assert
        //⌥⏎ to static import
        assertEquals(createUserResponse.getStatusCode(),201);
        assertNotNull(createUserResponse.getData().getId());
        assertEquals(createUserResponse.getData().getName(),cuReqBody.getName());
        assertEquals(createUserResponse.getData().getEmail(),cuReqBody.getEmail());
        assertEquals(createUserResponse.getData().getGender(),cuReqBody.getGender());
    }
}
