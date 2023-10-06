package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class Tests {
	@Test
	public void test_01() {
		
	
//		
	JSONObject request =new JSONObject();
		
		request.put("email", "merchant@foodics.com");
		request.put("password", "123456");
		request.put("token", "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO");

			baseURI="https://pay2.foodics.dev/cp_internal";
		given().
			header("Content-Type","application/json" ).contentType(ContentType.JSON).
			body(request.toJSONString()).	
		when().
			post("/login")
		.then()
			.statusCode(200).
		log().
		body();
		
	}
	@Test
	public void test_02() {
			baseURI="https://pay2.foodics.dev/cp_internal";
		given().
			header("token","3689|ruL5JonZVlAxj5agdqL1G7abGF0927zAHxt6qeSI").
			get("/whoami").
		then().
			log().
		all();
		//no explanation on how to use this endpoints tried multiple times with different idea
	}
	@Test
	public void test_03() {
	JSONObject request =new JSONObject();
		
		request.put("email", "Errort@foodics.com");
		request.put("password", "123456");
		request.put("token", "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO");
		
		System.out.println(request.toJSONString());
		
		
			baseURI="https://pay2.foodics.dev/cp_internal";
			given().
				header("Content-Type","application/json" ).contentType(ContentType.JSON).
				body(request.toJSONString()).	
			when().
				post("/login")
			.then()
				.statusCode(200).
				log().body();
		
	}

}
