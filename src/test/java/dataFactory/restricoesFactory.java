package dataFactory;

import static io.restassured.RestAssured.given;
import static constants.restricoesConstants.ENDPOINT;

import org.apache.http.HttpStatus;
import dto.GETrestricoesDTO;


public class restricoesFactory {
	
	public String getIdCPF() {
        return given().
        		get(ENDPOINT).
        		then().
        		extract().
        			path("");
    }
}
