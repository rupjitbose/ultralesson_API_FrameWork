import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import users.UserClient;

public class CreateUserNegativeTests {

    private UserClient userClient;

    @BeforeClass
    public void beforeTest(){
        userClient=new UserClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //arrange
        String body = "{\n" +
                "    \"name\": \"Rup Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"rup.ramakrishnaabcd112333.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //act
        userClient.createUsers(body)
                .then().log().body()

                //assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }

}
