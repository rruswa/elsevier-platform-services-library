package elsevier.uk.entellect.platform.services.bitlink;

import elsevier.uk.entellect.platform.models.BitlinkModel;
import elsevier.uk.entellect.platform.models.LinkModel;
import elsevier.uk.entellect.platform.services.common.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class BitlinkAPI extends BaseAPI {

    private static RequestSpecBuilder reqSpec = new RequestSpecBuilder().setBasePath("v4/bitlinks");

    public static LinkModel create(BitlinkModel bitlink) {
         return given()
                    .spec(getBaseRequestSpecBuilder().build().spec(reqSpec.build()))
                    .contentType(ContentType.JSON)
                 .config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(bitlink)
                .when()
                    .post()
                .then()
                 .log().all()
                 .statusCode(anyOf(is(HttpStatus.SC_CREATED), is(HttpStatus.SC_OK)))
                 .extract().body().as(LinkModel.class);
    }

}
