package com.gorest.gorest;

import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAllUserData extends TestBase {

    @Test
    public void GetAllUserData()
    {
        Response response = given()
                .when()
                .get("/public/v2/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
