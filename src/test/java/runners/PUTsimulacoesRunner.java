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

import dataFactory.simulacoesFactory;
import dto.hooks;
import dto.GETrestricoesDTO;
import dto.PUTsimulacoesDTO;

import static constants.simulacoesConstants.ENDPOINTALTERAR;
import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.when;
//import static org.hamcrest.Matchers.*;

@Tags({@Tag("api"), @Tag("all")})
@TestMethodOrder(OrderAnnotation.class)
@Epic("SimuTest - API")
public class PUTsimulacoesRunner extends hooks {
	
	GETrestricoesDTO restDTO = new GETrestricoesDTO();
	PUTsimulacoesDTO simuDTO = new PUTsimulacoesDTO();
	simulacoesFactory simuFactory = new simulacoesFactory();
	
	
	@Test
	@Order(1)
	@Description("Cenário: Alterando uma simulação")
		public void alterarSimulacaoSucesso() {
		given().
        	contentType("application/json").
        	pathParam("cpf", restDTO.novaPesquisaRestricao("alteracaoSucesso")).
        	body(simuDTO.alterarSimulacao("alteracaoSucesso")).
        when().
        	put(ENDPOINTALTERAR).
        then().
        	statusCode(HttpStatus.SC_OK).log().all();
		
		}
	
	
	@Test
	@Order(2)
	@Description("Cenário: Alterando uma simulação com nome vazio")
		public void alterarSimulacaoNomeVazio() {
		given().
        	contentType("application/json").
        	pathParam("cpf", restDTO.novaPesquisaRestricao("alteracaoSucesso")).
        	body(simuDTO.alterarSimulacao("alteracaoNomeVazio")).
        when().
        	put(ENDPOINTALTERAR).
        then().
        	statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
		
		}
	
	
	@Test
	@Order(3)
	@Description("Cenário: Alterando uma simulação com CPF existente")
		public void alterarSimulacaoCPFExistente() {
		given().
        	contentType("application/json").
        	pathParam("cpf", restDTO.novaPesquisaRestricao("alteracaoSucesso")).
        	body(simuDTO.alterarSimulacao("alteracaoCPFexistente")).
        when().
        	put(ENDPOINTALTERAR).
        then().
        	statusCode(HttpStatus.SC_CONFLICT).log().all();
		
		}
	
	
	@Test
	@Order(4)
	@Description("Cenário: Alterando uma simulação com CPF em formato invalido")
		public void alterarSimulacaoCPFFormato() {
		given().
        	contentType("application/json").
        	pathParam("cpf", restDTO.novaPesquisaRestricao("alteracaoSucesso")).
        	body(simuDTO.alterarSimulacao("alteracaoCPFForamatoDiferente")).
        when().
        	put(ENDPOINTALTERAR).
        then().
        	statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
		
		}
	
	
	@Test
	@Order(5)
	@Description("Cenário: Alterando uma simulação com e-mail invalido")
		public void alterarSimulacaoEmailInvalido() {
		given().
        	contentType("application/json").
        	pathParam("cpf", restDTO.novaPesquisaRestricao("alteracaoSucesso")).
        	body(simuDTO.alterarSimulacao("alteracaoEmailInvalido")).
        when().
        	put(ENDPOINTALTERAR).
        then().
        	statusCode(HttpStatus.SC_NOT_FOUND).log().all();
		
		}
}
