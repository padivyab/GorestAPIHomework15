package com.gorest.gorest;

import com.gorest.model.GorestUserDataPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GorestUserDataCRUDData extends TestBase {

    @Test
    public void GetAllUserData()
    {
        Response response = given()
                .when()
                .get("/public/v2/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void PostCreateNewUserData()
    {
        GorestUserDataPojo gorestUserDataPojo =new GorestUserDataPojo();
        gorestUserDataPojo.setName("Telanii Ramakrishna");
        gorestUserDataPojo.setEmail("emailtenaliif.ramakrishna@15ce.com");
        gorestUserDataPojo.setGender("Female");
        gorestUserDataPojo.setStatus("Inactive");

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

    @Test
    public void PatchUpdateData()
    {
        GorestUserDataPojo gorestUserDataPojo =new GorestUserDataPojo();
        gorestUserDataPojo.setName("Telaniii Ramakrishna");
        gorestUserDataPojo.setEmail("emailtenaliiid.ramakrishna@15ce.com");
        gorestUserDataPojo.setGender("male");
        gorestUserDataPojo.setStatus("active");

        Response response = given()
                .basePath("/public/v2/users")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer 65cbc4c43040ae97eb012d87fb6bb928809feb842bfeba5ea49b2969ea92ede6")
                .pathParam("id","3735")
                .body(gorestUserDataPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void deleteUserData() {
        Response response = given()
                .basePath("/public/v2/users")
                .pathParam("id","3735")
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();

    }
}
