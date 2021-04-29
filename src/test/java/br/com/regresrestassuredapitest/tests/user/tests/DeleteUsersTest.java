package br.com.regresrestassuredapitest.tests.user.tests;

import br.com.regresrestassuredapitest.tests.base.tests.BaseTest;
import br.com.regresrestassuredapitest.tests.user.requests.DeleteUsersRequest;
import br.com.regresrestassuredapitest.tests.user.requests.GetUsersRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.lessThan;

public class DeleteUsersTest extends BaseTest {
    GetUsersRequest getUsersRequest = new GetUsersRequest();
    DeleteUsersRequest deleteUsersRequest = new DeleteUsersRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Deletar um Usuario")
    public void deletarUmUser (){
        String id = getUsersRequest.allUsers().then().statusCode(200).extract().path("data[0].id").toString();

        deleteUsersRequest.deletarUmUser(id).then()
                .statusCode(204)
                .time(lessThan(5L), TimeUnit.SECONDS);
    }
}
