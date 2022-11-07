package restAssured;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostService extends BaseService{

    public PostService() throws Exception {
    }

    public static Response post(String uri, String jsonBody) {

        return given().contentType(ContentType.JSON)
                .body(jsonBody).when()
                .post(baseUri + uri);
    }

}
