package br.com.regresrestassuredapitest.tests.user.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetUsersRequest {
    @Step("Buscar todos Usuarios.")
    public  Response allUsers(){
        return given()
                .header("Content-Type","application/json")
                .when()
                .get("users");
    }

    @Step("Buscar usuario especifica(ID).")
    public  Response listarUsersPorId(String id){
        return given()
                .header("Content-Type","application/json")
                .when()
                .get("users/"+id);
    }

}
