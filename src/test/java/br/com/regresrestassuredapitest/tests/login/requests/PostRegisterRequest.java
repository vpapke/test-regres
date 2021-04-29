package br.com.regresrestassuredapitest.tests.login.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class PostRegisterRequest {
    @Step("Realizar Registro")
    public Response fazerRegistro(JSONObject corpo){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .when()
                .body(corpo.toString())
                .post("register");
    }
}
