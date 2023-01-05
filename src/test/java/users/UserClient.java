package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUsersReqBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;
import static io.restassured.RestAssured.given;

public class UserClient {

    public CreateUserResponse createUsers(CreateUsersReqBody body) {
        Response response=create(body);
        CreateUserResponse createUserResponse=response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.getStatusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponse createErrorResponse(CreateUsersReqBody body){
        Response response=create(body);
        CreateUserErrorResponse createUserErrorResponse=response.as(CreateUserErrorResponse.class);
        createUserErrorResponse.setStatusCode(response.getStatusCode());
        return createUserErrorResponse;
    }

    public Response create(CreateUsersReqBody body) {
        Response response =
                given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer fe0efecfdf6f6006decc67345a8c2615584c9c50d85dfc977c072f108ce76e27")
                    .body(body)
                .when()
                    .post("https://gorest.co.in/public/v1/users");

        response.then().log().body();
        return response;
    }



    public Response getAllUsers() {
        return
                given()
                .when()
                    .get("https://gorest.co.in/public/v1/users/");
    }
}
