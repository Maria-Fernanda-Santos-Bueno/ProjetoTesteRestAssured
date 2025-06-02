package modulos.produto;

import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Teste de API rest do modulo de Produto")
public class ProdutoTest {
    private String token;

    @BeforeEach
    public void beforeEach(){
        //config dos dados da API Rest da lojinha
        baseURI = "http://165.227.93.41";
        //port = 8080;
        basePath = "/lojinha";

        //token do usuario admin
        this.token =
                given()
                        .contentType(ContentType.JSON)
                        .body(UsuarioDataFactory.criaUsuario("admin", "admin"))
                    .when()
                        .post("/v2/login")
                    .then()
                        .extract()
                            .path("data.token");
    }

    @Test
    @DisplayName("Validar que valor do produto igual a 0.00 neo e permitido")
    public void testValidarLimitesZeradoProibidoValorProdutos(){

        // Tentar inserir um produto com o valor 0.00 e validar que a mensagem de erro foi apresentada
        // e o status code retornado foi 422

            given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criaProdutoComUmComValorIgualA(0.00))
            .when()
                .post("/v2/produtos")
            .then()
                .assertThat()
                        .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                        .statusCode(422);

    }

    @Test
    @DisplayName("Validar que valor do produto igual a 7000.00 nao e permitido")
    public void testValidarLimitesMaiorSeteMilProibidoValorProdutos(){

        // Tentar inserir um produto com o valor 7000.01 e validar que a mensagem de erro foi apresentada
        // e o status code retornado foi

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criaProdutoComUmComValorIgualA(7000.01))
        .when()
            .post("/v2/produtos")
        .then()
            .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);

    }
}
