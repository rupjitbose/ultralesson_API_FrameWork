import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class test {

    @Test
    public void shouldReturnAllUsers(){
        given()
                .when().get("https://gorest.co.in/public/v1/users/")
                .then().statusCode(200)
                .log().body();
    }

}
