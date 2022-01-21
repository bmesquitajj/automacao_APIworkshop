package runners;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import dataFactory.restricoesFactory;
import dto.GETrestricoesDTO;
import dto.hooks;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static constants.restricoesConstants.*;
import static org.hamcrest.Matchers.*;

@Tags({@Tag("api"), @Tag("all")})
@Epic("RestricoesTest - API")
public class GETrestricoesRunner extends hooks {
	
	GETrestricoesDTO restDTO = new GETrestricoesDTO();
	restricoesFactory restFactory = new restricoesFactory();
	
	@Test
	@Description("Cenário: Pesquisando CPF's com restrições")
		public void comRestricoesCPFTest() {
		given().
        	contentType("application/json").
        	pathParam("cpf", restDTO.novaPesquisaRestricao("CPF-com-restricao")).
        when().
        	get(ENDPOINT).
        then().
        	statusCode(HttpStatus.SC_OK).log().all();
		
		
		}
	
	@Test
	@Description("Cenário: Pesquisando CPF's sem restrições")
		public void semRestricoesCPFTest() {
		given().
        	contentType("application/json").
        	pathParam("cpf", restDTO.novaPesquisaRestricao("CPF-sem-invalido")).
        when().
        	get(ENDPOINT).
        then().
        	statusCode(HttpStatus.SC_NO_CONTENT).log().all();
		
		
		}
}
