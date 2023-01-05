package users.create.response;

import lombok.Getter;
import lombok.Setter;
import users.create.CreateUsersReqBody;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Getter
public class CreateUserResponse {

    @Setter
    private int statusCode;
    private String meta;
    private Data data;

    public void assertUserInfo(CreateUsersReqBody cuReqBody) {
        assertEquals(this.getStatusCode(),201);
        assertNotNull(this.getData().getId());
        assertEquals(this.getData().getName(),cuReqBody.getName());
        assertEquals(this.getData().getEmail(),cuReqBody.getEmail());
        assertEquals(this.getData().getGender(),cuReqBody.getGender());
    }
}
