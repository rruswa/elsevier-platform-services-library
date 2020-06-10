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

    protected static RequestSpecBuilder baseRequestSpecBuilder = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .addHeader("Authorization", "Bearer " + AuthAPI.token);

    protected static ResponseSpecBuilder baseResponseSpecBuilder = new ResponseSpecBuilder()
            .log(LogDetail.ALL);



}
