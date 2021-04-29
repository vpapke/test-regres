package br.com.regresrestassuredapitest.tests.user.tests;

import br.com.regresrestassuredapitest.tests.base.tests.BaseTest;
import br.com.regresrestassuredapitest.tests.user.requests.GetUsersRequest;
import br.com.regresrestassuredapitest.tests.user.requests.PutUsersRequest;
import br.com.regresrestassuredapitest.utils.Utils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class PutUsersTest extends BaseTest {
    PutUsersRequest putUsersRequest = new PutUsersRequest();
    GetUsersRequest getUsersRequest = new GetUsersRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Editar um Usuario")
    public void editarUmUser (){
        String id = getUsersRequest.allUsers().then().statusCode(200).extract().path("data[0].id").toString();

        putUsersRequest.editarUmUser(Utils.validCorpoUser(),id).then()
                .statusCode(200)
                .time(lessThan(5L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }


}
