package br.com.regresrestassuredapitest.tests.user.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class PostUsersRequest {

    @Step("Criar um Usuario")
    public Response criarUmUser(JSONObject corpo){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .when()
                .body(corpo.toString())
                .post("users");
    }
}
