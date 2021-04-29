package br.com.regresrestassuredapitest.tests.user.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class PutUsersRequest {
    @Step("Update de Usuario")
    public Response editarUmUser(JSONObject corpo,String cod){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .when()
                .body(corpo.toString())
                .put("users/" + cod);
    }
}
