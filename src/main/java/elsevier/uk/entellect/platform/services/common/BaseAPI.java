package elsevier.uk.entellect.platform.services.common;

import elsevier.uk.entellect.platform.services.auth.AuthAPI;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;

public class BaseAPI {
    static {
        RestAssured.baseURI = "https://api-ssl.bitly.com/";
    }

    public static RequestSpecBuilder getBaseRequestSpecBuilder() {
        return new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .addHeader("Authorization", "Bearer " + AuthAPI.token);
    }

    public static ResponseSpecBuilder getBaseResponseSpecBuilder() {
        return new ResponseSpecBuilder().log(LogDetail.ALL);
    }
}
