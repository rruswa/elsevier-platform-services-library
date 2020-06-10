package elsevier.uk.entellect.platform.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;

public class BaseAPI {
    protected static RequestSpecBuilder baseRequestSpecBuilder = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setBaseUri("https://api-ssl.bitly.com/");

    protected static ResponseSpecBuilder baseResponseSpecBuilder = new ResponseSpecBuilder()
            .log(LogDetail.ALL);
}
