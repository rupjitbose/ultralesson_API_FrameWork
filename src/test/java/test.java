import io.restassured.http.ContentType;
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

    @Test
    public void shouldCreateAnUser(){

        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer fe0efecfdf6f6006decc67345a8c2615584c9c50d85dfc977c072f108ce76e27")
                .body("{\n" +
                        "    \"name\": \"Rup Ramakrishna\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"email\": \"rup.ramakrishna@abcd.com\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when().post("https://gorest.co.in/public/v2/users")
                .then().log().body()
                .statusCode(201);
    }

}
