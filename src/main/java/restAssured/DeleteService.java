package restAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DeleteService extends BaseService {

    public DeleteService() throws Exception {
    }

    public static Response delete(String uri) {

        return given().contentType(ContentType.JSON)
                .when()
                .delete(baseUri+uri);
    }
}
