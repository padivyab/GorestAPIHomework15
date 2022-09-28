package com.gorest.gorest;

import com.gorest.model.GorestUserDataPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostCreateNewUserData extends TestBase {

    @Test
    public void PostCreateNewUserData()
    {
        GorestUserDataPojo gorestUserDataPojo =new GorestUserDataPojo();
        gorestUserDataPojo.setName("Telani Ramakrishna");
        gorestUserDataPojo.setEmail("emailtenalii.ramakrishna@15ce.com");
        gorestUserDataPojo.setGender("male");
        gorestUserDataPojo.setStatus("active");

        Response response = given()
                .basePath("/public/v2/users")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer 65cbc4c43040ae97eb012d87fb6bb928809feb842bfeba5ea49b2969ea92ede6")
                .body(gorestUserDataPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
