package br.com.regresrestassuredapitest.tests.user.tests;

import br.com.regresrestassuredapitest.tests.base.tests.BaseTest;
import br.com.regresrestassuredapitest.tests.user.requests.GetUsersRequest;
import br.com.regresrestassuredapitest.utils.Utils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import java.io.File;
import java.util.concurrent.TimeUnit;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class GetUsersTest extends BaseTest {
    GetUsersRequest getUsersRequest = new GetUsersRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Listar Todos Usuarios")
    public void validarUsers() throws Exception{
        getUsersRequest.allUsers().then()
                .statusCode(200)
                .time(lessThan(5L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Listar Usuario Especifico(ID)")
    public void buscarUsersPorId() throws Exception{
        String id2 = getUsersRequest.allUsers().then().statusCode(200).extract().path("data[0].id").toString();

        getUsersRequest.listarUsersPorId(id2).then()
                .statusCode(200)
                .time(lessThan(5L), TimeUnit.SECONDS)
                .body("size()",greaterThan(0));
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Garantir o Contrato de Retorno dos Usuarios")
    public void garantirContratoListaUsers() throws Exception{
        getUsersRequest.allUsers().then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchema(
                        new File(
                                Utils.getContractsBasePath("user","users")
                        )
                        )
                );
    }

}
