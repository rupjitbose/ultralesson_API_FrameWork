import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserClient;

import static io.restassured.RestAssured.given;

public class getUserTest {


    private UserClient userClient;

    @BeforeClass
    public void beforeTest(){
        userClient=new UserClient();
    }
    @Test
    public void shouldReturnAllUsers(){
        userClient.getAllUsers()
                .then().statusCode(200)
                .body("data",Matchers.hasSize(10))
                .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                .body("meta.pagination.limit",Matchers.equalTo(10))
                .log().body();
    }



}
