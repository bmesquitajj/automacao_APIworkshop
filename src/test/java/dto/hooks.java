package dto;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.requestSpecification;


public class hooks {
	
	@BeforeAll
    public static void setup() {
		
    	RestAssured.baseURI = "http://localhost";
    	RestAssured.port = 8888;
//        port = Integer.valueOf(getProperty(PORT).trim());
        requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
    }
}
