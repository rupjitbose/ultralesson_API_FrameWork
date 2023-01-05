import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserClient;
import users.create.response.GetAllUserResponse;
import static org.testng.Assert.*;

public class getUserTest {
    private UserClient userClient;

    @BeforeClass
    public void beforeTest(){
        userClient=new UserClient();
    }
    @Test
    public void shouldReturnAllUsers(){

        //act
        GetAllUserResponse allUsers = userClient.getAllUsers();

        //assert
        assertEquals(allUsers.getStatusCode(),200);
        assertEquals(allUsers.getDataList().size(),10);
        assertTrue(allUsers.getDataList().stream().filter(data -> data.getGender().equals("male")).findAny().isPresent());
        assertEquals(allUsers.getMeta().getPagination().getLimit(),10);


    }



}
