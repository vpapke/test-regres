package br.com.regresrestassuredapitest.tests.user.tests;

import br.com.regresrestassuredapitest.tests.base.tests.BaseTest;
import br.com.regresrestassuredapitest.tests.user.requests.PostUsersRequest;
import br.com.regresrestassuredapitest.utils.Utils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class PostUsersTest extends BaseTest {
    PostUsersRequest postUsersRequest = new PostUsersRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Criar um Usuario")
    public void criarUmaReserva (){
        postUsersRequest.criarUmUser(Utils.validCorpoUser()).then()
                .statusCode(201)
                .time(lessThan(5L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

}
