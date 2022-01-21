package runners;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import dto.hooks;

import static constants.simulacoesConstants.ENDPOINTDELETE;
import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.when;
//import static org.hamcrest.Matchers.*;

@Tags({@Tag("api"), @Tag("all")})
@TestMethodOrder(OrderAnnotation.class)
@Epic("SimuTest - API")
public class DELsimulacoesRunner extends hooks {
	
	@Test
	@Order(1)
	@Description("Cenário: Deletando uma simulação")
		public void deletarSimulacaoSucesso() {
		given().
        	contentType("application/json").
        	pathParam("id", "11").
        when().
        	delete(ENDPOINTDELETE).
        then().
        	statusCode(HttpStatus.SC_OK).log().all();
		
		}
	
	@Test
	@Order(2)
	@Description("Cenário: Deletando uma simulação invalida")
		public void deletarSimulacaoInvalida() {
		given().
        	contentType("application/json").
        	pathParam("id", "25").
        when().
        	delete(ENDPOINTDELETE).
        then().
        	statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
		
		}
	
	
}
