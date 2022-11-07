package restAssured;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutService extends BaseService{

	public PutService() throws Exception {
	}

	public static Response put(String jSonBody,
							   String uri) {
			return given().contentType(ContentType.JSON).body(jSonBody)
                    .when().put(baseUri + uri);
	}

}
