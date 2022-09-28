package com.gorest.assertion;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class Assertion {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt()
    {
        RestAssured.baseURI="https://gorest.co.in/";
        response = given()
                .when()
                .get("/public/v2/users")
                .then().statusCode(200);
    }
    //1.Total records are 10
    @Test
    public void TotalRecord()
    {
        ArrayList<Integer> DataSize = response.extract().path("data");
        int size =DataSize.size();
        System.out.println("TotalRecord :"+size);

    }
    //2.id 2276 has name = "Girija Singh VM" or "Gurdev Ganaka IV"
    @Test
    public void Name()
    {
        response.body("[7].name",equalTo("Girija Singh VM"));
    }
    //3.id 2274 has email = "iyengar_brijesh@weber.info"
    @Test
    public void Email()
    {
        response.body("[9].email",equalTo("mehra_sunita@kuphal.info"));
    }
    //4.All ID has status = "active"
    @Test
    public void Status()
    {
        List<String> status = response.extract().path("data.status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The status active is : "+status);
        System.out.println("------------------End of Test---------------------------");

    }
    //5.id 2472 has gender = "female"
    @Test
    public void Gender()
    {
        response.body("[6].gender",equalTo("male"));
    }
    //6.id 2471 has gender = "male"
    @Test
    public void Gender1()
    {
        response.body("[4].gender",equalTo("female"));
    }
}
