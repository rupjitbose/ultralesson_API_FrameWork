import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UserClient;

import static io.restassured.RestAssured.given;

public class CreateUserTest {


    @Test
    public void shouldCreateFemaleUser(){
//arrange
        String body = "{\n" +
                "    \"name\": \"Rani Ramakrishna\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"rup.ramakrishna@abcd112367.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //act
        new UserClient().createUsers(body)
                .then().log().body()
                //assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name",Matchers.equalToIgnoringCase("Rani Ramakrishna"))
                .body("data.gender",Matchers.equalToIgnoringCase("female"))
                .body("data.email",Matchers.equalToIgnoringCase("rup.ramakrishna@abcd112367.com"));
    }

    @Test
    public void shouldCreateMaleUser(){
//arrange
        String body = "{\n" +
                "    \"name\": \"Rup Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"rup.ramakrishna@abcd112333.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //act
        new UserClient().createUsers(body)
                .then().log().body()

                //assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name",Matchers.equalToIgnoringCase("Rup Ramakrishna"))
                .body("data.gender",Matchers.equalToIgnoringCase("male"))
                .body("data.email",Matchers.equalToIgnoringCase("rup.ramakrishna@abcd1123.com"));
    }
}
