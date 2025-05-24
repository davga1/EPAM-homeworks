package gorest_homework2;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static gorest_homework2.AccessToken.accessToken;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GoRestV2 {

    private RequestSpecification requestSpecification;
    private String title;
    private String body;
    Map<String, Object> postBody = new HashMap<>();


    @BeforeAll
    public void setup() {
        RestAssured.baseURI = "https://gorest.co.in";
        requestSpecification = new RequestSpecBuilder().setBasePath("/public/v2").setContentType(ContentType.JSON).build();
    }

    public List<Post> getPosts() {
        return RestAssured.given(requestSpecification).get("/posts").then().statusCode(200).extract().body().jsonPath().getList("", Post.class);
    }

    public List<User> getUsers() {
        return RestAssured.given(requestSpecification).get("/users").then().statusCode(200).extract().body().jsonPath().getList("", User.class);
    }

    public List<Post> getPosts(int userId) {
        return RestAssured.given(requestSpecification).header("Authorization", accessToken).get("/users/" + userId + "/posts").then().statusCode(200).extract().body().jsonPath().getList("", Post.class);
    }

    public void makePost(int user_id, String newTitle, String newPost) {
        postBody.put("title", newTitle);
        postBody.put("body", newPost);
        title = newTitle;
        body = newPost;
        RestAssured.given(requestSpecification).header("Authorization", accessToken).body(postBody).post("/users/" + user_id + "/posts").then().statusCode(201).log().all();
    }

    public void changeStatusToActive(int userId) {
        Map<String, String> body = new HashMap<>();
        body.put("status", "active");

        RestAssured.given(requestSpecification)
                .header("Authorization", accessToken)
                .contentType("application/json")
                .body(body)
                .put("/users/" + userId)
                .then()
                .log().all();
    }

    //GET եք անում բոլոր post-երը համապատասխան API-ով, կատարում եք դեսերիալիզացիա, ու պահում համապատասխան list-ի մեջ։
    //Հետո դրանցից վերցնում եք պատահական մեկի user_id-ն, ու տվյալ user-ի համար ստեղծում եք նոր գրառում (post)։
    //Հետո համապատասխան GET api-ն օգտագործելով համոզվում եք, որ տվյալ յուզերի համար իրոք էդ պոստը ստեղծվելա։
    //Էս սաղ մի թեստի մեջ պետքա լինի
    @Tag("api")
    @Test
    public void addNewPost() {
        List<Post> posts = getPosts();
        Random random = new Random();
        int userId = posts.get(random.nextInt(posts.size())).getUser_id();
        makePost(userId, "TITLE888", "BODY888");
        List<Post> userPosts = getPosts(userId);
        boolean postFound = userPosts.stream().anyMatch(post -> title.equals(post.getTitle()) && body.equals(post.getBody()));
        Assertions.assertTrue(postFound, "New post not found in user's posts.");
    }

    //GET եք անում նորից բոլոր user-ներին, վերցնում առաջին user-ի id-ն, որի status-ը inactive-ա։
    //PUT ռեքվեսթով ափդեյթ եք անում տվյալ յուզերին ու փոխում եք inactive-ը active-ի։
    //Հետո հենց էդ յուզերին GET եք անում ու համոզվում, որ իրոք ափդեյթա էղել ստատուսը։

    @Tag("api")
    @Test
    public void getUsersAndChangeStatus() {
        List<User> users = getUsers();
        User firstInactiveUser = users.stream().filter(user -> "inactive".equals(user.getStatus())).findFirst().get();
        System.out.println("First inactive user:\n" + firstInactiveUser);
        changeStatusToActive(firstInactiveUser.getId());
    }

    //էս մեկում ձեր քոլը պետքա լինի լրիվ այլ API-ի։
    //https://api.restful-api.dev/objects ։ Գրում եք համապատասխան class-ները ու էս API-ի ռեսփոնսը deserialize անում։
    //Ուշադրություն դարձրեք data-ի մեջի կոնտենտին տարբեր item-ների համար մինչև համապատասխան dto-ն գրելը, որովհետև property-ներ կան,
    //որոնք ոչ բոլորի data օբջեքթներում կան։ Պետքա ուսումնասիրեք, թե Jackson-ը ոնցա վերաբերում էն փռոփերթիներին deserialize անելուց, որոնք կարան չլինեն ռեսփոնսի մեջ, բայց կան dto-ում սահմանված, ու ոնցա դրանք deserialize անում


    @Tag("api")
    @Test
    public void getDevices() {
        List<Device> devices = RestAssured.given().baseUri("https://api.restful-api.dev").get("/objects").jsonPath().getList("");
        System.out.println(devices);
    }
}
