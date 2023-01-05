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
        String email = UUID.randomUUID()+"@gmail.com";
        String name = "Rani Ramakrishna";
        String gender = "female";
        String status = "active";

       CreateUsersReqBody cuReqBody= new CreateUsersReqBody(name,gender,email,status);
        //act
        userClient.createUsers(cuReqBody)
                .then().log().body()
                //assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name",Matchers.equalToIgnoringCase(name))
                .body("data.gender",Matchers.equalToIgnoringCase(gender))
                .body("data.email",Matchers.equalToIgnoringCase(email));
    }

    @Test
    public void shouldCreateMaleUser(){
//arrange
        String email = UUID.randomUUID()+"@gmail.com";
        String name = "Rup Ramakrishna";
        String gender = "male";
        String status = "active";

        CreateUsersReqBody cuReqBody= new CreateUsersReqBody(name,gender,email,status);
        //act
        userClient.createUsers(cuReqBody)
                .then().log().body()

                //assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name",Matchers.equalToIgnoringCase(name))
                .body("data.gender",Matchers.equalToIgnoringCase(gender))
                .body("data.email",Matchers.equalToIgnoringCase(email));
    }
}
