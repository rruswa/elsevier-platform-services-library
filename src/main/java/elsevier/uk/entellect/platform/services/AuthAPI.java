package elsevier.uk.entellect.platform.services;

import elsevier.uk.entellect.platform.utils.PropUtils;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

public class AuthAPI extends BaseAPI {

    public static String token;

    static {
        // TODO: Evaluate if this should not be statically done as each JVM instance using this library will result
        // in this token being retrieved, depending on test environment set up this could be implemented differently to
        // only be called once for multiple JVM being run concurrently
        String username = PropUtils.get("elsevier.bitly.username").orElseThrow(IllegalStateException::new);
        String password = PropUtils.get("elsevier.bitly.password").orElseThrow(IllegalStateException::new);

        token = AuthAPI.bearerToken(username, password);
    }

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
