import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserClient;
import users.create.CreateUsersReqBody;

import java.util.UUID;

import static io.restassured.RestAssured.given;

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
        userClient.createUsers(cuReqBody)
                .then().log().body()
                //assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name",Matchers.equalToIgnoringCase("Rani Ramakrishna"))
                .body("data.gender",Matchers.equalToIgnoringCase("female"))
                .body("data.email",Matchers.equalToIgnoringCase(email));
    }

    @Test
    public void shouldCreateMaleUser(){
//arrange

        String email = UUID.randomUUID() + "@gmail.com";
        CreateUsersReqBody cuReqBody=CreateUsersReqBody.builder().name("Rup Ramakrishna")
                .gender("male").email(email)
                .status("active").build();
        //act
        userClient.createUsers(cuReqBody)
                .then().log().body()

                //assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name",Matchers.equalToIgnoringCase("Rup Ramakrishna"))
                .body("data.gender",Matchers.equalToIgnoringCase("male"))
                .body("data.email",Matchers.equalToIgnoringCase(email));
    }
}
