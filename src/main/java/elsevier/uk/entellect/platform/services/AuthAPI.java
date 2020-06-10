package elsevier.uk.entellect.platform.services;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

public class AuthAPI extends BaseAPI {

    public static String bearerToken(String username, String password) {
        // Logging of the response was removed as it exposed the bearer token being returned by this API call.
        return RestAssured.given()
                .spec(baseRequestSpecBuilder.build())
                .header("grant_type", "password")
                .auth()
                    .preemptive()
                    .basic(username, password)
                .when()
                    .post("/oauth/access_token")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                .and().extract().body().asString();
    }

}
