import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class test {

    @Test
    public void shouldReturnAllUsers(){
        given()
                .when().get("https://gorest.co.in/public/v1/users/")
                .then().statusCode(200)
                .body("data",Matchers.hasSize(10))
                .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                .log().body();
    }

    @Test
    public void shouldCreateAnUser(){


        String email="rup.ramakrishna@abcd1123.com";
        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer fe0efecfdf6f6006decc67345a8c2615584c9c50d85dfc977c072f108ce76e27")
                .body("{\n" +
                        "    \"name\": \"Rup Ramakrishna\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"email\": \""+email+"\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when().post("https://gorest.co.in/public/v1/users")
                .then().log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email",Matchers.equalToIgnoringCase(email));
    }

}
