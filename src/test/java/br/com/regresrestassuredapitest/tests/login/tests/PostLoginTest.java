package br.com.regresrestassuredapitest.tests.login.tests;

import br.com.regresrestassuredapitest.tests.base.tests.BaseTest;
import br.com.regresrestassuredapitest.tests.login.requests.PostLoginRequest;
import br.com.regresrestassuredapitest.utils.Utils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class PostLoginTest extends BaseTest {
    PostLoginRequest postLoginRequest = new PostLoginRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Fazer Login Valido")
    public void fazerLoginValido (){
        postLoginRequest.fazerLogin(Utils.validCorpoLogin()).then()
                .statusCode(200)
                .time(lessThan(5L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Fazer Login Invalido")
    public void fazerLoginInvalido (){
        postLoginRequest.fazerLogin(Utils.invalidCorpoLogin()).then()
                .statusCode(400)
                .time(lessThan(5L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }
}
