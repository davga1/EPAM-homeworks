package gorest_homework;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static gorest_homework.AccessToken.accessToken;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GorestV0 {
    private RequestSpecification requestSpecification;

    @BeforeAll
    public void setup() {
        RestAssured.baseURI = "https://gorest.co.in";
        requestSpecification = new RequestSpecBuilder().setBasePath("/public-api").setContentType(ContentType.JSON).build();
    }

    public Response getResponse(String path) {
        return RestAssured.given()
                .spec(requestSpecification)
                .when()
                .get(path);
    }

    @Test
    public void getUsersList() {
        Response response = getResponse("/users");
        response.then()
                .body("data", Matchers.hasSize(10))
                .log()
                .all();
    }

    @Test
    public void getUsersWithSpecializedCount() {
        RestAssured.given()
                .spec(requestSpecification)
                .queryParam("per_page", 20)
                .when()
                .get("/users")
                .then()
                .body("data", Matchers.hasSize(20))
                .log()
                .body();
    }

    @Test
    public void deleteUserAndGetAgain() {
        List<Object> users = getResponse("/users").jsonPath().getList("data");
        Random random = new Random();
        int randomInt = random.nextInt(users.size());
        Map<String, Object> user = (Map<String, Object>) users.get(randomInt);
        RestAssured.given().spec(requestSpecification).header("Authorization", accessToken) //A token that is in local device but not included in github repo
                .delete("/users/" + user.get("id")).then().log().body();
        getUsersList();
    }
}