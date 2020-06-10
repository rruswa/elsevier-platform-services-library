package elsevier.uk.entellect.platform.services;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

public class AuthAPI extends BaseAPI {

    public static String bearerToken(String username, String password) {
        return RestAssured.given()
                .spec(baseRequestSpecBuilder.build())
                .header("grant_type", "password")
                .auth()
                    .preemptive()
                    .basic(username, password)
                .when()
                    .post("/oauth/access_token")
                .then()
                    .spec(baseResponseSpecBuilder.build())
                    .statusCode(HttpStatus.SC_OK)
                .and().extract().body().asString();
    }

}
