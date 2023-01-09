package users;

import io.restassured.response.Response;
import users.create.CreateUsersReqBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.GetAllUserResponse;
import users.create.response.ResponseOfCreateUser;
import users.get.GetUserResponse;

public class UsersService {

    public ResponseOfCreateUser createUsers(CreateUsersReqBody body) {
        Response response=new UserClient().create(body);
        ResponseOfCreateUser createUserResponse=response.as(ResponseOfCreateUser.class);
        createUserResponse.setStatusCode(response.getStatusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponse createErrorResponse(CreateUsersReqBody body){
        Response response=new UserClient().create(body);
        CreateUserErrorResponse createUserErrorResponse=response.as(CreateUserErrorResponse.class);
        createUserErrorResponse.setStatusCode(response.getStatusCode());
        return createUserErrorResponse;
    }

    public GetAllUserResponse getAllUsers() {
        Response response = new UserClient().getAll();
        int statusCode=response.getStatusCode();

        GetAllUserResponse getAllUserResponse=response.as(GetAllUserResponse.class);
        getAllUserResponse.setStatusCode(statusCode);
        return getAllUserResponse;
    }

    public GetUserResponse getUser(int id){
        Response response = new UserClient().get(id);

        int statusCode=response.statusCode();

        GetUserResponse  getUserResponse=response.as(GetUserResponse.class);
        getUserResponse.setStatusCode(statusCode);
        return getUserResponse;
    }


}
