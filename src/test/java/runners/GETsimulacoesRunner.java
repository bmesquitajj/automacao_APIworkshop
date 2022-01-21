package runners;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import dataFactory.simulacoesFactory;
import dto.hooks;
import dto.GETrestricoesDTO;

import static constants.simulacoesConstants.ENDPOINT;
import static constants.simulacoesConstants.ENDPOINTALTERAR;
import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.when;
//import static org.hamcrest.Matchers.*;

@Tags({@Tag("api"), @Tag("all")})
@TestMethodOrder(OrderAnnotation.class)
@Epic("SimuTest - API")
public class GETsimulacoesRunner extends hooks {
	
//	GETsimulacoesDTO simuDTO = new GETsimulacoesDTO();
	GETrestricoesDTO restDTO = new GETrestricoesDTO();
	simulacoesFactory simuFactory = new simulacoesFactory();

	@Test
	@Order(1)
	@Description("Cenário: Pesquisando CPF na simulação")
		public void pesquisaSimulacaoCPF() {
		given().
        	contentType("application/json").
        	pathParam("cpf", restDTO.novaPesquisaRestricao("pesquisaSimulacao")).
        when().
        	get(ENDPOINTALTERAR).
        then().
        	statusCode(HttpStatus.SC_OK).log().all();
		
		}
	
//	@Test
//	@Order(2)
//	@Description("Cenário: Pesquisando CPF invalido na simulação")
//		public void pesquisaSimulacaoCPFinvalido() {
//		given().
//        	contentType("application/json").
//        	pathParam("cpf", restDTO.novaPesquisaRestricao("CPF-invalido")).
//        when().
//        	get(ENDPOINTALTERAR).
//        then().
//        	statusCode(HttpStatus.SC_NOT_FOUND).log().all();
//		
//		}
//	
//	@Test
//	@Order(3)
//	@Description("Cenário: Pesquisando usuarios na simulação")
//		public void pesquisaSimulacaoAll() {
//		given().
//        	contentType("application/json").
//        when().
//        	get(ENDPOINT).
//        then().
//        	statusCode(HttpStatus.SC_OK).log().all();
//		
//		}
}
