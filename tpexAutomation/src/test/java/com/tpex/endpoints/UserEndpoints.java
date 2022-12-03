package com.tpex.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
		
	public static Response createUser(String payload) {
		RestAssured.baseURI = Routes.base_uri;
		Response response = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).
				when().post(Routes.postRequest);
		
		return response;
	}
	
	public static Response readUser(String userName) {
		RestAssured.baseURI = Routes.base_uri;
		Response response = RestAssured.given().pathParam("username", userName).
				when().get(Routes.getPutDeleteRequest);
	
		return response;
	}
	
}
