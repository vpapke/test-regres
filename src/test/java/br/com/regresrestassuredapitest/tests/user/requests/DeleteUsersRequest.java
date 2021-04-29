package br.com.regresrestassuredapitest.tests.user.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class DeleteUsersRequest {

    @Step("Delete de Usuario")
    public Response deletarUmUser( String cod){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .when()
                .delete("users/" + cod);
    }
}
