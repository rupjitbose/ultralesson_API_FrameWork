import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import users.UserClient;
import users.create.CreateUsersReqBody;
import users.create.response.CreateUserErrorResponse;

public class CreateUserNegativeTests {

    private UserClient userClient;

    @BeforeClass
    public void beforeTest(){
        userClient=new UserClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //arrange

//        CreateUsersReqBody cuReqBody=CreateUsersReqBody.builder().name("Rup Ramakrishna")
//                .gender("male").email("rup.ramakrishnaabcd112333.com")
//                .status("active").build();
        CreateUsersReqBody cuReqBody = new CreateUsersReqBody.Builder().email("abcddasdas").build();
        //act
        CreateUserErrorResponse errorResponse=userClient.createErrorResponse(cuReqBody);

                //assert
                Assert.assertEquals(errorResponse.getStatusCode(),422);
                errorResponse.assertHasError("email","is invalid");
    }

    @Test
    public void shouldNotAllowToCreateUserWithBlankStatusAndGender(){
        //arrange

        CreateUsersReqBody cuReqBody = new CreateUsersReqBody.Builder().gender("").status("").build();
        //act
        CreateUserErrorResponse errorResponse=userClient.createErrorResponse(cuReqBody);

        //assert
        Assert.assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertHasError("status","can't be blank");
        errorResponse.assertHasError("gender","can't be blank, can be male of female");


    }

}
