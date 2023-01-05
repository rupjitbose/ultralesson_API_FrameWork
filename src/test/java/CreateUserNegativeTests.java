import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import users.UserClient;
import users.create.CreateUsersReqBody;

public class CreateUserNegativeTests {

    private UserClient userClient;

    @BeforeClass
    public void beforeTest(){
        userClient=new UserClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //arrange
        String name = "Rup Ramakrishna";
        String gender = "male";
        String email = "rup.ramakrishnaabcd112333.com";
        String status = "active";

        CreateUsersReqBody cuReqBody= new CreateUsersReqBody(name,gender,email,status);
        //act
        userClient.createUsers(cuReqBody)
                .then().log().body()

                //assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }

}
