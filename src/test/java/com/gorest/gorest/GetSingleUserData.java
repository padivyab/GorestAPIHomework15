package com.gorest.gorest;

import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetSingleUserData extends TestBase {

    @Test
    public void GetAllSingleData() {

        //RestAssured.basePath=("/products");
        Response response = given()
                .basePath("/public/v2/users")
                .pathParam("id","2299") //9999712  185267
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}

