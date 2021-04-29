package br.com.regresrestassuredapitest.tests.login.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class PostLoginRequest {
    @Step("Realizar Login")
    public Response fazerLogin(JSONObject corpo){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .when()
                .body(corpo.toString())
                .post("login");
    }
}
