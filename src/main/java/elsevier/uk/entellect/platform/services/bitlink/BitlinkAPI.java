package elsevier.uk.entellect.platform.services.bitlink;

import elsevier.uk.entellect.platform.models.BitlinkModel;
import elsevier.uk.entellect.platform.models.LinkModel;
import elsevier.uk.entellect.platform.services.common.BaseAPI;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.*;

public class BitlinkAPI extends BaseAPI {

    private static RequestSpecBuilder reqSpec = new RequestSpecBuilder().setBasePath("v4/bitlinks/");

    public static LinkModel create(BitlinkModel bitlink) {
        String redirectUrl =  given()
                    .spec(getBaseRequestSpecBuilder().build().spec(reqSpec.build()))
                .contentType(ContentType.JSON)
                .body(bitlink)
                .when()
                    .post()
                .then()
                    .statusCode(HttpStatus.SC_TEMPORARY_REDIRECT)
                .extract()
                .header("Location");

        return with()
                    .spec(getBaseRequestSpecBuilder().build().spec(reqSpec.build()))
                    .get(redirectUrl)
                .then()
                    .extract()
                    .body()
                    .as(LinkModel.class);
    }

}
