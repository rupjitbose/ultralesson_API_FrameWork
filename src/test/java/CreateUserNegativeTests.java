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

        CreateUsersReqBody cuReqBody=CreateUsersReqBody.builder().name("Rup Ramakrishna")
                .gender("male").email("rup.ramakrishnaabcd112333.com")
                .status("active").build();
        //act
        userClient.create(cuReqBody)
                //assert
                .then()
                    .statusCode(422)
                    .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                    .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }

}
