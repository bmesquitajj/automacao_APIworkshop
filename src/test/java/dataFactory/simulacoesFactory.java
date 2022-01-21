package dataFactory;

import static io.restassured.RestAssured.given;
import static constants.simulacoesConstants.ENDPOINT;

import org.apache.http.HttpStatus;
import dto.POSTsimulacoesDTO;

public class simulacoesFactory {
	
	public void createSimu(POSTsimulacoesDTO novaSimulacao) {
        given().
        	body(novaSimulacao).
        	post(ENDPOINT).
        then().
        	statusCode(HttpStatus.SC_CREATED);
    }
	
	public void deleteSimu() {
        given().
        	delete(ENDPOINT).
        then().
        	statusCode(HttpStatus.SC_NO_CONTENT);
    }

    public String getCPFSimu() {
        return given().
        			get(ENDPOINT).
    			then().
        			extract().
        			path("");
    }
	
}
