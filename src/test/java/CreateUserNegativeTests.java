import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UserClient;

public class CreateUserNegativeTests {

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
        new UserClient().createUsers(body)
                .then().log().body()

                //assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }

}
