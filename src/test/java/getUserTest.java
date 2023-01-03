import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getUserTest {

    @Test
    public void shouldReturnAllUsers(){
        given()
                .when().get("https://gorest.co.in/public/v1/users/")
                .then().statusCode(200)
                .body("data",Matchers.hasSize(10))
                .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                .body("meta.pagination.limit",Matchers.equalTo(10))
                .log().body();
    }

}
