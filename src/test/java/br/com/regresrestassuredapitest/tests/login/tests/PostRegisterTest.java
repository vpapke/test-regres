package br.com.regresrestassuredapitest.tests.login.tests;

import br.com.regresrestassuredapitest.tests.base.tests.BaseTest;
import br.com.regresrestassuredapitest.tests.login.requests.PostRegisterRequest;
import br.com.regresrestassuredapitest.tests.user.requests.PostUsersRequest;
import br.com.regresrestassuredapitest.utils.Utils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class PostRegisterTest extends BaseTest {
    PostRegisterRequest postRegisterRequest = new PostRegisterRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Criar Cegistro Valido")
    public void criarUmRegistroValido (){
        postRegisterRequest.fazerRegistro(Utils.validCorpoLogin()).then()
                .statusCode(200)
                .time(lessThan(5L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Criar Cegistro Inalido")
    public void criarUmRegistroInvalido(){
        postRegisterRequest.fazerRegistro(Utils.invalidCorpoLogin()).then()
                .statusCode(400)
                .time(lessThan(5L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

}
