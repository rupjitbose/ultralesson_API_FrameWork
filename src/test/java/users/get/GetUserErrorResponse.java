package users.get;

import lombok.Getter;
import lombok.Setter;
import users.create.CreateUsersReqBody;

import static org.testng.Assert.assertEquals;

@Getter
public class GetUserErrorResponse {
         @Setter
        private int statusCode;
        private Data data;
        private String meta;

    public void assertError(int expectedStatusCode, String msg) {
        assertEquals(data.message,msg);
        assertEquals(statusCode,expectedStatusCode);
    }



    @Getter
    public static class Data {
        private String message;
    }
}
