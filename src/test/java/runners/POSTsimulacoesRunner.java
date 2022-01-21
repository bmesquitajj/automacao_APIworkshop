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
import dto.POSTsimulacoesDTO;

import static constants.simulacoesConstants.ENDPOINT;
import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.when;
//import static org.hamcrest.Matchers.*;

@Tags({@Tag("api"), @Tag("all")})
@TestMethodOrder(OrderAnnotation.class)
@Epic("SimuTest - API")
public class POSTsimulacoesRunner extends hooks {
	
	POSTsimulacoesDTO simuDTO = new POSTsimulacoesDTO();
	simulacoesFactory simuFactory = new simulacoesFactory();
	
	@Test
	@Order(1)
	@Description("Cenário: Criando uma nova Simulação")
		public void T01novaSimulacaoTest() {
			given().
				body(simuDTO.criarNovaSimulacao("novoCadastroSucesso")).
				contentType("application/json").
			when().
				post(ENDPOINT).
			then().
				statusCode(HttpStatus.SC_CREATED).log().all();
		}
	
	@Test
	@Order(2)
	@Description("Cenário: Criando uma nova Simulação com nome vazio")
		public void T02novaSimulacaoTestNomeVazio() {
			given().
				body(simuDTO.criarNovaSimulacao("novoCadastroNomeVazio")).
				contentType("application/json").
			when().
				post(ENDPOINT).
			then().
				statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
		}
	
	@Test
	@Order(3)
	@Description("Cenário: Criando uma nova Simulação com CPF já cadastrado")
		public void T03novaSimulacaoTestCPFExistente() {
			given().
				body(simuDTO.criarNovaSimulacao("novoCadastroCPFexistente")).
				contentType("application/json").
			when().
				post(ENDPOINT).
			then().
				statusCode(HttpStatus.SC_CONFLICT).log().all();
		}
	
	@Test
	@Order(4)
	@Description("Cenário: Criando uma nova Simulação com CPF em formato diferente")
		public void T04novaSimulacaoTestFormatoCPF() {
			given().
				body(simuDTO.criarNovaSimulacao("novoCadastroCPFForamatoDiferente")).
				contentType("application/json").
			when().
				post(ENDPOINT).
			then().
				statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
		}
	
	@Test
	@Order(5)
	@Description("Cenário: Criando uma nova Simulação com e-mail invalido")
		public void T05novaSimulacaoTestEmailInvalido() {
			given().
				body(simuDTO.criarNovaSimulacao("novoCadastroEmailInvalido")).
				contentType("application/json").
			when().
				post(ENDPOINT).
			then().
				statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
		}
	
	@Test
	@Order(6)
	@Description("Cenário: Criando uma nova Simulação com valor menor")
		public void T06novaSimulacaoTestValorMenor() {
			given().
				body(simuDTO.criarNovaSimulacao("novoCadastroValorMenor")).
				contentType("application/json").
			when().
				post(ENDPOINT).
			then().
				statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
		}
	
	@Test
	@Order(7)
	@Description("Cenário: Criando uma nova Simulação com a parcela maior que 48")
		public void T07novaSimulacaoTestParcelaMaior() {
			given().
				body(simuDTO.criarNovaSimulacao("novoCadastroParcelaMaior")).
				contentType("application/json").
			when().
				post(ENDPOINT).
			then().
				statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
		}
	
	@Test
	@Order(8)
	@Description("Cenário: Criando uma nova Simulação com validação de suguro nula")
		public void T08novaSimulacaoTestSeguro() {
			given().
				body(simuDTO.criarNovaSimulacao("novoCadastroSeguroNulo")).
				contentType("application/json").
			when().
				post(ENDPOINT).
			then().
				statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
		}
}
