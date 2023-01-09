import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserClient;
import users.UsersService;
import users.create.response.GetAllUserResponse;
import static org.testng.Assert.*;

public class getUserTest {
    private UsersService usersService;

    @BeforeClass
    public void beforeTest(){
        usersService=new UsersService();
    }
    @Test
    public void shouldReturnAllUsers(){

        //act
        GetAllUserResponse allUsers = usersService.getAllUsers();

        //assert
        assertEquals(allUsers.getStatusCode(),200);
        assertEquals(allUsers.getDataList().size(),10);
        assertTrue(allUsers.getDataList().stream().filter(data -> data.getGender().equals("male")).findAny().isPresent());
        assertEquals(allUsers.getMeta().getPagination().getLimit(),10);


    }



}
