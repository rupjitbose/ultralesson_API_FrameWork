package users.get;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import users.create.CreateUsersReqBody;

import static org.testng.Assert.*;

@Getter
public class GetUserResponse {
         @Setter
        private int statusCode;

        private Data data;
        private String meta;

    public void assertUser(CreateUsersReqBody cuReqBody) {
        assertEquals(data.email,cuReqBody.getEmail());
        assertEquals(data.name,cuReqBody.getName());
        assertEquals(data.gender,cuReqBody.getGender());
        assertEquals(data.status,cuReqBody.getStatus());
    }

    @Getter
    public static class Data {
        private String gender;

        private String name;

        private String id;

        private String email;

        private String status;

    }
}
