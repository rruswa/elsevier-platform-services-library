package elsevier.uk.entellect.platform.services.group;

import elsevier.uk.entellect.platform.models.GroupsModel;
import elsevier.uk.entellect.platform.services.common.BaseAPI;
import io.restassured.builder.RequestSpecBuilder;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;


public class GroupAPI extends BaseAPI {

    private static RequestSpecBuilder reqSpec = new RequestSpecBuilder().setBasePath("v4/groups/");

    public static GroupsModel groups() {
        return given()
                    .spec(baseRequestSpecBuilder.build().spec(reqSpec.build()))
                .when()
                    .get()
                .then()
                    .spec(baseResponseSpecBuilder.build())
                    .statusCode(HttpStatus.SC_OK)
                .extract()
                    .body()
                    .as(GroupsModel.class);
    }

}
