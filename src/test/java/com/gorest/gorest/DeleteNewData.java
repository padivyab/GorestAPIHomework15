package com.gorest.gorest;

import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteNewData extends TestBase {

    @Test
    public void deleteUserData() {
        Response response = given()
                .basePath("/public/v2/users")
                .pathParam("id","3694")
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();

    }
}
