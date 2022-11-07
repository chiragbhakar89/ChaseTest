package restAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetService extends BaseService{

    public GetService() throws Exception {
    }

    public static Response get(String uri) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(baseUri + uri);
    }


}
